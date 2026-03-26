package com.henryroeth.escapethevoid.entities;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Platform {
    public int x, y, width, height;
    private Color color;

    public Platform(int x, int y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public void draw(Graphics2D g2) {
        // Neon Glow
        g2.setColor(new Color(color.getRed(), color.getGreen(), color.getBlue(), 50));
        g2.setStroke(new BasicStroke(6f));
        g2.drawRect(x, y, width, height);
        
        // Inner Border
        g2.setColor(color);
        g2.setStroke(new BasicStroke(2f));
        g2.drawRect(x, y, width, height);
        
        // Fill (Semi-transparent)
        g2.setColor(new Color(color.getRed(), color.getGreen(), color.getBlue(), 20));
        g2.fillRect(x, y, width, height);
    }
    
    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
}
