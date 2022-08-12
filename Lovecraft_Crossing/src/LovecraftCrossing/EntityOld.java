package LovecraftCrossing;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class EntityOld {
	protected Point positionGrid;
	protected Point positionPixels;
	protected String name="Unknown Entity";
	protected ImageIcon sprite = null;
	protected Dimension dimensionGrid;
	protected Dimension dimensionPixels;
	protected Point tileIndex;
	protected char charID;
	
	public EntityOld(Point position, Dimension dimension, char charID) {
		this.positionGrid=position;
		this.positionPixels=new Point(position.x*5, position.y*5);
		this.dimensionGrid=dimension;
		this.dimensionPixels=new Dimension(dimension.width*5, dimension.height*5);
		this.charID=charID;
	}

	//Getters and Setters
	public Point getPosition() {return positionGrid;}
	public void setPosition(Point position) {
		this.positionGrid = new Point(position);
		this.positionPixels = new Point(position.x*5, position.y*5);
	}
	public Point getPositionPixels() {return positionPixels;}

	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public ImageIcon getSprite() {return sprite;}
	public void setSprite(ImageIcon sprite) {this.sprite = sprite;}
	public Dimension getDimension() {return dimensionGrid;}
	public void setDimension(Dimension dimension) {this.dimensionGrid = new Dimension(dimension);}
	public Dimension getDimensionPixels() {return dimensionPixels;}
	public void setDimensionPixels(Dimension dimension) {this.dimensionPixels = new Dimension(dimension);}
	public Point getTileIndex() {return tileIndex;}
	public void setTileIndex(Point index) {this.tileIndex=index;}
	public char getCharID() {return charID;}
	public void setCharID(char charID) {this.charID=charID;}
	
	public Point getWorldPosition(Point tileIndex) {
		return new Point(positionGrid.x+(tileIndex.x*Settings.getScreenSize().width), positionGrid.y+(tileIndex.y*Settings.getScreenSize().height));
	}
	
	public Point getWorldPositionPixels(Point tileIndex) {
		return new Point(positionGrid.x*5+(tileIndex.x*Settings.getScreenSize().width), positionGrid.y*5+(tileIndex.y*Settings.getScreenSize().height));
	}
	
	public Point getWorldPosition() {
		return new Point(positionGrid.x+(tileIndex.x*Settings.getScreenSize().width), positionGrid.y+(tileIndex.y*Settings.getScreenSize().height));
	}
	
	public Rectangle getCollisionBox() {
		return new Rectangle(positionPixels.x, positionPixels.y,(int) dimensionPixels.getWidth(), (int)dimensionPixels.getHeight());	
	}
}
