

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.Serializable;

import javax.swing.ImageIcon;

public class Entity implements Serializable{

	protected String name="Unknown Entity";
	protected ImageIcon sprite=null;		
	protected Point screenPos = null;
	protected Point dimension=new Point(1, 1);
	protected String type="entity";
	protected Color color=Color.WHITE;
	
	public Entity(Point position) {
		this.screenPos=new Point(position);
	}
	
	public Entity(Point position, Point dimension, Color color, String type, ImageIcon image) {
		this.screenPos=new Point(position);
		this.dimension=new Point(dimension);
		if(color!=null)
			this.color=color;
		if(name!=null)
			this.type=type;
	}
	
	public Rectangle getCollisionBox() {
		return new Rectangle(screenPos.x, screenPos.y, dimension.x, dimension.y);	
	}
	
	public boolean update(Point direction) {
		if(direction.x+screenPos.x>=0 && direction.x+screenPos.x<Settings.getWindowSize().width)
			if(direction.y+screenPos.y>=0 && direction.y+screenPos.y<Settings.getWindowSize().height) {
				setScreenPos(new Point(direction.x+screenPos.x, direction.y+screenPos.y));
				return true;
			}
		return false;
	}

	public void draw(Graphics g) {
		
		if(color!=null)
			g.setColor(color);
		else
			g.setColor(Color.white);
		
		g.fillRect(screenPos.x, screenPos.y, dimension.x, dimension.y);
	}

	//Getters and Setters
	public String getName() {return name;}
	public void setName(String name) {this.name=name;}
	public ImageIcon getSprite() {return sprite;}
	public void setImageIcon(ImageIcon sprite) {this.sprite=sprite;}
	public Point getScreenPos() {return screenPos;}
	public void setScreenPos(Point screenPos) {
		this.screenPos=new Point(screenPos);
	}
	public Point getDimension() {return dimension;}
	public void setDimension(Point dimension) {this.dimension=dimension;}
	public String getType() {return type;}
	public void setType(String type) {this.type=type;}
	public Color getColor() {return color;}
	public void setColor(Color color) {this.color=color;}
	
	
}
