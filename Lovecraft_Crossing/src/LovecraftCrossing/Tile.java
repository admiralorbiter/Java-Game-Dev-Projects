package LovecraftCrossing;

import java.awt.Color;

public class Tile {
	private String initalValue;
	private boolean block=false;
	private Color color = new Color(96, 128, 56);
	
	private Entity entity = null;
	private PC pc = null;
	private Material material = null;
	
	public Tile() {
		this.initalValue="grass";
		setTile(initalValue);
	}
	
	public Tile(String initalValue) {
		this.initalValue=initalValue;
	}
	
	//Getters and Setters
	public String getInitialValue() {return initalValue;}
	public boolean getBlockValue() {return block;}
	public Color getColor() {return color;}
	public Material getMaterial() {return material;}
	public void setMaterial(Material mat) {this.material=mat;}
	
	public void setTile() {
		block=true;
		color = Color.gray;
	}
	
	public void setTile(String tileFlag) {
		switch(tileFlag) {
			case "concrete":
				block=true;
				color = Color.gray;
				break;
			case "grass":
				block=false;
				color = new Color(96, 128, 56);
				break;
			case "tree":
				block=false;
				break;
			case "wood":
				block=false;
				break;
			case "placeholder":
				block=true;
				break;
			default:
				block=false;
				color = new Color(96, 128, 56);
		}
	}
	
	public void setEntity(Entity entity) {
		this.entity=entity;
		if(entity!=null)
			setTile(entity.getCharacterID());
	}
	public boolean hasEntity() {if(entity!=null) {return true;} return false;}
	public Entity getEntity() {return entity;}
	
	public boolean hasMaterial() {if(material!=null) {return true;} return false;}
	
	public void setPC(PC pc) {this.pc=pc;}
	public boolean hasPC() {if(pc!=null) {return true;} return false;}
	public Entity getPC() {return pc;}
	public void resetTile() {
		setTile("grass");
		setEntity(null);
	}
	public IncompleteStructure getIncompleteStructure() {
		if(entity.getCharacterID().equals("IncompleteStructure")) {
			return (IncompleteStructure) entity;
		}
		
		return null;
	}
	

}
