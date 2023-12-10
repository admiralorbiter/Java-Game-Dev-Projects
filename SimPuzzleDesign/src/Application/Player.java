package Application;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.util.List;

import Utility.Collision;
import Utility.Utility;

public class Player extends Entity {

	private Point direction = new Point(0, 0);
	
	public Player() {
		setName("Player");
		setColor(Color.white);
	}
	
	public Entity update(boolean keys[], World world) {
		return move(keys, world);
	}
	
	private Entity move(boolean keys[], World world) {
		
		List<Entity> objectList = world.getData().getObjectList();
		Point dimensions = world.getData().getDimension();
		
		if(keys[KeyEvent.VK_W] || keys[KeyEvent.VK_UP]){
			direction = new Point(0, -1);
			
			if(position.y>0 && position.y<dimensions.y) {
				position.y -= 1;
				screenPos.y -= 1;
				
				if(Collision.collision(getCollisionBox(), objectList)) {
					position.y += 1;
					screenPos.y += 1;
					return Collision.collisionWith(getCollisionBox(), objectList);
				}
				
				if(screenPos.y<0) {
					tileIndex.y--;
					screenPos.y=((Settings.getScreensize().height/Settings.size)-1);
				}
				
				return null;
			}
		}
		
		 if(keys[KeyEvent.VK_S] || keys[KeyEvent.VK_DOWN]){
			 direction = new Point(0, 1);
			 
			 if(position.y>=0 && position.y<(dimensions.y-1)) {
					position.y += 1;
					screenPos.y += 1;
					
					if(Collision.collision(getCollisionBox(), objectList)) {
						position.y -= 1;
						screenPos.y -= 1;
						
						return Collision.collisionWith(getCollisionBox(), objectList);
					}
					
					if(screenPos.y>=(Settings.getScreensize().height/Settings.size)) {
						tileIndex.y++;
						screenPos.y=0;
					}
					
					return null;
				}
		 }
		 
		 if(keys[KeyEvent.VK_A] || keys[KeyEvent.VK_LEFT]){
			 direction = new Point(-1, 0);
			 
			 if(position.x>0 && position.x<dimensions.x) {
				position.x -= 1;
				screenPos.x -= 1;

				if(Collision.collision(getCollisionBox(), objectList)) {
					position.x += 1;
					screenPos.x += 1;
					return Collision.collisionWith(getCollisionBox(), objectList);
				}
				
				if(screenPos.x<0) {
					tileIndex.x--;
					screenPos.x=((Settings.getScreensize().width/Settings.size)-1);
				}
				
				return null;
			 }
		 }
		 
		 if(keys[KeyEvent.VK_D] || keys[KeyEvent.VK_RIGHT]){
			 direction = new Point(1, 0);
			 
			 if(position.x>=0 && position.x<(dimensions.x-1)) {
				 
				position.x += 1;
				screenPos.x += 1;
				
				if(Collision.collision(getCollisionBox(), objectList)) {
					position.x -= 1;
					screenPos.x -= 1;
					return Collision.collisionWith(getCollisionBox(), objectList);
				}
				
				if(screenPos.x>=(Settings.getScreensize().width/Settings.size)) {
					tileIndex.x++;
					screenPos.x=0;
				}
				
				return null;
			 }
		 }
		 
		 return null;
	}

	//Getters and Setters
	public Point getTileIndex() {return Utility.calculateTileIndex(position);}
	public Point getDirection() {return direction;}
}
