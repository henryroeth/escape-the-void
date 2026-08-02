import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.Color;
import java.awt.Font;

/**
 * This class allows for the display of a game key to be drawn.
 * 
 * @author henry
 *
 */
public class StartScreen {
	Spaceship s=new Spaceship(140, 92, 0, 0, Color.orange, Color.gray);
	private int x;
	private int y;
	/**
	 * Constructs the overlay to display on the frame.
	 * @param x this will be the x position of the overlay
	 * @param y this will be the y position of the overlay
	 */
	public StartScreen(int x,int y) {	
		this.x=x;
		this.y=y;
	}
	/**
	 * The main method to draw the key.
	 * @param g Graphics to draw key to frame 
	 */
	public void draw(Graphics g) throws InterruptedException {
		
	//recovers Graphics2D
			
		Graphics2D g2=(Graphics2D) g;
		Graphics g1=(Graphics) g;
		
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
		
		//creates text to indicate the objective and how to exit the game
		
		
		
		
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
		Rectangle star12 = new Rectangle(150, 300, 7, 7);
		g2.setColor(Color.white);
		g2.fill(star12);
		Rectangle star13 = new Rectangle(300, 290, 7, 7);
		g2.setColor(Color.white);
		g2.fill(star13);
		Rectangle star14 = new Rectangle(200, 400, 7, 7);
		g2.setColor(Color.white);
		g2.fill(star14);	
	//creates a frame cover that signals "Game Over"
		
	//creates a line border for the inner part of the frame	
		Key k=new Key(255,55);
		k.draw(g2);
		g2.setColor(Color.black);
		g2.drawString("ESC. TO QUIT",400,17);
		Rectangle keyFrame = new Rectangle(x+80,y+55,150,100);
		g2.setColor(Color.orange);
		g2.fill(keyFrame);
		Rectangle keyBody = new Rectangle(x+85,y+60,140,90);
		g2.setColor(Color.blue);
		g2.fill(keyBody);
		g1.setColor(Color.white);
		g1.drawString("C TO CYCLE COLORS",x+92,y+76);
		
		
	//text to display that you lost
		
		Rectangle outerBorder = new Rectangle(x+55,y+180,380,100);
		g2.setColor(Color.orange);
		g2.fill(outerBorder);
		Rectangle innerBorder = new Rectangle(x+65,y+190,360,80);
		g2.setColor(Color.blue);
		g2.fill(innerBorder);
		g2.setColor(Color.orange);
		Font stringFont = new Font("SansSerif",Font.PLAIN,38);
		g2.setFont(stringFont);
		g2.drawString("ESCAPE THE VOID!",x+70,y+244);
		Rectangle outerBorder1 = new Rectangle(x+137,y+320,210,55);
		g2.setColor(Color.orange);
		g2.fill(outerBorder1);
		Rectangle innerBorder1 = new Rectangle(x+142,y+325,200,45);
		g2.setColor(Color.blue);
		g2.fill(innerBorder1);
		g2.setColor(Color.orange);
		Font stringFont1 = new Font("SansSerif",Font.PLAIN,18);
		g2.setFont(stringFont1);
		g2.drawString("\"ENTER\" TO START",x+155,y+355);
		}
	public Spaceship startShip() {
		return s;
	}
	}	
