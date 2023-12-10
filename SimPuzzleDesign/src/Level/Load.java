package Level;

import java.awt.Point;

import Application.Player;
import Application.WorldDataObject;

public final class Load {
	public static WorldDataObject world(int levelNum, Player player, Point lastPosition) {
		Level level;
		
		switch(levelNum) {
			case 1:
				level = new Level1();
				break;
			default:
				level = new Level1();
		}
		
		if(lastPosition==null)
			player.setPosition(level.getPlayerPosition());
		else
			player.setPosition(lastPosition);
		
		return new WorldDataObject(level.getDimensions(), level.getObjectList(), level.getBackgroundColor(), level.getPathObjects());
	}
}
