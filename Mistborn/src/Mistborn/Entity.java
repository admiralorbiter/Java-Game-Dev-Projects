package Mistborn;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Entity {
	protected Point position;
	protected String name="Unknown Entity";
	protected ImageIcon sprite = null;
	protected Dimension dimension = null;
	protected Color color = null;
	public Entity(Point position, Dimension dimension) {
		this.position=position;
		this.dimension=dimension;
	}

	//Getters and Setters
	public Point getPosition() {return position;}
	public void setPosition(Point position) {this.position = position;}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public ImageIcon getSprite() {return sprite;}
	public void setSprite(ImageIcon sprite) {this.sprite = sprite;}
	public Dimension getDimension() {return dimension;}
	public void setDimension(Dimension dimension) {this.dimension = dimension;}
	public void setColor(Color c) {this.color=c;}
	public Color getColor() {return color;}
	
	public void draw(Graphics g) {
		if(color!=null)
			g.setColor(color);
		g.fillRect(position.x, position.y, dimension.width, dimension.height);
	}
	public Rectangle getCollisionBox() {
		return new Rectangle(position.x, position.y,(int) dimension.getWidth(), (int)dimension.getHeight());
		
	}
}
