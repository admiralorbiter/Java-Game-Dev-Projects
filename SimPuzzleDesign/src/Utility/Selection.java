package Utility;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.List;

import Application.Entity;
import Application.Settings;

public final class Selection {
	public static Entity selectEntity(Point mouseLocation, List<Entity> entityList) {
		Point location = Utility.screenPointToCoordinate(mouseLocation);
		for(Entity entity : entityList) {	
			if(entity.getCollisionBox().intersects(new Rectangle(location.x*Settings.size, location.y*Settings.size, Settings.size, Settings.size)))
				return entity;
		}
		
		return null;
	}
	
	public static void draw(Graphics g, Point loc) {
		loc=Utility.screenPointToCoordinate(loc);
		g.draw3DRect(loc.x*Settings.size, loc.y*Settings.size, Settings.size, Settings.size, true);
	}
	
	public static Rectangle getSelectionTile(Point mouseLocation) {
		Point location = Utility.screenPointToCoordinate(mouseLocation);
		return new Rectangle(location.x, location.y, 1, 1);
	}
}
