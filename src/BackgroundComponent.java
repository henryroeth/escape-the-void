import java.awt.Graphics;
import java.awt.geom.Ellipse2D;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.geom.Line2D;
import javax.swing.JComponent;
import java.awt.event.KeyListener;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;


/**
 * This class is the background component that extends 
 * JComponent and implements the KeyListener and ActionListener for user interaction.
 * 
 * @author henry
 *
 */
//comment
public class BackgroundComponent extends JComponent implements ActionListener, KeyListener {
	private boolean bulletState=false;
	private boolean musicState=false;
	private static final long serialVersionUID = 1L;
	//HighScore scoreObject=new HighScore("C:\\Users\\henry\\eclipse-workspace\\Joke\\src\\ETV_Scores.txt");
	//highScore not implemented with file i/o yet
	private static int SCOREPOS=203;
	private Sound musicObject=new Sound();
	//private int highScore;//=Integer.parseInt(scoreObject.getScore());
	private int score;
	private int numShields=0;
	/**
	 * This field creates a boolean variable to be used to set the condition in drawing the overlay.
	 */
	private boolean gameOver=false;
	
	private boolean startState=false;
	private StartScreen startScreen=new StartScreen(0,0);;
	//private Color color;
	/**
	 * The overlay for when the game is over.
	 */
	private GameOver overlay;
	/**
	 * The spaceship.
	 */
	private Spaceship s;
	/**
	 * The key.
	 */
	private Key k;
	/**
	 * Array list of asteroids.
	 */
	private ArrayList<Asteroid> aBelt;
	private ArrayList<Asteroid> aBelt1;
	private ArrayList<Shield> shields;
	private ArrayList<Bullet> bullets;
	private ArrayList<Ammo> ammo;
	/**
	 * New asteroid to be set equal to an index of the aBelt array list.
	 */
	private Asteroid newAsteroid;
	private Shield newShield;
	private Ammo newAmmo;
	/**
	 * This is constructing the creation of objects to paint 
	 * from the Asteroid and NASASpaceship classes.
	 */
	public BackgroundComponent() {
		
		Timer t = new Timer(10, this);
		
		//initializes a new ArrayList from the field aBelt of type Asteroid
		
		aBelt=new ArrayList<Asteroid>();
		aBelt1=new ArrayList<Asteroid>();
		shields=new ArrayList<Shield>();
		bullets=new ArrayList<Bullet>();
		ammo=new ArrayList<Ammo>();
		
		/*a loop to create 81 asteroids starting at the x position of 1000 
		*and incrementing by 200 for each and set to a random y position
		*/
		
		for(int xPos=1000; xPos<=400000; xPos+=200) {
			aBelt.add(new Asteroid(xPos, (int)(Math.random()*400)));
		}
		for(int xPos=1500; xPos<=105000; xPos+=1500) {
			shields.add(new Shield(xPos, (int)(Math.random()*400)));
		}
		for(int xPos=1500; xPos<=105000; xPos+=2500) {
			ammo.add(new Ammo(xPos, (int)(Math.random()*400)));
		}
		
		//initializes a new overlay from the field overlay of type GameOver
		
		overlay=new GameOver(0,0);
		
		
		//initializes a new key from the field k of type Key
		
		k=new Key(-500,-500);
		
		//initializes a new spaceship from the field s of type NASASpaceship
		s=new Spaceship(140, 100, 0, 0, new Color(225, 0, 0), Color.gray);
		//adds the KeyListener 
		
		addKeyListener(this);
		setFocusable(true);
		
		//starts the timer to be used in the ActionEvent method for the method moveAsteroid()
		
		t.start();
	}
	public boolean getMusicState() {
		return musicState;
	}
	public void changeMusicState(boolean musicState) {
		this.musicState=musicState;
	}
	/**
	 * Method to paint onto the background.
	 * @param g
	 */
	
	public void paintComponent(Graphics g) {
		
		//recovers Graphics2D
		
		Graphics2D g2=(Graphics2D) g;
		
		//recovers Graphics
		
		Graphics g1=(Graphics) g;
		
		//creates border within frame and fills in the rest of the area with a black space background
		
		Rectangle borderFillColor = new Rectangle(0, 0, 500, 500);
		g2.setColor(Color.orange);
		g2.fill(borderFillColor);
		Rectangle space = new Rectangle(25, 25, 440, 415);
		g2.setColor(Color.black);
		g2.fill(space);
		
		//creates a nice line within the inner part of the border
		
		g2.setColor(Color.blue);
		Line2D.Double topBorder = new Line2D.Double(30, 30, 460, 30);
		g2.draw(topBorder);
		Line2D.Double rightSideBorder = new Line2D.Double(460, 30, 460, 435);
		g2.draw(rightSideBorder);
		Line2D.Double bottomBorder = new Line2D.Double(460, 435, 30, 435);
		g2.draw(bottomBorder);
		Line2D.Double leftSideBorder = new Line2D.Double(30, 435, 30, 30);
		g2.draw(leftSideBorder);
		
		//Draws portal
		
		Ellipse2D.Double outerLayer = new Ellipse2D.Double(125, 125, 225, 225);
		g2.draw(outerLayer);
		g2.setColor(Color.red);
		g2.fill(outerLayer);
		Ellipse2D.Double layer2 = new Ellipse2D.Double(137, 137, 200, 200);
		g2.draw(layer2);
		g2.setColor(Color.green);
		g2.fill(layer2);
		Ellipse2D.Double layer3 = new Ellipse2D.Double(149, 149, 175, 175);
		g2.draw(layer3);
		g2.setColor(Color.red);
		g2.fill(layer3);
		Ellipse2D.Double layer4 = new Ellipse2D.Double(161, 161, 150, 150);
		g2.draw(layer4);
		g2.setColor(Color.green);
		g2.fill(layer4);
		Ellipse2D.Double layer5 = new Ellipse2D.Double(173, 173, 125, 125);	
		g2.draw(layer5);
		g2.setColor(Color.blue);
		g2.fill(layer5);
		Ellipse2D.Double layer6= new Ellipse2D.Double(185, 185, 100, 100);
		g2.draw(layer6);
		g2.setColor(Color.blue);
		g2.fill(layer6);
		
		//creates text to indicate the objective and how to exit the game
		
		Rectangle gameStartOuterLayer = new Rectangle(145, 380, 197, 50);
		g2.draw(gameStartOuterLayer);
		g2.setColor(Color.orange); 
		g2.fill(gameStartOuterLayer);
		Rectangle gameStartInnerLayer = new Rectangle(150, 385, 187, 40);
		g2.draw(gameStartInnerLayer);
		g2.setColor(Color.black);
		g2.fill(gameStartInnerLayer);
		g2.fill(gameStartInnerLayer);
		g1.setColor(Color.orange);
		g1.drawString("   AVOID THE ASTEROIDS!", 165, 407);
		g1.setColor(Color.black);
		g1.drawString("ESC. TO QUIT", 400, 17);
		g1.drawString("HOLD SPACE TO TOGGLE GAME KEY", 5, 17);
		g2.drawString("SHIELDS LEFT: "+numShields,250,17);
		
		//Displays stars in the background
		
		Rectangle star = new Rectangle(150, 100, 7, 7);
		g2.setColor(Color.white);
		g2.fill(star);
		Rectangle star1 = new Rectangle(60, 150, 7, 7);
		g2.setColor(Color.white);
		g2.fill(star1);
		Rectangle star2 = new Rectangle(80, 50, 7, 7);
		g2.setColor(Color.white);
		g2.fill(star2);
		Rectangle star3 = new Rectangle(80, 250, 7, 7);
		g2.setColor(Color.white);
		g2.fill(star3);
		Rectangle star4 = new Rectangle(260, 47, 7, 7);
		g2.setColor(Color.white);
		g2.fill(star4);
		Rectangle star5 = new Rectangle(350, 125, 7, 7);
		g2.setColor(Color.white);
		g2.fill(star5);
		Rectangle star6 = new Rectangle(410, 76, 7, 7);
		g2.setColor(Color.white);
		g2.fill(star6);
		Rectangle star7 = new Rectangle(400, 220, 7, 7);
		g2.setColor(Color.white);
		g2.fill(star7);
		Rectangle star8 = new Rectangle(430, 335, 7, 7);
		g2.setColor(Color.white);
		g2.fill(star8);
		Rectangle star9 = new Rectangle(372, 405, 7, 7);
		g2.setColor(Color.white);
		g2.fill(star9);
		Rectangle star10 = new Rectangle(240, 360, 7, 7);
		g2.setColor(Color.white);
		g2.fill(star10);
		Rectangle star11 = new Rectangle(75, 370, 7, 7);
		g2.setColor(Color.white);
		g2.fill(star11);
		g2.setColor(Color.orange);
		
		g2.drawString("Score: "+score,SCOREPOS,237);
		if(score>=1000)
			SCOREPOS=201;
		if(score>=10000)
			SCOREPOS=199;
		if(score>=100000)
			SCOREPOS=197;
		if(score>=1000000)
			SCOREPOS=195;
		/*try {
			Scanner inFile =new Scanner(new File("HighScore.txt"));
			int number=0;
			number=inFile.nextInt();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		
		/*gets the index of each asteroid in the ArrayList aBelt and 
		incrementally draws a separate asteroid from each index*/
		
		for(int index=0;index<=999;index++) {
			newAsteroid=aBelt.get(index);
			newAsteroid.draw(g2);
		}
		for(int index=0;index<=68;index++) {
			newShield=shields.get(index);
			newShield.draw(g2);
		}
			
		//draws the game key
		
		k.draw(g2);
		
		//draws spaceship 
		
		if(!startState) {
			try {
				startScreen.draw(g2);
				s.draw(g2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
			s.draw(g2);
			
		
		//draws the overlay under the condition that the boolean instance variable gameOver is true
			if (gameOver)
			{
				try {
					overlay.draw(g2);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				Font stringFont = new Font("SansSerif",Font.PLAIN,20);
				g2.setFont(stringFont);
				g2.drawString("Your Score: "+score,SCOREPOS - 40,350);
				if(NumberFileHandler.readNumberFromFile() < score) {
					g2.drawString("High Score: "+score,SCOREPOS - 40,370);
					NumberFileHandler.saveNumberToFile(score);
				} else {
					g2.drawString("High Score: "+NumberFileHandler.readNumberFromFile(),SCOREPOS - 40,370);
				}
				
			}
			for(int index=0;index<=68;index++) {
				newShield=shields.get(index);
				if(s.getBoundingBox().intersects(newShield.getBoundingBox())) {
					shields.remove(newShield);
					numShields+=1;
					k.setShield(numShields);
					try {
						Thread.sleep(50);
					}
					catch(InterruptedException e) {
					}
					musicObject.playMusic("resources/get_shield.wav");
					shields.add(newShield);
				}
			}
			for(int index=0;index<=40;index++) {
				newAmmo=ammo.get(index);
				if(s.getBoundingBox().intersects(newAmmo.getBoundingBox())) {
					ammo.remove(newAmmo);
					
					
					try {
						Thread.sleep(50);
					}
					catch(InterruptedException e) {
					}
					musicObject.playMusic("resources/get_shield.wav");
					ammo.add(newAmmo);
				}
			}
		}
	
	/**
	 * This method sets the boolean instance variable to the boolean variable parameter.
	 * @param Overlay
	 */
	
	public void setOverlay(boolean overlay) {
		gameOver = overlay;
	}
	/**
	 * Method to move asteroids across the screen. 
	 * @param diff
	 */
	public void update(long diff) {
		for(int index=0;index<=999;index++) {
			newAsteroid=aBelt.get(index);
			newAsteroid.moveAsteroid(diff);
		}
		for(int index=0;index<=68;index++) {
			newShield=shields.get(index);
			newShield.moveShield(diff);
		}
		for(int index=0;index<=40;index++) {
			newAmmo=ammo.get(index);
			newAmmo.moveAmmo(diff);
		}
	}
	public void updateScore() {
		score+=1;
	}
	/**
	 * Method to check if each asteroid from the ArrayList has collided with the spaceship.
	 * @return
	 */
	public boolean asteroidCollision() {
		boolean Collision = false;
		for(int index=0;index<=999;index++) {
				newAsteroid=aBelt.get(index);
				if(s.getBoundingBox().intersects(newAsteroid.getBoundingBox())&&!s.getShieldState()) {
					Collision = true;
					s.drawExplosion(true);
					repaint();
				}
				if(s.getBoundingBox().intersects(newAsteroid.getBoundingBox())&&s.getShieldState()) { 
					s.drawShield(false);
					aBelt.remove(newAsteroid);
					try {
						Thread.sleep(50);
					}
					catch(InterruptedException e) {
					}
					musicObject.playMusic("resources/lose_shield.wav");
					aBelt.add(newAsteroid);
				}
				
		}
		
		return Collision;
	}
	public boolean startScreen() {
		return startState;
	}
	/**
	 * Method to activate the moveSpacehip method
	 * upon corresponding user interaction.
	 * @param e
	 */
	public void actionPerformed(ActionEvent e) {	
		s.moveSpaceship();	
	}
	/**
	 * Unimplemented method for when there is a key typed.
	 * @param e KeyEvent object to get the key code of each case.
	 */
	public void keyTyped(KeyEvent e) {}
	/**
	 * Method for when there is a key pressed.
	 * @param e KeyEvent object to get the key code of each case.
	 */
	public void keyPressed(KeyEvent e) {	
		switch(e.getKeyCode()) {
		case KeyEvent.VK_W:
			if(startState)
			s.setDy(-3);
			break;
		case KeyEvent.VK_A:
			if(startState)
			s.setDx(-3);
			break;
		case KeyEvent.VK_S:
			if(startState)
			s.setDy(3);
			break;
		case KeyEvent.VK_D:
			if(startState)
			s.setDx(3);
			break;
		case KeyEvent.VK_C:
			if(!startState)
			s.changeColor();
			break;
		case KeyEvent.VK_ESCAPE:
			System.exit(0);
			break;
		case KeyEvent.VK_SPACE:
			if(startState)
			k.moveKey(35, 35);
			break;
		}
	}
	/**
	 * Method for when there is a key is released.
	 * @param e KeyEvent object to get the key code of each case.
	 */
	public void keyReleased(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_W:
			s.setDy(0);
			break;
		case KeyEvent.VK_A:
			s.setDx(0);
			break;
		case KeyEvent.VK_S:
			s.setDy(0);
			break;
		case KeyEvent.VK_D:
			s.setDx(0);
			break;
		case KeyEvent.VK_Q:
			
			break;
		case KeyEvent.VK_F:
			if(numShields>0&&!s.getShieldState()) {
				s.drawShield(true);
				numShields-=1;
				k.setShield(numShields);
				musicObject.playMusic("resources/shield.wav");
			}
			break;
		case KeyEvent.VK_ENTER:
			startState=true;
			break;
		case KeyEvent.VK_SPACE:
			k.moveKey(-500, -500);
			break;
		}
	}
}


