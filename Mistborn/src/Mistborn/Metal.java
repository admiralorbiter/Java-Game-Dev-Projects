package Mistborn;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

public class Metal extends Entity{
	private int MOVE=Settings.MOVE;
	private Point tileIndex;
	
	public Metal(Point position, Dimension dimension, Point tileIndex) {
		super(position, dimension);
		this.tileIndex=tileIndex;
		setColor(Color.DARK_GRAY);
	}
	
	public void update(Point tileIndex, Platformer testPlatform) {
		if(!(Collision.collision(testPlatform, getCollisionBox()) && tileIndex.equals(testPlatform.getTileIndex())))
			if(!(position.y+(MOVE+dimension.height)>=Settings.getTileSize().getHeight() && tileIndex.y+1>=Settings.HEIGHT))
				position.y += MOVE;
	}
	
	public Point getTileIndex() {return tileIndex;}

}
