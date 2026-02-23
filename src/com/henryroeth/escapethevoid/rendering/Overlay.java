package com.henryroeth.escapethevoid.rendering;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Overlay {
	
	private int x;
	
	private int y;
	
	private int width;
	
	private int height;
	
	private OverlayState state = OverlayState.NONE;
	
	public Overlay(int width, int height) {
		this.x = 0;
		this.y = 0;
		this.width = width;
		this.height = height;
	}
	
	public void draw(Graphics g) {
		
		// Recover Graphics2D
		
		Graphics2D g2 =(Graphics2D) g;
		
		Rectangle background = new Rectangle(this.x, this.y, this.width, this.height);
		Color blur = new Color(0, 0, 0, 50);
		
		switch (this.state) {
			case START:
				// TBD
			case PAUSE:
				g2.setColor(blur);
				g2.fill(background);
			case INVENTORY:
				// TBD
			case GAME_OVER:
				// TBD
			default:
				break;
		}
			
	}
	
	public void setState(OverlayState state) {
		this.state = state;
	}
	
}
