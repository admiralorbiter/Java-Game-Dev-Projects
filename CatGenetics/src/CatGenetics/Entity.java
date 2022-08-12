package CatGenetics;

import java.awt.Color;

public class Entity {
	
	protected String characterID;
	protected Color color = new Color(255, 255, 255);

	public Entity(String characterID) {
		this.characterID=characterID;
	}
	
	//Getters and Setters
	public String getCharacterID() {return characterID;}
	public void setCharacterID(String id) {this.characterID=id;}
	public Color getColor() {return color;}
	public void setColor(Color c) {this.color=c;}
	
	public void update() {
		
	}
}
