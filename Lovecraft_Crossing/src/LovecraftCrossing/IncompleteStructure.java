package LovecraftCrossing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class IncompleteStructure extends Entity {

	private Material materialNeeded;
	private boolean complete=false;
	private String buildingType;
	
	public IncompleteStructure(Point gridPosition, Material materialNeeded, String buildingType) {
		super(gridPosition, "IncompleteStructure", 0);
		this.materialNeeded=materialNeeded;
		this.buildingType=buildingType;
	}
	

	//Getters and Setters
	public Material getMaterialNeeded() {return materialNeeded;}
	public boolean structureComplete() {return complete;}
	public String getBuildingType() {return buildingType;}
	
	public int addMaterial(int materialAdded) {
		int leftover = materialAdded-materialNeeded.getQuantity();
		
		if(leftover>=0) {
			complete=true;
			
			return leftover;
		}
		
		return 0;
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(Color.GRAY);
		g.drawRect(gridPosition.x*Settings.TILESIZE, gridPosition.y*Settings.TILESIZE, Settings.TILESIZE-1, Settings.TILESIZE-1);
	}

}
