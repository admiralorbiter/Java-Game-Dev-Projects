package LovecraftCrossing;

import java.awt.Color;
import java.awt.Point;
import java.util.Random;


public class Tree extends Entity{
	
	private static int totalHP=Settings.TREE_HP;
	
	public Tree(Point gridPosition) {
		super(gridPosition, "tree", totalHP);
		setColor(Color.GREEN);
	}
	
	@Override
	public void update() {

		if(hp<totalHP/2 && hp>0)
			setColor(new Color(160, 82, 45));
		
		if(!getAlive())
			setColor(Color.BLACK);
	}
	
	public int getDropCount() {
		Random r = new Random();
		return r.nextInt(Settings.TREE_DROP_RATE);
	}
}
