package LovecraftCrossing;

import java.util.List;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public final class Pathfinding {
	
	public static List<Node> findPath(Point start, Point goal, ArrayList<Point> blockedPoints) {
		Node initialNode = new Node(start);
		Node finalNode = new Node(goal);
		int rows = Settings.getTilesOnScreen().height;
		int cols = Settings.getTilesOnScreen().width;
		
		AStar aStar = new AStar(rows, cols, initialNode, finalNode);
		aStar.setBlocks(blockedPoints);
		
		List<Node> path = aStar.findPath();
		
		return path;
	}
	
	public static ArrayList<Point> createBlockedPointList(Tile[][] worldArray) {
		ArrayList<Point> blockedList = new ArrayList<Point>();
		for(int x=0; x<Settings.getTilesOnScreen().width; x++) {
			for(int y=0; y<Settings.getTilesOnScreen().height; y++) {
				if(worldArray[x][y].getBlockValue())
					blockedList.add(new Point(x, y));
			}
		}
		return blockedList;
	}
	
	public static Point findClosest(Tile[][] worldArray, String flag, Point start, boolean alive) {
		
		ArrayList<Point> list = new ArrayList<Point>();
		Point p = null;
		double distance=0;
		
		for(int x=0; x<Settings.getTilesOnScreen().width; x++) {
			for(int y=0; y<Settings.getTilesOnScreen().height; y++) {
				if(worldArray[x][y].hasEntity()) {
					if(worldArray[x][y].getEntity().getCharacterID().equals(flag)) {
						if(alive) {
							if(worldArray[x][y].getEntity().getAlive())
								list.add(new Point(x, y));
						}else {
							list.add(new Point(x, y));
						}
					}
				}
			}
		}
		
		if(list.size()>1) {
			p=new Point(list.get(0));
			distance = Point.distance(start.x,start.y, p.x, p.y);
			for(int i=1; i<list.size(); i++) {
				if(Point.distance(start.x,start.y, list.get(i).x, list.get(i).y)<distance) {
					p = new Point(list.get(i));
					distance=Point.distance(start.x,start.y, p.x, p.y);
				}
			}
			
			return p;
		}else if(list.size()==1) {
			return new Point(list.get(0));
		}else {
			return null;
		}
	}
	
	public static Point findClosest(Tile[][] worldArray, Point start, ArrayList<Point> list) {
		Point p = null;
		double distance=0;
		
		if(list.size()>1) {
			p=new Point(list.get(0));
			distance = Point.distance(start.x,start.y, p.x, p.y);
			for(int i=1; i<list.size(); i++) {
				if(Point.distance(start.x,start.y, list.get(i).x, list.get(i).y)<distance) {
					p = new Point(list.get(i));
					distance=Point.distance(start.x,start.y, p.x, p.y);
				}
			}
			
			return p;
		}else if(list.size()==1) {
			return new Point(list.get(0));
		}else {
			return null;
		}
	}
	
	public static Point findClosestMaterial(Tile[][] worldArray, Material material, Point start) {
		
		ArrayList<Point> list = new ArrayList<Point>();
		Point p = null;
		double distance=0;
		
		for(int x=0; x<Settings.getTilesOnScreen().width; x++) {
			for(int y=0; y<Settings.getTilesOnScreen().height; y++) {
				if(worldArray[x][y].hasMaterial()) {
					if(worldArray[x][y].getMaterial().getName().equals(material.getName())) {
						list.add(new Point(x, y));
					}
				}
			}
		}
		
		if(list.size()>1) {
			p=new Point(list.get(0));
			distance = Point.distance(start.x,start.y, p.x, p.y);
			for(int i=1; i<list.size(); i++) {
				if(Point.distance(start.x,start.y, list.get(i).x, list.get(i).y)<distance) {
					p = new Point(list.get(i));
					distance=Point.distance(start.x,start.y, p.x, p.y);
				}
			}
			
			return p;
		}else if(list.size()==1) {
			return new Point(list.get(0));
		}else {
			return null;
		}
	}
	
	
	public static IncompleteStructure findClosestIncompleteStructure(Point start, ArrayList<IncompleteStructure> list) {
		
		IncompleteStructure goal = null;
		double distance=0;
		
		if(list.size()>1) {
			goal=list.get(0);
			distance = Point.distance(start.x,start.y, goal.getPosition().x, goal.getPosition().y);
			for(int i=1; i<list.size(); i++) {
				if(Point.distance(start.x,start.y, list.get(i).getPosition().x, list.get(i).getPosition().y)<distance) {
					goal = list.get(i);
					distance=Point.distance(start.x,start.y, goal.getPosition().x, goal.getPosition().y);
				}
			}
			
			return goal;
		}else if(list.size()==1) {
			return list.get(0);
		}else {
			return null;
		}
	}
}
