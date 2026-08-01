import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Line2D;
import java.awt.Color;
import java.awt.Font;

/**
 * This class allows for the display of a game key to be drawn.
 * 
 * @author henry
 *
 */
public class GameOver{
	private int x;
	private int y;
	/**
	 * Constructs the overlay to display on the frame.
	 * @param x this will be the x position of the overlay
	 * @param y this will be the y position of the overlay
	 */
	public GameOver(int x,int y) {	
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
			
	//creates a frame cover that signals "Game Over"
		
		Rectangle overlay = new Rectangle(x,y,500,500);
		g2.setColor(Color.orange);
		g2.fill(overlay);
		Rectangle overlayBorder = new Rectangle(25,25,440,415);
		g2.setColor(Color.blue);
		g2.fill(overlayBorder);
		
	//creates a line border for the inner part of the frame	
		
		g2.setColor(Color.orange);
		Line2D.Double topBorder = new Line2D.Double(30,30,460,30);
		g2.draw(topBorder);
		Line2D.Double rightSideBorder = new Line2D.Double(460,30,460,435);
		g2.draw(rightSideBorder);
		Line2D.Double bottomBorder = new Line2D.Double(460,435,30,435);
		g2.draw(bottomBorder);
		Line2D.Double leftSideBorder = new Line2D.Double(30,435,30,30);
		g2.draw(leftSideBorder);
		g2.setColor(Color.black);
		g2.drawString("ESC. TO QUIT",400,17);
		Rectangle keyFrame = new Rectangle(x+165,y+50,150,100);
		g2.setColor(Color.orange);
		g2.fill(keyFrame);
		Rectangle keyBody = new Rectangle(x+170,y+55,140,90);
		g2.setColor(Color.blue);
		g2.fill(keyBody);
		g2.setColor(Color.white);
		g2.drawString("Game Key",x+208,y+67);
		g2.drawString("W: Moves You Up",x+173,y+77);
		g2.drawString("A: Moves You Left",x+173,y+87);
		g2.drawString("S: Moves You Down",x+173,y+97);
		g2.drawString("D: Moves You Right",x+173,y+107);
		g2.drawString("F: Activate Shield",x+173,y+117);
		
	//text to display that you lost
		
		Rectangle outerBorder = new Rectangle(x+55,y+180,380,100);
		g2.setColor(Color.orange);
		g2.fill(outerBorder);
		Rectangle innerBorder = new Rectangle(x+65,y+190,360,80);
		g2.setColor(Color.blue);
		g2.fill(innerBorder);
		g2.setColor(Color.orange);
		Font stringFont = new Font("SansSerif",Font.PLAIN,64);
		g2.setFont(stringFont);
		g2.drawString("Game Over",x+75,y+250);
		}	
	}	
