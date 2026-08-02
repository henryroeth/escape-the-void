import java.awt.Graphics;
import java.awt.geom.Ellipse2D;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
public class Ammo {
	private Rectangle2D.Double rect;
	private double x,y;
	private double velocity=.20;
	public Ammo(double x,double y) {
		this.x=x;
		this.y=y;
		rect=new Rectangle2D.Double(x, y, 25, 25);
	}
	public void draw(Graphics g) {
		
		//recovers Graphics2D
			
			Graphics2D g2=(Graphics2D) g;
			
		//creates spaceship body
				
			Color c=new Color(00,00,00,00);
			g2.setColor(c);
			g2.draw(rect);
			Ellipse2D.Double shield=new Ellipse2D.Double(x,y,25,25);
			Color c1=new Color(255,0,0,125);
			g2.setColor(c1);
			g2.fill(shield);
			g2.setColor(Color.black);
			g2.draw(shield);
		}
	public void moveAmmo(long diff) {
		x=x+(-velocity*diff);
		rect.x=x;
	}
	public Rectangle2D.Double getBoundingBox(){
		return rect;
	}
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
}
