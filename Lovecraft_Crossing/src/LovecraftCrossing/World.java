package LovecraftCrossing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class World {
	private Tile[][] worldArray = new Tile[Settings.getTilesOnScreen().width][Settings.getTilesOnScreen().height];
	
	final private Dimension viewSize=Settings.getScreenSize();
	
	PC pc = new PC(new Point(1, 1), "player");
	
	ArrayList<IncompleteStructure> structureQueue = new ArrayList<IncompleteStructure>();
	
	public World() {

		for(int x=0; x<Settings.getTilesOnScreen().width; x++) {
			for(int y=0; y<Settings.getTilesOnScreen().height; y++) {
				worldArray[x][y] = new Tile();
			}
		}
		
		generateTrees(10);
		
		worldArray[pc.gridPosition.x][pc.gridPosition.y].setEntity(pc);
	}
	
	//Getters and Setters
	public Tile[][] getWorldArray(){return worldArray;}
	
	public void draw(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, viewSize.width, viewSize.height);
		g.setColor(Color.white);
		
		for(int x=0; x<Settings.getTilesOnScreen().width; x++) {
			for(int y=0; y<Settings.getTilesOnScreen().height; y++) {
				g.setColor(worldArray[x][y].getColor());
				g.fillRect(x*Settings.TILESIZE, y*Settings.TILESIZE, Settings.TILESIZE, Settings.TILESIZE);
				
				if(worldArray[x][y].hasEntity()) {
					worldArray[x][y].getEntity().draw(g);
				}
				
				if(worldArray[x][y].hasMaterial()) {
					worldArray[x][y].getMaterial().draw(g, new Point(x, y));
				}
			}
		}

		pc.draw(g);
	}
	
	public void update() {
		pc.update(worldArray, structureQueue);
	}
	
	public void update(KeyEvent e) {
		
		if(e.getKeyCode()==KeyEvent.VK_C) {
			if(pc.getActivity().equals("cutting_wood"))
				pc.setActivity("idle");
			else
				pc.setActivity("cutting_wood");
		}
		
		if(e.getKeyCode()==KeyEvent.VK_B) {
			if(pc.getActivity().equals("building"))
				pc.setActivity("idle");
			else
				pc.setActivity("building");
		
		}
	}
	
	public void setBlock(Point p) {
		worldArray[p.x][p.y].setTile();
	}
	
	public void generateTrees(int count) {
		Random r = new Random();
		for(int i=0; i<count; i++) {
			int w = r.nextInt(Settings.getTilesOnScreen().width);
			int h = r.nextInt(Settings.getTilesOnScreen().height);
			if(!worldArray[w][h].hasEntity()) {
				worldArray[w][h].setEntity(new Tree(new Point(w, h)));
			}
		}
	}
	
	public void queueStructure(Point point) {
		if(!worldArray[point.x][point.y].hasEntity()) {
			worldArray[point.x][point.y].setEntity(new IncompleteStructure(point, new Material("wood", 3), "concrete"));
			if(worldArray[point.x][point.y].getIncompleteStructure()!=null)
				structureQueue.add(worldArray[point.x][point.y].getIncompleteStructure());
		}
	}
	
	//[TEST]
	public void test(Point clickPoint) {
		worldArray[pc.getPosition().x][pc.getPosition().y].setEntity(null);
		pc.setPosition(clickPoint);
		worldArray[pc.getPosition().x][pc.getPosition().y].setEntity(pc);
	}
	
	//[TEST]
	public void newPCDestination(Point clickPoint) {
		List<Node> path = Pathfinding.findPath(pc.getPosition(), clickPoint, Pathfinding.createBlockedPointList(worldArray));
		pc.setDestination(clickPoint, path);
	}	
}
