package NPC;

import java.awt.Point;

import Application.Entity;

public class NPC extends Entity {
	private Personality personality=null;
	
	public NPC(Point position, String name) {
		super(position);
		setName(name);
		setType("npc");
		personality = loadPersonality(name);
		conversation = personality.loadConversation();
	}
	
	private Personality loadPersonality(String name) {
		switch(name) {
			case "hoid":
				return new Hoid();
			case "teacher":
				setDimension(new Point(2, 2));
				return new Hoid();
			default:
				return new Hoid();	
		}
	}
}
