package Mistborn;

import java.awt.Rectangle;

public final class Collision {
	public static boolean collision(Entity one, Entity two) {
		
		Rectangle entityOne = one.getCollisionBox().getBounds();
		
		Rectangle entityTwo = two.getCollisionBox().getBounds();
		
		if(entityOne.intersects(entityTwo))
			return true;

		return false;
	}
	
	public static boolean collision(Entity one, Rectangle two) {
		Rectangle entityOne = one.getCollisionBox().getBounds();
		
		Rectangle entityTwo = two.getBounds();
		
		if(entityOne.intersects(entityTwo)) {
			return true;
		}

		return false;
	}
}
