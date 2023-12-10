package Application;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.io.Serializable;

import javax.swing.ImageIcon;

import Application.Settings;
import Text.ConversationNode;
import Utility.Utility;

public class Entity implements Serializable{
	protected Point position=null;
	protected String name="Unknown Entity";
	protected ImageIcon sprite=null;		
	protected Point tileIndex;
	protected Point screenPos = null;
	protected Point dimension=new Point(1, 1);
	protected String type="entity";
	protected Color color=Color.WHITE;
	protected ImageIcon image=null;
	protected double rotation = 0;
	protected ConversationNode conversation;
	
	public Entity() {}
	
	public Entity(Point position) {
		this.position=new Point(position);
		tileIndex = Utility.calculateTileIndex(position);
		screenPos = new Point(position.x-tileIndex.x*Settings.getScreensize().width/Settings.size, position.y-tileIndex.y*Settings.getScreensize().height/Settings.size);
	}
	
	public Entity(Point position, Point dimension, Color color, String type, ImageIcon image) {
		this.position=position;
		this.dimension=dimension;
		if(image!=null)
			this.image=image;
		
		if(color!=null)
			this.color=color;
		if(name!=null)
			this.type=type;
		
		tileIndex = Utility.calculateTileIndex(position);
		screenPos = new Point(position.x-tileIndex.x*Settings.getScreensize().width/Settings.size, position.y-tileIndex.y*Settings.getScreensize().height/Settings.size);
	}

	public void draw(Graphics g) {

		if(color!=null)
			g.setColor(color);
		else
			g.setColor(Color.white);

		if(rotation!=0 && image!=null)
			drawRotationImage(g, image);
		else if(rotation!=0)
			 drawRotationNoImage(g, rotation);
		else if(image!=null)
			g.drawImage(image.getImage(), screenPos.x*Settings.size, screenPos.y*Settings.size, dimension.x*Settings.size, dimension.y*Settings.size, null);
		else
			g.fillRect(screenPos.x*Settings.size, screenPos.y*Settings.size, dimension.x*Settings.size, dimension.y*Settings.size);
	}
	
	private void drawRotationNoImage(Graphics g, double rotation) {
		Graphics2D g2d = (Graphics2D)g; 
		AffineTransform oldXForm = g2d.getTransform();
		g2d.setColor(color);
		Rectangle rect = new Rectangle(screenPos.x*Settings.size, screenPos.y*Settings.size, dimension.x*Settings.size, dimension.y*Settings.size);
		g2d.rotate(Math.toRadians(rotation), rect.getCenterX(), rect.getCenterY());
		g2d.fill(rect);
		g2d.setTransform(oldXForm);
	}
	
	private void drawRotationImage(Graphics g, ImageIcon image) {
		Graphics2D g2d = (Graphics2D)g;
		AffineTransform oldXForm = g2d.getTransform();
		//AffineTransform transform = AffineTransform.getRotateInstance(Math.toRadians(rotation), screenPos.x*Settings.size+dimension.x*Settings.size/2, screenPos.y*Settings.size-dimension.y*Settings.size/2);
		Rectangle rect = new Rectangle(screenPos.x*Settings.size, screenPos.y*Settings.size, dimension.x*Settings.size, dimension.y*Settings.size);
		AffineTransform transform = AffineTransform.getRotateInstance(Math.toRadians(rotation), rect.getCenterX(), rect.getCenterY());
		g2d.setTransform(transform);
		g2d.drawImage(image.getImage(), screenPos.x*Settings.size, screenPos.y*Settings.size, dimension.x*Settings.size, dimension.y*Settings.size, null);
		g2d.setTransform(oldXForm);
	}
	
	//Getters and Setters
	public Point getPosition() {return position;}
	public void setPosition(Point position) {
		this.position=position;
		tileIndex = Utility.calculateTileIndex(position);
		setScreenPos(position);
	}
	public String getName() {return name;}
	public void setName(String name) {this.name=name;}
	public ImageIcon getSprite() {return sprite;}
	//public void setImageIcon(ImageIcon sprite) {this.sprite=sprite;}
	public Point getScreenPos() {return screenPos;}
	public void setScreenPos(Point screenPos) {
		screenPos = new Point(position.x-tileIndex.x*Settings.getScreensize().width/Settings.size, position.y-tileIndex.y*Settings.getScreensize().height/Settings.size);
		this.screenPos=new Point(screenPos);
	}
	public Point getTileIndex() {return tileIndex;}
	public void setTileIndex(Point tileIndex) {this.tileIndex=tileIndex;}
	public Point getDimension() {return dimension;}
	public void setDimension(Point dimension) {this.dimension=dimension;}
	public String getType() {return type;}
	public void setType(String type) {this.type=type;}
	public Color getColor() {return color;}
	public void setColor(Color color) {this.color=color;}
	public ImageIcon getImageIcon() {return image;}
	public void setImageIcon(ImageIcon image) {this.image=image;}
	public double getRotation() {return rotation;}
	public void setRotation(double rotation) {this.rotation=rotation;}	
	public Rectangle getCollisionBox() {return new Rectangle(position.x*Settings.size, position.y*Settings.size, Settings.size*dimension.x, Settings.size*dimension.y);}
	public ConversationNode getConversation() {return conversation;}
	public void setConversation(ConversationNode conversation) {this.conversation=conversation;}
}
