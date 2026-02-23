package com.henryroeth.escapethevoid.rendering;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JComponent;

import com.henryroeth.escapethevoid.entities.Player;

public class Renderer extends JComponent {
	
	private static final long serialVersionUID = 1L;
	
	private Player player;
	
	private Overlay overlay;

	public Renderer () {
		
		// Create the player
		this.player = new Player(25,75);
		
		// Create the overlay
		this.overlay = new Overlay(800, 600);
		
	}
	
	public void paintComponent(Graphics g) {
			
		// Recover Graphics2D
		Graphics2D g2=(Graphics2D) g;
		
		// Draw the overlay
		this.overlay.setState(OverlayState.PAUSE);
		this.overlay.draw(g2);
		
		// Draw the player
		
		Rectangle testRectangle = new Rectangle(0, 0, 50, 50);
		g2.setColor(Color.orange);
		g2.fill(testRectangle);
		
		this.player.draw(g2);
	}
	
	public void update(long diff) {
		this.player.update(diff);
	}
		
}
