import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 * This class is the main program and creates the JFrame to paint all components on. 
 * It provides a while loop with various methods to continually repaint them across the frame.
 * The objective of the game is to avoid the asteroids and emerge with your ship in one piece.
 * 
 * @author henry
 * @version ETV 1.0
 * 
 */

public class Main {
	public static final int DELAY = 1;
	public static final int WINSIZE = 500;
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(WINSIZE, WINSIZE);
		frame.setTitle("ESCAPE THE VOID!");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		BackgroundComponent component = new BackgroundComponent();
		long oldTime=System.currentTimeMillis();
		frame.addKeyListener(component);
		frame.setVisible(true);
		frame.add(component);
		ImageIcon img = new ImageIcon("resources/icon.png");
		frame.setIconImage(img.getImage());
		frame.setResizable(false);
		Sound musicObject=new Sound();
		Sound musicObject1=new Sound();
			component.changeMusicState(true);
			musicObject.setLoop(true);
			musicObject.playMusic("resources/bg_music.wav");
			while(!component.asteroidCollision()) {
					long curTime=System.currentTimeMillis();
					long diff=curTime-oldTime;
					if(component.startScreen()) {
					component.update(diff);
					component.updateScore();
					}
					oldTime=curTime;
					frame.repaint();
					try {
						Thread.sleep(DELAY);
					}
					catch(InterruptedException e) {
					}
			}
		musicObject.stop();
		musicObject1.playMusic("resources/boom.wav");
		
		try {
			Thread.sleep(2000);
		}
		catch(InterruptedException e) {
		}
		musicObject1.playMusic("resources/lose.wav");
		component.setOverlay(true);
		frame.repaint();
		}
}

	


