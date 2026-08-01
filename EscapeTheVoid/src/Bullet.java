import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Bullet {
	
	private double x,y;
	private double velocity;
	private Rectangle2D.Double rect = new Rectangle2D.Double(x, y, 50,20);
	public Bullet(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
public void draw(Graphics2D g) {
		
		Graphics2D g2=(Graphics2D) g;
		Color c=new Color(00,00,00,00);
		g2.setColor(c);
		g2.draw(rect);
		Color c1 = new Color(255,0,0);
		Ellipse2D.Double bullet = new Ellipse2D.Double(x, y, 10, 5);
		g2.setColor(c1);
		g2.fill(bullet);
		}
	
	public void setVel(double velocity) {
		this.velocity = velocity;
	}	
	
	public void moveBullet(long diff) {
		x=x+(velocity*diff);
	}
}
