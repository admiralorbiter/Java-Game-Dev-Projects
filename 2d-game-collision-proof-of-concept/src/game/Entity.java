package game;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;

public class Entity {
	BufferedImage sprite=null;
	Point position;
	String name;
	
	public Entity(Point position, String name) {
		this.position=new Point(position);
		this.name=name;
	}
	
	public void drawCharacter(Graphics g) {
		if(sprite!=null)
			g.drawImage(sprite, (int)position.getX(), (int)position.getY(), Settings.getCharacterWidth(), Settings.getCharacterHeight(), null );
	}
	
	public void setPosition(Point position) {
		this.position=new Point(position);
	}
	
	public Point getPosition() {return position;}
	
	public void setSprite(BufferedImage sprite) {
		this.sprite=sprite;
	}
	
	public BufferedImage getSprite() {
		return sprite;
	}
	
	public String getName() {return name;}
	public void setName(String name) {this.name=name;}
}
