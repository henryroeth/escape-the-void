package com.henryroeth.escapethevoid.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputHandler implements KeyListener {

    private boolean[] keys = new boolean[256];

    public boolean up, down, left, right, jump;

    public void update() {
        up = keys[KeyEvent.VK_W] || keys[KeyEvent.VK_UP];
        down = keys[KeyEvent.VK_S] || keys[KeyEvent.VK_DOWN];
        left = keys[KeyEvent.VK_A] || keys[KeyEvent.VK_LEFT];
        right = keys[KeyEvent.VK_D] || keys[KeyEvent.VK_RIGHT];
        jump = keys[KeyEvent.VK_SPACE];
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Not used
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() > 0 && e.getKeyCode() < keys.length) {
            keys[e.getKeyCode()] = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() > 0 && e.getKeyCode() < keys.length) {
            keys[e.getKeyCode()] = false;
        }
    }
}
