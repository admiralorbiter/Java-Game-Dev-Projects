package Mistborn;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;

public class Player extends Entity{

	int MOVE=Settings.MOVE;
	
	public Player(Point position, Dimension dimension) {
		super(position, dimension);
	}
	
	public void update(boolean keys[], Point tileIndex, Platformer testPlatform) {
		if(!(Collision.collision(testPlatform, getCollisionBox()) && tileIndex.equals(testPlatform.getTileIndex())))
			if(!(position.y+(MOVE+dimension.height)>=Settings.getTileSize().getHeight() && tileIndex.y+1>=Settings.HEIGHT))
				position.y += MOVE;
	
		if(keys[KeyEvent.VK_W] || keys[KeyEvent.VK_UP]){
			if(!(position.y-MOVE<=0 && tileIndex.y-1<0))
				position.y -= 2*MOVE;
		}

	    if(keys[KeyEvent.VK_S] || keys[KeyEvent.VK_DOWN]){
	    	if(!(position.y+MOVE+dimension.height>=Settings.getTileSize().getHeight() && tileIndex.y+1>=Settings.HEIGHT))
	    		position.y += MOVE;
	    }

	    if(keys[KeyEvent.VK_A] || keys[KeyEvent.VK_LEFT]){
	    	if(!(position.x-MOVE<=0 && tileIndex.x-1<0))
	    		position.x -= MOVE;
	    }	

	    if(keys[KeyEvent.VK_D] || keys[KeyEvent.VK_RIGHT]){
	    
	    	if(!((position.x+MOVE+dimension.width)>=Settings.getTileSize().getWidth() && tileIndex.x+1>=Settings.WIDTH))
	    		position.x += MOVE;
	    }
	}
}
