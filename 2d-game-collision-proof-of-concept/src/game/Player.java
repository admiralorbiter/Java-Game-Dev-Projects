package game;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Player extends Character {

	
	
	public Player(Point position, String name) {
		super(new Point(Settings.getWidth()/2, Settings.getHeight()/2), name);
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("src/pictures/character.png"));
		} catch (IOException e) {}
		setSprite(img);
	}

	public void keyEvent(KeyEvent k, World world) {
	
		int move=Settings.getMove();
		int tileSize=Settings.getTileSize();
		//Point dimensions = new Point(Settings.getCharacterWidth(), Settings.getCharacterHeight());
		int test=1;
		if((k.getKeyCode()==KeyEvent.VK_UP || k.getKeyChar()=='w') && (position.getY()-move>=0)) {
			if(world.isEmpty(new Point((int)position.getX()/tileSize, (int)(position.getY()-move)/tileSize), new Point(Settings.getCharacterWidth()/Settings.getTileSize(), test)))
				setPosition(new Point((int)position.getX(), (int)(position.getY()-move)));
		}
		else if((k.getKeyCode()==KeyEvent.VK_DOWN || k.getKeyChar()=='s')&& (position.getY()+move<=Settings.getHeight())) {
			if(world.isEmpty(new Point((int)position.getX()/tileSize, (int)(position.getY()+Settings.getCharacterHeight()+move)/tileSize), new Point(Settings.getCharacterWidth()/Settings.getTileSize(), test)))
				setPosition(new Point((int)position.getX(), (int)(position.getY()+move)));
		}
		else if((k.getKeyCode()==KeyEvent.VK_LEFT || k.getKeyChar()=='a')&& (position.getX()-move>=0)) {
			if(world.isEmpty(new Point((int)(position.getX()-move)/tileSize, (int)(position.getY()/tileSize)), new Point(test, Settings.getCharacterHeight()/Settings.getTileSize())))
				setPosition(new Point((int)position.getX()-move, (int)(position.getY())));
		}
		else if((k.getKeyCode()==KeyEvent.VK_RIGHT || k.getKeyChar()=='d')&& (position.getX()-move<=Settings.getWidth())) {
			if(world.isEmpty(new Point((int)(position.getX()+Settings.getCharacterWidth()+move)/tileSize, (int)(position.getY()/tileSize)), new Point(test, Settings.getCharacterHeight()/Settings.getTileSize())))
				setPosition(new Point((int)position.getX()+move, (int)(position.getY())));
		}
	}
	
}
