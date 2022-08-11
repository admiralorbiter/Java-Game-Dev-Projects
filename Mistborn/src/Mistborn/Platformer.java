package Mistborn;

import java.awt.Dimension;
import java.awt.Point;

public class Platformer extends Entity {

	private Point tileIndex;
	
	public Platformer(Point position, Dimension dimension, Point tileIndex) {
		super(position, dimension);
		this.tileIndex=tileIndex;
	}

	public Point getTileIndex() {return tileIndex;}
	
}
