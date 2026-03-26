package com.henryroeth.escapethevoid;

import com.henryroeth.escapethevoid.input.InputHandler;
import com.henryroeth.escapethevoid.rendering.Renderer;

import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.Dimension;

public class Main {
	
	// Set game constants
	public static final int FRAME_WIDTH = 800;
	public static final int FRAME_HEIGHT = 600;
	public static final String FRAME_TITLE = "Escape The Void";
	
	public static void main(String[] args) {
		// Initialize the frame
		JFrame frame = new JFrame();
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setTitle(FRAME_TITLE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		
		// Initialize InputHandler
		InputHandler inputHandler = new InputHandler();
		frame.addKeyListener(inputHandler);
		
		// Add the renderer to the frame
		Renderer renderer = new Renderer(inputHandler);
		frame.add(renderer);
		
		// Show the frame
		frame.setVisible(true);
		
		// Game Loop
		final double nsPerTick = 1000000000.0 / 60.0;
		long lastTime = System.nanoTime();
		double delta = 0;
		
		while (true) {
			long now = System.nanoTime();
			delta += (now - lastTime) / nsPerTick;
			lastTime = now;
			
			boolean shouldRender = false;
			
			while (delta >= 1) {
				inputHandler.update();
				renderer.update();
				delta--;
				shouldRender = true;
			}
			
			if (shouldRender) {
				renderer.repaint();
			}
			
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
