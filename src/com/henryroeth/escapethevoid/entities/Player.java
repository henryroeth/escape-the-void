package com.henryroeth.escapethevoid.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class Player {
	private int x;
	
	private int y;
	
	public Player (int x, int y) {
		this.x = x;
		this.y = y;
		
	}
	
	public void update(long diff) {
		this.x += diff*0.5;
	}
	
	public void draw(Graphics g) {
		
		// Recover Graphics2D
		
		Graphics2D g2=(Graphics2D) g;
		
		Ellipse2D.Double ellipse =new Ellipse2D.Double(x,y,25,25);
		g2.setColor(Color.orange);
		g2.fill(ellipse);
			
	}
	
}
