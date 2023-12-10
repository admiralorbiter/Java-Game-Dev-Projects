package Level;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import Application.Entity;
import NPC.NPC;


public class Level1 implements Level{

	@Override
	public Point getDimensions() {
		return new Point(40, 40);
	}

	@Override
	public List<Entity> getObjectList() {
		List<Entity> objectList =  new ArrayList<Entity>();
		
		objectList.add(new Entity(new Point(0, 0), new Point(getDimensions().x, 1), new Color(219, 129, 44), "wall", null));
		objectList.add(new Entity(new Point(0, 1), new Point(1, getDimensions().y-1), new Color(219, 129, 44), "wall", null));
		objectList.add(new Entity(new Point(1, getDimensions().y-1), new Point(getDimensions().x-1, 1), new Color(219, 129, 44), "wall", null));
		objectList.add(new Entity(new Point(getDimensions().x-1, 1), new Point(1, getDimensions().y-1), new Color(219, 129, 44), "wall", null));
		
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				objectList.add(new Entity(new Point(10+j*5, 3+i*5), new Point(3, 3), Color.pink, "childrenChair", new ImageIcon("src/img/ChildrenDesk.png")));
				objectList.get(objectList.size()-1).setRotation(-90);
			}
		}
		
		objectList.add(new Entity(new Point(5, 30), new Point(10, 6), Color.pink, "teacherDesk", new ImageIcon("src/img/TeacherDesk.png")));
		objectList.get(objectList.size()-1).setRotation(45);
		
		objectList.add(new Entity(new Point(23, 35), new Point(12, 4), Color.pink, "desk_Globe_Computer", new ImageIcon("src/img/desk1.png")));
		
		
		//this is a hack for the point because rotation does the center of the original of the object
		objectList.add(new Entity(new Point(-5, 14), new Point(13, 1), Color.pink, "chalkboard", new ImageIcon("src/img/chalkboard.png")));
		objectList.get(objectList.size()-1).setRotation(90);
		
		objectList.add(new Entity(new Point(35, 6), new Point(6, 3), Color.pink, "randomstuff", new ImageIcon("src/img/randomstuff.png")));
		objectList.get(objectList.size()-1).setRotation(-90);
		
		objectList.add(new Entity(new Point(31, 31), new Point(12, 4), Color.pink, "desk", new ImageIcon("src/img/desk2.png")));
		objectList.get(objectList.size()-1).setRotation(90);
		
		objectList.add(new Entity(new Point(35, 19), new Point(6, 2), Color.pink, "cubby", new ImageIcon("src/img/desk2.png")));
		objectList.get(objectList.size()-1).setRotation(90);
		
		objectList.add(new NPC(new Point(3, 17), "hoid"));
		
		return objectList;
	}

	@Override
	public Point getPlayerPosition() {
		return new Point(7, 6);
	}

	@Override
	public Color getBackgroundColor() {
		return Color.darkGray;
	}

	@Override
	public List<Entity> getPathObjects() {
		List<Entity> bgObjects =  new ArrayList<Entity>();
		//bgObjects.add(new Entity(new Point(1, 1), new Point(38, 38), Color.white, "floor", new ImageIcon("src/Application/img/classfloor.png")));
		return bgObjects;
	}

}
