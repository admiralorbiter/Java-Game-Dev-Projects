package LovecraftCrossing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Material {
	String name;
	int quantity;
	Color color;
	
	public Material(String name, int quantity, Color color) {
		this.name=name;
		this.quantity=quantity;
		this.color=color;
	}
	
	public Material(String name, int quantity) {
		this.name=name;
		this.quantity=quantity;
		
		switch(name) {
			case "wood":
				color = new Color(193, 154, 107);
				break;
		}
	}
	
	public String getName() {return name;}
	public int getQuantity() {return quantity;}
	public void setQuantity(int quantity) {this.quantity=quantity;}
	
	public void draw(Graphics g, Point gridPosition) {
		g.setColor(color);
		g.fillRect(gridPosition.x*Settings.TILESIZE, gridPosition.y*Settings.TILESIZE, Settings.TILESIZE, Settings.TILESIZE);
		g.setColor(Color.white);
		g.drawString(" "+quantity, gridPosition.x*Settings.TILESIZE, gridPosition.y*Settings.TILESIZE+Settings.TILESIZE/2);
	}
}
