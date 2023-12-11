package game;

import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;

public class Character extends Entity {

	Random rand = new Random();
	private int health = 50;
	
	public Character(Point position, String name) {
		super(position, name);
	}
	
	public void drawCharacter(Graphics g) {

		if(sprite!=null)
			g.drawImage(sprite, (int)position.getX(), (int)position.getY(), Settings.getCharacterWidth(), Settings.getCharacterHeight(), null );
		else
			g.drawRoundRect((int)position.getX(), (int)position.getY(), Settings.getCharacterWidth(), Settings.getCharacterHeight(), 10, 10);
	}

	
	public int getHealth() {return health;}
	public void setHealth(int health) {this.health=health;}
	
	public void moveRandomly(World world) {
		int direction = rand.nextInt(4);
		int move=Settings.getMove();
		int tileSize=Settings.getTileSize();
		Point dimensions = new Point(Settings.getCharacterWidth(), Settings.getCharacterHeight());
		
		if(position.getY()-move>=0 && direction==0) {
			if(world.isEmpty(new Point((int)position.getX()/tileSize, (int)(position.getY()-move)/tileSize), dimensions))
				setPosition(new Point((int)position.getX(), (int)(position.getY()-move)));
		}else if(position.getY()+move<=Settings.getHeight() && direction ==1) {
			if(world.isEmpty(new Point((int)position.getX()/tileSize, (int)(position.getY()+Settings.getCharacterHeight()+move)/tileSize), dimensions))
				setPosition(new Point((int)position.getX(), (int)(position.getY()+move)));
		}
		else if(position.getX()-move>=0 && direction ==2) {
			if(world.isEmpty(new Point((int)(position.getX()-move)/tileSize, (int)(position.getY()/tileSize)), dimensions))
				setPosition(new Point((int)position.getX()-move, (int)(position.getY())));
		}
		else if(position.getX()-move<=Settings.getWidth() && direction == 3) {
			if(world.isEmpty(new Point((int)(position.getX()+Settings.getCharacterWidth()+move)/tileSize, (int)(position.getY()/tileSize)), dimensions))
				setPosition(new Point((int)position.getX()+move, (int)(position.getY())));
		}
	}
	
	public void descreaseHealth(int damage) {health=health-damage;}
}
