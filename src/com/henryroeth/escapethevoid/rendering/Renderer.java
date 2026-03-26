package com.henryroeth.escapethevoid.rendering;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import com.henryroeth.escapethevoid.Camera;
import com.henryroeth.escapethevoid.GameState;
import com.henryroeth.escapethevoid.LevelLoader;
import com.henryroeth.escapethevoid.entities.Platform;
import com.henryroeth.escapethevoid.entities.Player;
import com.henryroeth.escapethevoid.input.InputHandler;

public class Renderer extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private Player player;
	private Camera camera;
	private InputHandler input;
	private Starfield starfield;
	private List<Platform> platforms;
	private GameState state = GameState.MENU;
	
	public Renderer(InputHandler input) {
		this.input = input;
		this.setBackground(Color.BLACK);
		this.starfield = new Starfield(800, 600, 100);
		this.camera = new Camera(800, 600);
		resetGame();
	}
	
	private void resetGame() {
		LevelLoader.LevelData level = LevelLoader.loadLevel("level1.txt");
		if (level != null && level.player != null) {
			this.player = level.player;
			this.platforms = level.platforms;
		} else {
			// Fallback if level not found or player not specified
			this.player = new Player(100, 400);
			this.platforms = new ArrayList<>();
			if (level != null) {
				this.platforms = level.platforms;
			} else {
				platforms.add(new Platform(0, 550, 800, 50, Color.CYAN));
			}
		}
		this.camera.update(player);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
			
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		// Always draw starfield in background (drawn at fixed position)
		this.starfield.draw(g2);
		
		if (state == GameState.MENU) {
			drawMenu(g2);
		} else if (state == GameState.PLAYING) {
			// Translation for camera
			g2.translate(-camera.x, -camera.y);
			
			// Draw Platforms
			for (Platform p : platforms) {
				p.draw(g2);
			}
			// Draw Player
			this.player.draw(g2);
			
			// Reset translation for any UI elements
			g2.translate(camera.x, camera.y);
		} else if (state == GameState.GAME_OVER) {
			drawGameOver(g2);
		}
		
		g2.dispose();
	}
	
	private void drawMenu(Graphics2D g2) {
		g2.setColor(Color.WHITE);
		g2.setFont(new Font("Arial", Font.BOLD, 40));
		String title = "ESCAPE THE VOID";
		int titleWidth = g2.getFontMetrics().stringWidth(title);
		g2.drawString(title, (800 - titleWidth) / 2, 200);
		
		g2.setFont(new Font("Arial", Font.PLAIN, 20));
		String msg = "Press SPACE to Start";
		int msgWidth = g2.getFontMetrics().stringWidth(msg);
		g2.drawString(msg, (800 - msgWidth) / 2, 300);
	}
	
	private void drawGameOver(Graphics2D g2) {
		g2.setColor(Color.RED);
		g2.setFont(new Font("Arial", Font.BOLD, 40));
		String title = "GAME OVER";
		int titleWidth = g2.getFontMetrics().stringWidth(title);
		g2.drawString(title, (800 - titleWidth) / 2, 250);
		
		g2.setColor(Color.WHITE);
		g2.setFont(new Font("Arial", Font.PLAIN, 20));
		String msg = "Press SPACE to Restart";
		int msgWidth = g2.getFontMetrics().stringWidth(msg);
		g2.drawString(msg, (800 - msgWidth) / 2, 350);
	}
	
	public void update() {
		if (state == GameState.MENU) {
			this.starfield.update(0);
			if (input.jump) {
				state = GameState.PLAYING;
				resetGame();
			}
		} else if (state == GameState.PLAYING) {
			this.player.update(input, platforms);
			
			double prevCameraX = camera.x;
			this.camera.update(player);
			double cameraDeltaX = camera.x - prevCameraX;
			
			this.starfield.update(cameraDeltaX);
			
			// Check for Game Over (falling off)
			if (player.y > 1500) { // Increased death zone for larger level
				state = GameState.GAME_OVER;
			}
		} else if (state == GameState.GAME_OVER) {
			this.starfield.update(0);
			if (input.jump) {
				state = GameState.PLAYING;
				resetGame();
			}
		}
	}
}
