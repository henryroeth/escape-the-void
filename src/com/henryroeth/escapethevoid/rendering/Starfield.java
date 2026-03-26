package com.henryroeth.escapethevoid.rendering;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.List;

public class Starfield {
    
    private class Star {
        double x, y, speed, size;
        float alpha;
        double parallaxFactor;
        
        Star(int width, int height) {
            randomize(width, height, true);
        }
        
        void randomize(int width, int height, boolean randomY) {
            x = Math.random() * width;
            y = randomY ? Math.random() * height : -10;
            size = Math.random() * 2 + 1;
            speed = size * 0.2; // Falling speed
            parallaxFactor = size * 0.1; // Depth factor
            alpha = (float) (Math.random() * 0.5 + 0.3);
        }
        
        void update(int width, int height, double cameraDeltaX) {
            y += speed;
            x -= cameraDeltaX * parallaxFactor;
            
            // Warp horizontally
            if (x < 0) x = width;
            if (x > width) x = 0;
            
            // Warp vertically
            if (y > height) {
                randomize(width, height, false);
            }
        }
        
        void draw(Graphics2D g2) {
            g2.setColor(new Color(1f, 1f, 1f, alpha));
            g2.fill(new Ellipse2D.Double(x, y, size, size));
        }
    }
    
    private List<Star> stars;
    private int width, height;
    
    public Starfield(int width, int height, int count) {
        this.width = width;
        this.height = height;
        stars = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            stars.add(new Star(width, height));
        }
    }
    
    public void update(double cameraDeltaX) {
        for (Star star : stars) {
            star.update(width, height, cameraDeltaX);
        }
    }
    
    public void draw(Graphics2D g2) {
        for (Star star : stars) {
            star.draw(g2);
        }
    }
}
