package LovecraftCrossing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Entity {
	protected Point gridPosition;
	protected String characterID;
	protected Color color = new Color(255, 255, 255);
	protected int hp;

	public Entity(Point gridPosition, String characterID, int hp) {
		this.characterID=characterID;
		this.gridPosition=gridPosition;
		this.hp=hp;
	}
	
	//Getters and Setters
	public Point getPosition() {return gridPosition;}
	public Point getPixelPosition() {return new Point(gridPosition.x*Settings.TILESIZE, gridPosition.y*Settings.TILESIZE);}
	public String getCharacterID() {return characterID;}
	public void setCharacterID(String id) {this.characterID=id;}
	public Color getColor() {return color;}
	public void setColor(Color c) {this.color=c;}
	public int getHP() {return hp;}
	public boolean getAlive() {if(hp>0) {return true;} return false;}
	public void takeDamage(int damage) {
		hp=hp-damage;
		update();
	}
	public void setPosition(Point gridPosition) {
		this.gridPosition=gridPosition;
	}
	
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillRect(gridPosition.x*Settings.TILESIZE, gridPosition.y*Settings.TILESIZE, Settings.TILESIZE, Settings.TILESIZE);
	}
	
	public void update() {
		
	}
}
