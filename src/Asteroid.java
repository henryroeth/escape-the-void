
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.Graphics2D;
import java.awt.Color;

/**This class moves your asteroid to the x, y coordinates that is entered by the player.
 * 
 * @author henry
 *
 */
public class Asteroid {
	private double x,y;
	private double velocity=Math.random()*.3 + .15;
	/**
	 * Rectangle that is to be used to measure collision status.
	 */
	private Rectangle2D.Double rect;
	/**
	 * This is constructing the asteroid using the x position and y position.
	 * @param xPos this will have x be equal to the given x_position
	 * @param yPos this will have y be equal to the given y_position
	 */
	public Asteroid(int x, int y) {
		this.x = x;
		this.y = y;
		//collision rectangle is instantiated
		rect=new Rectangle2D.Double(x, y, 60, 60);
	}
	/**
	 * The graphics method to draw the asteroid.
	 * @param g Graphics to draw asteroid to frame
	 */
	public void draw(Graphics2D g) {
		
		Graphics2D g2=(Graphics2D) g;
		Color c=new Color(00,00,00,00);
		g2.setColor(c);
		g2.draw(rect);
		Ellipse2D.Double asteroidBase=new Ellipse2D.Double(x,y,60,60);
		g2.setColor(Color.gray);
		g2.fill(asteroidBase);
		g2.setColor(Color.black);
		g2.draw(asteroidBase);
		Ellipse2D.Double asteroidComponent=new Ellipse2D.Double(x+25,y-2,25,20);
		g2.setColor(Color.gray);
		g2.fill(asteroidComponent);
		g2.draw(asteroidComponent);
		g2.setColor(Color.black);
		g2.draw(asteroidComponent);
		g2.setColor(Color.gray);
		g2.fill(asteroidBase);
		Ellipse2D.Double asteroidComponent1=new Ellipse2D.Double(x+28,y+35,28,22);
		g2.setColor(Color.gray);
		g2.fill(asteroidComponent1);
		g2.draw(asteroidComponent1);
		g2.setColor(Color.black);
		g2.draw(asteroidComponent1);
		g2.setColor(Color.gray);
		g2.fill(asteroidBase);
		Ellipse2D.Double asteroidComponent2=new Ellipse2D.Double(x+42,y+15,20,20);
		g2.setColor(Color.gray);
		g2.fill(asteroidComponent2);
		g2.draw(asteroidComponent2);
		g2.setColor(Color.black);
		g2.draw(asteroidComponent2);
		g2.setColor(Color.gray);
		g2.fill(asteroidBase);
		Ellipse2D.Double asteroidComponent3 = new Ellipse2D.Double(x+5,y+1,20,20);
		g2.setColor(Color.gray);
		g2.fill(asteroidComponent3);
		g2.draw(asteroidComponent3);
		g2.setColor(Color.black);
		g2.draw(asteroidComponent3);
		g2.setColor(Color.gray);
		g2.fill(asteroidBase);
		Ellipse2D.Double asteroidComponent4 = new Ellipse2D.Double(x-2,y+25,20,20);
		g2.setColor(Color.gray);
		g2.fill(asteroidComponent4);
		g2.draw(asteroidComponent4);
		g2.setColor(Color.black);
		g2.draw(asteroidComponent4);
		g2.setColor(Color.gray);
		g2.fill(asteroidBase);
		Ellipse2D.Double asteroidComponent5=new Ellipse2D.Double(x+8,y+40,20,20);
		g2.setColor(Color.gray);
		g2.fill(asteroidComponent5);
		g2.draw(asteroidComponent5);
		g2.setColor(Color.black);
		g2.draw(asteroidComponent5);
		g2.setColor(Color.gray);
		g2.fill(asteroidBase);
		Color internalColor=new Color(70,70,70);
		g2.setColor(internalColor);
		Ellipse2D.Double asteroidComponent6=new Ellipse2D.Double(x+9,y+15,10,10);
		g2.fill(asteroidComponent6);
		Ellipse2D.Double asteroidComponent7=new Ellipse2D.Double(x+30,y+8,13,13);
		g2.fill(asteroidComponent7);
		Ellipse2D.Double asteroidComponent8=new Ellipse2D.Double(x+40,y+28,10,10);
		g2.fill(asteroidComponent8);
		Ellipse2D.Double asteroidComponent9=new Ellipse2D.Double(x+15,y+35,15,15);
		g2.fill(asteroidComponent9);
		Ellipse2D.Double asteroidComponent10=new Ellipse2D.Double(x+24,y+24,8,8);
		g2.fill(asteroidComponent10);
		g2.fillArc((int)x+20,(int)y+3,11,9,18,180);
		g2.fillArc((int)x+30,(int)y+48,15,8,200,180);
		g2.fillArc((int)x+42,(int)y+16,15,8,285,180);
		g2.fillArc((int)x+2,(int)y+28,15,8,100,180);
	}
	/**
	 * Method to move the asteroid.
	 * @param diff
	 */
	public void moveAsteroid(long diff) {
		x=x+(-velocity*diff);
		rect.x=x;
	}
	/**
	 * Method to get the x position of the asteroid.
	 * @return X position.
	 */
	public double getX() {
		return this.x;
	}
	/**
	 * Method to get the y position of the asteroid.
	 * @return Y position of the asteroid.
	 */
	public double getY() {
		return this.y;
	}
	public void setX(double x) {
		this.x = x;
	}
	public void setY(double y) {
		this.y = y;
	}
	/**
	 * Method to get the bounds of the transparent rectangle that acts as the boundary in determining collision.
	 * @return The bounds of the rectangle.
	 */
	public Rectangle2D.Double getBoundingBox() {
		return rect;
	}	
}
	



