package LovecraftCrossing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class PC extends Entity {

	protected Point destination = null;
	protected List<Node> path = null;
	protected int pathIndex = 0;
	
	private static int totalHP=100;
	private int tickCountTracker=0;
	
	private String activity = "idle";
	private int attack=5;
	
	private Material holding = null;
	private IncompleteStructure buildingGoal=null;
	private Material matsHeld=null;
	private Point matsGoal=null;
	
	public PC(Point gridPosition, String characterID) {
		super(gridPosition, characterID, totalHP);
	}
	
	//Getters and Setters
	public Material getMaterial() {return holding;}
	public void setMaterial(Material mat) {this.holding=mat;}
	public Point getDestination() {return destination;}
	public void setDestination(Point p, List<Node> path) { 
		this.destination= new Point(p);
		this.path=path;
		pathIndex=0;
	}
	
	
	@Override 
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillOval(gridPosition.x*Settings.TILESIZE, gridPosition.y*Settings.TILESIZE, Settings.TILESIZE, Settings.TILESIZE);
		//g.fillRect(gridPosition.x*Settings.TILESIZE, gridPosition.y*Settings.TILESIZE, Settings.TILESIZE, Settings.TILESIZE);
		
		g.drawString(activity, 10, 100);
		
		if(destination!=null) {
			g.setColor(Color.magenta);
			g.drawLine(gridPosition.x*Settings.TILESIZE+Settings.TILESIZE/2,  gridPosition.y*Settings.TILESIZE+Settings.TILESIZE/2, 
					destination.x*Settings.TILESIZE+Settings.TILESIZE/2, destination.y*Settings.TILESIZE+Settings.TILESIZE/2);
			
			for(Node node : path) {
				g.drawRect(node.getCol()*Settings.TILESIZE, node.getRow()*Settings.TILESIZE, Settings.TILESIZE, Settings.TILESIZE);
			}
		}
	}
	
	public void setActivity(String flag) {
		activity=flag;
	}
	public String getActivity() {return activity;}
	
	public void update(Tile[][] worldArray, ArrayList<IncompleteStructure> structureQueue) {
		if(tickCountTracker==Settings.MOVE_TICK_TOTAL) {
			tickCountTracker=0;
			movement(worldArray);
			
			switch(activity) {
				case "cutting_wood":
					cutting_wood(worldArray);
					break;
				case "building":
					building(worldArray, structureQueue);
					break;
			}
		}else {
			tickCountTracker++;
		}
	}
	
	private void movement(Tile[][] worldArray) {
		
		if(destination!=null) {
			if(worldArray[path.get(pathIndex).getCol()][path.get(pathIndex).getRow()].getBlockValue()) {
				List<Node> path = Pathfinding.findPath(getPosition(), destination, Pathfinding.createBlockedPointList(worldArray));
				this.path=path;
				pathIndex=0;
				
				if(path.isEmpty()) {
					destination=null;
					path=null;
				}
			}else {
				setPosition(new Point(path.get(pathIndex).getPoint()));
				pathIndex++;
				
				if(getPosition().equals(destination)) {
					destination=null;
					path=null;
					pathIndex=0;
				}
			}
		}
	}
	
	private void cutting_wood(Tile[][] worldArray) {
		if(destination==null) {
			if(worldArray[gridPosition.x][gridPosition.y].hasEntity()) {
				if(worldArray[gridPosition.x][gridPosition.y].getEntity().getCharacterID().equals("tree") && worldArray[gridPosition.x][gridPosition.y].getEntity().getAlive()) {
					worldArray[gridPosition.x][gridPosition.y].getEntity().takeDamage(attack);
					if(worldArray[gridPosition.x][gridPosition.y].getEntity().getAlive()==false) {
						Tree tree = (Tree) worldArray[gridPosition.x][gridPosition.y].getEntity();
						int drop = tree.getDropCount();
						worldArray[gridPosition.x][gridPosition.y].setMaterial(new Material("wood", drop));
						worldArray[gridPosition.x][gridPosition.y].resetTile();
					}
				}else {
					Point target = Pathfinding.findClosest(worldArray, "tree", gridPosition, true);
					if(target==null)
						activity="idle";
					else {
						List<Node> path = Pathfinding.findPath(getPosition(), target, Pathfinding.createBlockedPointList(worldArray));
						setDestination(target, path);
					}
				}
			}else {
				Point target = Pathfinding.findClosest(worldArray, "tree", gridPosition, true);
				if(target==null)
					activity="idle";
				else {
					List<Node> path = Pathfinding.findPath(getPosition(), target, Pathfinding.createBlockedPointList(worldArray));
					setDestination(target, path);
				}
			}
		}
	}
	
	private void building(Tile[][] worldArray, ArrayList<IncompleteStructure> structureQueue) {

		if(buildingGoal==null) {
			buildingGoal = Pathfinding.findClosestIncompleteStructure(gridPosition, structureQueue);
			
			if(buildingGoal==null) {
				activity="idle";
			}
		}else {
		
			if(matsHeld==null && matsGoal==null) {
				matsGoal = Pathfinding.findClosestMaterial(worldArray, buildingGoal.getMaterialNeeded(), gridPosition);
			
				if(matsGoal==null) {
					activity="idle";
				}
				
				if(matsGoal!=null) {
					List<Node> path = Pathfinding.findPath(getPosition(), matsGoal, Pathfinding.createBlockedPointList(worldArray));
					setDestination(matsGoal, path);
				}
				
			}else if(matsHeld==null && matsGoal!=null) {
				if(matsGoal.equals(gridPosition)) {
					//pick up mats
					matsHeld=worldArray[gridPosition.x][gridPosition.y].getMaterial();
					worldArray[gridPosition.x][gridPosition.y].setMaterial(null);
					matsGoal=null;
					
					List<Node> path = Pathfinding.findPath(getPosition(), buildingGoal.getPosition(), Pathfinding.createBlockedPointList(worldArray));
					setDestination(buildingGoal.getPosition(), path);
				}
			}else if(matsHeld!=null && matsGoal!=null) {
				if(matsGoal.equals(gridPosition)) {
					//Drop mats
					Material temp = worldArray[gridPosition.x][gridPosition.y].getMaterial();
					worldArray[gridPosition.x][gridPosition.y].setMaterial(null);//maybe not needed
					worldArray[gridPosition.x][gridPosition.y].setMaterial(matsHeld);
					matsHeld=null;
					matsHeld=temp;
					matsGoal=null;
					
					List<Node> path = Pathfinding.findPath(getPosition(), buildingGoal.getPosition(), Pathfinding.createBlockedPointList(worldArray));
					setDestination(buildingGoal.getPosition(), path);
				}
			}else if(matsHeld!=null && matsGoal==null) {
				if(buildingGoal.getPosition().equals(gridPosition)) {
					int materialLeftOver = buildingGoal.addMaterial(matsHeld.getQuantity());
					if(materialLeftOver!=0) {
						matsHeld.setQuantity(materialLeftOver);
					}else {
						matsHeld=null;
					}
					
					if(buildingGoal.structureComplete()) {
						worldArray[buildingGoal.getPosition().x][buildingGoal.getPosition().y].resetTile();
						worldArray[buildingGoal.getPosition(). x][buildingGoal.getPosition().y].setTile(buildingGoal.getBuildingType());
						buildingGoal=null;
						activity="idle";
					}
				}
			}
			
		}
		

	}
}
