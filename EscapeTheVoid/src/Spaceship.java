
import java.awt.Graphics;
import java.awt.geom.Ellipse2D;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

/**This class moves your spaceship to the x, y coordinates 
 * that is entered and sets a default color to the body and outer flame.
 * 
 * @author henry
 *
 */
public class Spaceship {
	private Color randomColor;
	private Color color1;
	private Color color;
	private int dx,dy;
	protected int x,y;
	private double x1,y1;
	/**
	 * Rectangle that is to be used to measure collision status.
	 */
	private Rectangle2D.Double rect = new Rectangle2D.Double(x,y,50,25);
	private Ellipse2D.Double bulletRect = new Ellipse2D.Double(x1+35,y1+10,10,5);
	/**
	 * State of the explosion to determine when to paint it on top of the spaceship.
	 */
	private boolean explosionState=false;
	private boolean shieldState=false;
	/**
	 * This is constructing a spaceship using the position of x, y, how they change, 
	 * and the color of various spaceship graphic components.
	 * @param x this will have x be equal to the given x_position
	 * @param y this will have y be equal to the given y_position
	 * @param dx this will set the initial change in x
	 * @param dx this will set the initial change in y
	 * @param color this will set the initial color of the spaceship body
	 * @param color1 this will set the initial color of the outer flame
	 */
	public Spaceship(int x,int y,int dx,int dy,Color color,Color color1) {
		this.color1=color1;
		this.color=color;
		this.dx=dx;
		this.dy=dy;
		this.x=x;
		this.y=y;
		
	}
	
	public Spaceship() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * The main method to draw the spaceship.
	 * @param g Graphics to draw spaceship to frame
	 */
	public void draw(Graphics g) {
		
	//recovers Graphics2D
		
		Graphics2D g2=(Graphics2D) g;
		
	//creates spaceship body
		
		Color c=new Color(00,00,00,00);
		g2.setColor(c);
		g2.draw(rect);
		Ellipse2D.Double spaceshipNose=new Ellipse2D.Double(x+25,y,40,25);
		g2.setColor(Color.white);
		g2.fill(spaceshipNose);
		Ellipse2D.Double spaceshipNoseComponent=new Ellipse2D.Double(x+25,y,40,25);
		g2.setColor(Color.black);
		g2.draw(spaceshipNoseComponent);
		Rectangle spaceshipBorder=new Rectangle(x,y,50,25);
		g2.setColor(this.color1);
		g2.fill(spaceshipBorder);
		Rectangle spaceshipComponent=new Rectangle(x,y+20,50,5);
		Color bottomColor=new Color(236, 129, 19);
		g2.setColor(bottomColor);
		g2.fill(spaceshipComponent);
		Line2D.Double spaceshipComponent1=new Line2D.Double(x,y,x+50,y);
		g2.setColor(Color.black);
		g2.draw(spaceshipComponent1);
		Line2D.Double spaceshipComponent2=new Line2D.Double(x+50,y,x+50,y+25);
		g2.draw(spaceshipComponent2);
		Line2D.Double spaceshipComponent3=new Line2D.Double(x+50,y+25,x,y+25);
		g2.draw(spaceshipComponent3);
		Line2D.Double spaceshipComponent4=new Line2D.Double(x,y+25,x,y);
		g2.draw(spaceshipComponent4);
		Line2D.Double spaceshipComponent5=new Line2D.Double(x,y+20,x+50,y+20);
		g2.draw(spaceshipComponent5);
		g2.setColor(Color.gray);
		g2.fillPolygon(new int[]{x+15,x+17,x+25,x+35},new int[]{y+15,y+40,y+40,y+15},4);
		Line2D.Double wingOutline=new Line2D.Double(x+15,y+15,x+17,y+40);
		g2.setColor(Color.black);
		g2.draw(wingOutline);
		Line2D.Double wingOutline1=new Line2D.Double(x+17,y+40,x+25,y+40);
		g2.draw(wingOutline1);
		Line2D.Double wingOutline2=new Line2D.Double(x+25,y+40,x+35,y+15);
		g2.draw(wingOutline2);
		g2.setColor(Color.gray);
		g2.fillPolygon(new int[]{x+15,x+17,x+25,x+35},new int[]{y,y-15,y-15,y},4);
		g2.setColor(Color.black);
		g2.drawPolygon(new int[]{x+15,x+17,x+25,x+35},new int[] {y,y-15,y-15,y},4);
		Line2D.Double frontWindowBorder=new Line2D.Double(x+50,y+12.5,x+65,y+12.5);
		g2.draw(frontWindowBorder);
		Line2D.Double frontWindowBorder1 = new Line2D.Double(x+57,y+2.5,x+57,y+22.5);
		g2.draw(frontWindowBorder1);
		g2.setColor(Color.gray);
		g2.fillPolygon(new int[]{x,x-5,x-10,x-10,x-5,x},new int[]{y,y-5,y-5,y+30,y+30,y+25},6);
		g2.setColor(Color.black);
		g2.drawPolygon(new int[]{x,x-5,x-10,x-10,x-5,x},new int[]{y,y-5,y-5,y+30,y+30,y+25},6);
		
	//creates rocket fuel flame in the back of the spaceship
		
		g2.setColor(this.color);
		g2.fillRoundRect(x-45,y+5,35,15,35,15);
		g2.setColor(Color.black);
		g2.drawRoundRect(x-45,y+5,35,15,35,15);
		Ellipse2D.Double innerFlame=new Ellipse2D.Double(x-40,y+7,25,10);
		Color innerFlameColor=new Color(255,65,20);
		g2.setColor(innerFlameColor);
		g2.fill(innerFlame);
		
	//displays the symbol of N.A.S.A. on the side of the spaceship
		
		Ellipse2D.Double nasaComponent=new Ellipse2D.Double(x+17,y+4,15,15);
		g2.setColor(Color.blue);
		g2.fill(nasaComponent);
		g2.setColor(Color.black);
		g2.draw(nasaComponent);
		Rectangle nasaComponent1=new Rectangle(x+21,y+10,8,2);
		g2.setColor(Color.white);
		g2.fill(nasaComponent1);
		Line2D.Double nasaComponent2=new Line2D.Double(x+15,y+10,x+34,y+9);
		g2.setColor(Color.red);
		g2.draw(nasaComponent2);
		Line2D.Double nasaComponent3=new Line2D.Double(x+15,y+15,x+34,y+9);
		g2.draw(nasaComponent3);
		
	//displays and explosion animation upon the explosion state being set to true
		
		if(explosionState) {
			g2.setColor(Color.orange);
			g2.fillPolygon(new int[]{x-7,x+18,x+29,x+41,x+57,x+45,x+55,x+28,x+26,x+17,x-8,x+4,x-12,x-3,x-7},new int[]{y-10,y+4,y-13,y+6,y+2,y+24,y+34,y+23,y+39,y+24,y+36,y+20,y+11,y+4,y-10},15);
			BasicStroke b=new BasicStroke(7);
			g2.setStroke(b);
			g2.setColor(Color.red);
			g2.drawPolygon(new int[]{x-7,x+18,x+29,x+41,x+57,x+45,x+55,x+28,x+26,x+17,x-8,x+4,x-12,x-3,x-7},new int[]{y-10,y+4,y-13,y+6,y+2,y+24,y+34,y+23,y+39,y+24,y+36,y+20,y+11,y+4,y-10},15);
		}
		
		if(shieldState) {
			Ellipse2D.Double shield=new Ellipse2D.Double(x-50,y-19,120,63);
			Color c1=new Color(11,239,245,125);
			g2.setColor(c1);
			g2.fill(shield);
			g2.setColor(Color.black);
			g2.draw(shield);
			}
	}
	/**
	 * The method to change the color of the body and flame to a random color.
	 */
	public void changeColor() {
		randomColor=new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));
		this.color=randomColor;
		this.color1=randomColor;
	}
	/**
	 * Method to move spaceship through change in x and y 
	 * upon user key interaction(travel distance parameters created).
	 */
	public void moveSpaceship() {
		if(x>=418) {
			x=418;
			x+=dx;
			rect.x=x;
			
		}
		else
		{
			x+=dx;
			rect.x=x;
		}
		if(y>=420) {
			y=420;
			y+=dy;
		}
		else
			y+=dy;
		
		if(x<=45) {
			x=45;
			x+=dx;
			rect.x=x;
		}
		else
		{
			bulletRect.x=x+35;
			rect.x=x;
			x+=dx;
		}
		
		if(y<=16) {
			y=16;
			y+=dy;
			rect.y=y;
		}
		else
		{
			y+=dy;
			rect.y=y;
		}
	}
	/**
	 * Method to set the change in x.
	 * @param dx Change in x.
	 */
	public void setDx(int dx) {
		this.dx=dx;
	}
	/**
	 * Method to set the change in y.
	 * @param dy Change in y.
	 */
	public void setDy(int dy) {
		this.dy=dy;
	}
	/**
	 * This method gets the x position.
	 * @return X position.
	 */
	public int getX() {
		return this.x;
	}
	/**
	 * This method returns the y position.
	 * @return Y position.
	 */
	public int getY() {	
		return this.y;
	}
	/**
	 * This method returns the change in x.
	 * @return Delta x.
	 */
	public int getDX() {
		return dx;
	}
	/**
	 * This method returns the change in y.
	 * @return Delta y.
	 */
	public int getDY() {
		return dy;
	}
	/**
	 * This method returns the color of the outer flame of the spaceship.
	 * @return Color of field color1.
	 */
	public Color getColor1() {
		return color1;
	}
	/**
	 * This method returns the color of the body of the spaceship.
	 * @return Color of field color.
	 */
	public Color getColor() {
		return randomColor;
	}
	/**
	 * This method returns the rectangle that determines the collision boundaries on the spaceship.
	 * @return Rectangle rect.
	 */
	public Rectangle2D.Double getBoundingBox() {	
		return rect;
	}
	/**
	 * Method to draw the explosion on top of the spaceship.
	 * @param explosion A boolean determining the state of the explosion.
	 */
	public void drawExplosion(boolean explosion) {
		explosionState=explosion;
	}
	public void drawShield(boolean shield) {
		shieldState=shield;
	}
	public boolean getShieldState() {
		return shieldState;
	}
	public void changeLocation(int x,int y) {
		this.x=x;
		this.y=y;
	}
}

