package com.henryroeth.escapethevoid.entities;

import com.henryroeth.escapethevoid.input.InputHandler;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class Player {
    
    public double x, y;
    public double velX, velY;
    public static final int WIDTH = 30;
    public static final int HEIGHT = 30;
    
    private final double SPEED = 5.0;
    private final double JUMP_FORCE = -12.0;
    private final double GRAVITY = 0.5;
    
    private int jumpCount = 0;
    private boolean jumpKeyPressed = false;
    
    // For visual flare
    private Color coreColor = new Color(200, 200, 255);
    private Color glowColor = new Color(0, 255, 255, 100);

    public Player(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    public void update(InputHandler input, java.util.List<Platform> platforms) {
        // Horizontal Movement
        if (input.left) velX = -SPEED;
        else if (input.right) velX = SPEED;
        else velX = 0;
        
        // Apply Horizontal Velocity
        x += velX;
        
        // Horizontal Collision
        for (Platform p : platforms) {
            if (getBounds().intersects(p.getBounds())) {
                if (velX > 0) x = p.x - WIDTH;
                else if (velX < 0) x = p.x + p.width;
                velX = 0;
            }
        }
        
        // Gravity
        velY += GRAVITY;
        
        // Apply Vertical Velocity
        y += velY;
        
        boolean onGround = false;
        
        // Vertical Collision
        for (Platform p : platforms) {
            if (getBounds().intersects(p.getBounds())) {
                if (velY > 0) { // Falling
                    y = p.y - HEIGHT;
                    velY = 0;
                    onGround = true;
                    jumpCount = 0; // Reset jump count when touching ground
                } else if (velY < 0) { // Jumping up
                    y = p.y + p.height;
                    velY = 0;
                }
            }
        }
        
        // Jumping Logic
        if (input.jump) {
            if (!jumpKeyPressed) { // Only jump on initial press
                if (onGround || jumpCount < 2) {
                    velY = JUMP_FORCE;
                    jumpCount++;
                    
                    // Visual feedback for double jump
                    if (jumpCount == 2) {
                        coreColor = new Color(255, 255, 150); // Flash yellow on double jump
                    }
                }
            }
            jumpKeyPressed = true;
        } else {
            jumpKeyPressed = false;
            // Transition color back to normal
            coreColor = new Color(200, 200, 255);
        }
        
        // Bounds Checking
        // Removed clamping to allow world traversal
        // if (x < 0) x = 0;
        // if (x > 800 - WIDTH) x = 800 - WIDTH;
    }
    
    public java.awt.Rectangle getBounds() {
        return new java.awt.Rectangle((int)x, (int)y, WIDTH, HEIGHT);
    }
    
    public void draw(Graphics2D g2) {
        // Draw Glow
        g2.setColor(glowColor);
        g2.setStroke(new BasicStroke(4f));
        g2.draw(new Rectangle2D.Double(x, y, WIDTH, HEIGHT));
        
        // Draw Core
        g2.setColor(coreColor);
        g2.setStroke(new BasicStroke(1.5f));
        g2.draw(new Rectangle2D.Double(x, y, WIDTH, HEIGHT));
        
        // Simple Thruster Effect
        if (Math.abs(velX) > 0.1 || velY < 0) {
            g2.setColor(new Color(255, 100, 0, 150));
            double centerX = x + WIDTH / 2.0;
            double bottomY = y + HEIGHT;
            g2.fill(new Rectangle2D.Double(centerX - 4, bottomY, 8, 10 + Math.random() * 5));
        }
    }
}
