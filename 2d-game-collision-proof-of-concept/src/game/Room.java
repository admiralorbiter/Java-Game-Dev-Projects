package game;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Room {
	
	BufferedImage img = null;
	
	Point starting;
	Point exit;
	
	public Room(String file, Point starting, Point exit) {
		try {
			img = ImageIO.read(new File(file));
		}catch(IOException e) {}
		
		this.starting=new Point(starting);
		this.exit=new Point(exit);
	}

	public BufferedImage getImage() {return img;}
	
	public void setStartingPosition(Point starting) {
		this.starting=new Point(starting);
	}
	
	public Point getStartingPosition() {return starting;}
	
	public void setExit(Point exit) {
		this.exit=new Point(exit);
	}
	
	public Point getExit() {return exit;}	
	
	
}
