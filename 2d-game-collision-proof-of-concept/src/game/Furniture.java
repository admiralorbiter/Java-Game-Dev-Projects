package game;

import java.awt.Point;

public class Furniture extends Entity {

	public Furniture(Point position, String name) {
		super(position, name);
	}
	/*
	public void draw(Graphics g) {
		g.setColor(color);
		if(sprite!=null)
			g.drawImage(sprite, (int)position.getX(), (int)position.getY(), Settings.getCharacterWidth(), Settings.getCharacterHeight(), null );
		else
			g.fillRect((int)position.getX(), (int)position.getY(), (int)dimensions.getX(), (int)dimensions.getY());
	}*/

}
