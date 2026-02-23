package com.henryroeth.escapethevoid;

import com.henryroeth.escapethevoid.rendering.Renderer;

import javax.swing.JFrame;

public class Main {
	
	// Set game constants
	public static final int FRAME_WIDTH = 800;
	public static final int FRAME_HEIGHT = 600;
	public static final String FRAME_TITLE = "Escape The Void";
	public static final int DELAY = 1;

	public static void main(String[] args) {
		// Initialize the frame
		JFrame frame = new JFrame();
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setTitle(FRAME_TITLE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		// Add the renderer to the frame
		Renderer renderer = new Renderer();
		frame.add(renderer);
		
		// Show the frame
		frame.setVisible(true);
		
		// Start the game loop
		long oldTime=System.currentTimeMillis();
		while(true) {
			long curTime=System.currentTimeMillis();
			long diff=curTime-oldTime;
			renderer.update(diff);
			oldTime=curTime;
			frame.repaint();
			try {
				Thread.sleep(DELAY);
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
