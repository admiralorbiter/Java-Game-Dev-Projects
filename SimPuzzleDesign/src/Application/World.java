package Application;

import java.awt.Graphics;
import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import Level.Load;
import Utility.Utility;

public class World implements Serializable {
	
	private WorldDataObject data=null;
	private Point lastPlayerPoint=null;		//Used when saving and loading to keep player position
	
	public World(SelectWorld worldSelect, Player player) {
		load(Utility.turnWorldEnumToNum(worldSelect), player);
	}
	
	public void load(int level, Player player) {
		data = Load.world(level, player, lastPlayerPoint);
	}
	
	public void update(Player player) {
		lastPlayerPoint = player.getPosition();
		//TODO
	}
	
	public void draw(Graphics g, Player player) {
		//TODO
		List<Entity> objectList = new ArrayList<Entity>();
		
		//Adds path objects and all objects to one list
		if(data.getPathObjectList()!=null)
			objectList.addAll(data.getPathObjectList());
		objectList.addAll(data.getObjectList());
		
		for (Entity object : objectList) { 
			if(player.getTileIndex().equals(object.getTileIndex())) {
				object.draw(g);
			}
		}
		
		//TODO - Why
		if(data.getPathObjectList()!=null)
			objectList.removeAll(data.getPathObjectList());
		
		player.draw(g);
	}

	//Getters and Setters
	public WorldDataObject getData() {return data;}
	public Point getLastPlayerPoint() {return lastPlayerPoint;}
}
