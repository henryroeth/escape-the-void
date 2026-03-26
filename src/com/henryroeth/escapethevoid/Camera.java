package com.henryroeth.escapethevoid;

import com.henryroeth.escapethevoid.entities.Player;

public class Camera {
	
	public double x, y;
	private int frameWidth, frameHeight;
	
	public Camera(int frameWidth, int frameHeight) {
		this.frameWidth = frameWidth;
		this.frameHeight = frameHeight;
	}
	
	public void update(Player player) {
		// Follow player, center on screen
		x = player.x - (frameWidth / 2.0);
		y = player.y - (frameHeight / 2.0);
	}
}
