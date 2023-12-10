package Utility;

import java.awt.Point;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import Application.Player;
import Application.SelectWorld;
import Application.Settings;
import Application.World;

public final class Utility {
	public static Point calculateTileIndex(Point position) {
		Point tileIndex = new Point((position.x*Settings.size)/Settings.getScreensize().width, (position.y*Settings.size)/Settings.getScreensize().height);;
		
		return tileIndex;
	}
	
	public static Point screenPointToCoordinate(Point screenPoint) {
		Point coordinate = null;
		
		coordinate = new Point(screenPoint.x/Settings.size, screenPoint.y/Settings.size);
		
		return coordinate;
	}
	
	public static void saveWorld(World world, String fileName) {
		try {
			FileOutputStream file = new FileOutputStream(fileName);
			ObjectOutputStream out = new ObjectOutputStream(file);
			out.writeObject(world);
			out.close();
			file.close();	
			System.out.println("Saved game");
		}  catch(IOException ex) 
        { 
			System.out.println("Not able to save: "+ex.getMessage());
			ex.printStackTrace();
        }
	}
	
	public static World loadWorld(String filename, Player player) {
		try {
			FileInputStream file = new FileInputStream("save.ser"); 
            ObjectInputStream in = new ObjectInputStream(file); 

			World world = (World)in.readObject();
			player.setPosition(world.getLastPlayerPoint());
            in.close();
            file.close();
            System.out.println("Read in world data");
            return world;
		}catch(IOException ex) 
        { 
            System.out.println("No save file."); 
        }catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static World load(String filename) {
		try {
			FileInputStream file = new FileInputStream(filename); 
            ObjectInputStream in = new ObjectInputStream(file); 

			World world = (World)in.readObject();
            in.close();
            file.close();
            System.out.println("Read in world data");
            return world;
		}catch(IOException ex) 
        { 
            System.out.println("No save file."); 
        }catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static int turnWorldEnumToNum(SelectWorld world) {
		
		switch(world) {
			case ONE:
				return 1;
			case TWO:
				return 2;
			case THREE:
				return 3;
			default:
				return 1;
		}
	}
	
}
