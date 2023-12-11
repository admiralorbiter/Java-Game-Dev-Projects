package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Zone extends Entity {

	Point dimensions;
	Color color = Color.black;
	
	public Zone(Point position, String name) {
		super(position, name);
	}
	
	public Zone(Point position, String name, Point dimensions) {
		super(position, name);
		this.dimensions=new Point(dimensions);
		
		if(name=="bedroom")
			color=Color.WHITE;
	}
	
	public void setColor(Color c) {color=c;}
	
	public void draw(Graphics g) {
		g.setColor(color);
		if(sprite!=null)
			g.drawImage(sprite, (int)position.getX(), (int)position.getY(), Settings.getCharacterWidth(), Settings.getCharacterHeight(), null );
		else
			g.fillRect((int)position.getX(), (int)position.getY(), (int)dimensions.getX(), (int)dimensions.getY());
	}
	
}
