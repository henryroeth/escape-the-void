
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Color;

/**
 * This class allows for the display of a game key to be drawn.
 * 
 * @author henry
 *
 */
public class Key{
	private int x;
	private int y;
	private int shields;
	/**
	 * Constructs the key to display on the frame.
	 * @param x this will be the x position of the key
	 * @param y this will be the y position of the key
	 */
	public Key(int x,int y) {	
		this.x=x;
		this.y=y;
		}
	/**
	 * The main method to draw the key.
	 * @param g Graphics to draw key to frame
	 */
	public void draw(Graphics g) {
		
	//recovers Graphics2D
			
		Graphics2D g2=(Graphics2D) g;
		
	//recovers Graphics
			
		Graphics g1=(Graphics) g;
			
	//creates a key that displays all of the controls in the game
			
		Rectangle keyFrame=new Rectangle(x,y,150,100);
		g2.setColor(Color.orange);
		g2.fill(keyFrame);
		Rectangle keyBody=new Rectangle(x+5,y+5,140,90);
		g2.setColor(Color.blue);
		g2.fill(keyBody);
		g1.setColor(Color.white);
		g1.drawString("Game Key",x+46,y+17);
		g1.drawString("W: Moves You Up",x+8,y+27);
		g1.drawString("A: Moves You Left",x+8,y+37);
		g1.drawString("S: Moves You Down",x+8,y+47);
		g1.drawString("D: Moves You Right",x+8,y+57);
		g1.drawString("F: Activate Shield(" + Integer.toString(shields) + ")",x+8,y+67);	
		
	}	
	/**
	 * Method to toggle the key on and off the screen.
	 * @param keyXLoc
	 * @param keyYLoc
	 */
	public void moveKey(int keyXLoc,int keyYLoc) {
		this.x=keyXLoc;
		this.y=keyYLoc;
	}
	
	public void setShield(int shields) {
		this.shields = shields;
	}
}
