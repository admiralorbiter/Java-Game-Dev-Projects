package Application;

import java.awt.Color;
import java.awt.Point;
import java.io.Serializable;
import java.util.List;

public class WorldDataObject implements Serializable{
	private Color backgroundColor;
	private Point dimensions=null;
	private List<Entity> objectList=null;
	private List<Entity> pathObjects=null;
	
	public WorldDataObject(Point dimensions, List<Entity> objectList, Color backgroundColor, List<Entity> pathObjects) {
		this.backgroundColor=backgroundColor;
		this.dimensions=dimensions;
		this.objectList=objectList;
		this.pathObjects=pathObjects;
	}
	//Getters and Setters
	public Color getBackgroundColor() {return backgroundColor;}
	public void setBackgroundColor(Color c) {backgroundColor=c;}
	public Point getDimension() {return dimensions;}
	public void setDimension(Point dimension) {this.dimensions=dimension;}
	public List<Entity> getObjectList(){return objectList;}
	public void setObjectList(List<Entity> objectList) {this.objectList=objectList;}
	public List<Entity> getPathObjectList(){return pathObjects;}
	public void setBGObjectList(List<Entity> pathObjects) {this.pathObjects=pathObjects;}
	
}
