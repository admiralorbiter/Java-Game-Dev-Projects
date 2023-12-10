package Utility;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.util.List;

import Application.Entity;
import Application.Settings;

public final class Collision {
	public static boolean collision(Entity one, Entity two) {
		
		Rectangle entityOne = one.getCollisionBox().getBounds();
		
		Rectangle entityTwo = two.getCollisionBox().getBounds();
		
		if(entityOne.intersects(entityTwo))
			return true;

		return false;
	}
	
	public static boolean collision(Rectangle one, Rectangle two) {
		
		if(one.intersects(two))
			return true;

		return false;
	}

	public static Point collisionPoint(Rectangle entity, List<Entity> objectList) {
		for(Entity object : objectList) {
			if(entity.intersects(object.getCollisionBox())) {
				Rectangle intersection = object.getCollisionBox().intersection(entity);
				return new Point(intersection.x/Settings.size, intersection.y/Settings.size);
			}
		}
		
		return null;
	}
	
	//used for player collision --------------------------------------------------------
	
	public static boolean collision(Rectangle entity, List<Entity> objectList) {
		
		for(Entity object : objectList) {
			//if(entity.intersects(object.getCollisionBox())) {
			if(collision(entity.getBounds(), object.getCollisionBox(), object.getRotation())) {
				return true;
			}
		}
		
		return false;
	}
	
	public static Entity collisionWith (Rectangle entity, List<Entity> objectList) {
		
		for(Entity object : objectList) {
			//if(entity.intersects(object.getCollisionBox()))
			if(collision(entity.getBounds(), object.getCollisionBox(), object.getRotation()))
				return object;
		}
		
		return null;
	}
	
	public static boolean collision(Rectangle player, Rectangle entity, double rotation) {
		AffineTransform af = new AffineTransform();
		af.rotate(Math.toRadians(rotation), entity.getCenterX(), entity.getCenterY());
		Shape newrect = af.createTransformedShape(entity);
		
		if(newrect.intersects(player))
			return true;
		
		return false;
	}
	
	
	public static Point collisionPoint(Rectangle entity, Entity object) {
		if(collision(entity.getBounds(), object.getCollisionBox(), object.getRotation())) {
			Rectangle intersection = object.getCollisionBox().intersection(entity);
			return new Point(intersection.x/Settings.size, intersection.y/Settings.size);
		}
		
		return null;
	}
}
