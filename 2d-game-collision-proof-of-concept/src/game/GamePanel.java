package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements KeyListener {

	TimerTask repeatedTask = new TimerTask() {
        public void run() {
           player.descreaseHealth(2);
           testNPC.descreaseHealth(2);
        }
    };
	
	Player player = new Player(null, "Player");
	World world = new World();
	long startTime;
	double estimatedTimeSeconds;
	Character testNPC = new Character(new Point(100, 100), "NPC");
	boolean running;
	Timer hunger = new Timer("Hunger");
	Zone bedroom;
	
	public enum GameState {
	    TITLE_STATE,
	    RUNNING;
	}
	
	public GamePanel() {
		addKeyListener(this);
		setBackground(new Color(64, 64, 64));
		setDoubleBuffered(true);
		setFocusable(true);
		
		repaint();
		
		gameSetup();
	}
	
	private void gameSetup() {
		startTime = System.nanoTime();
		world.addCharacter(player);
		world.addCharacter(testNPC);
		running=true;
		
		bedroom = new Zone(new Point(0, 0), "bedroom",new Point(200, 200));
		
	    hunger.scheduleAtFixedRate(repeatedTask, Settings.getHealthDecreaseRate(), Settings.getHealthDecreaseRate());
	}
	
	public void run() {
		estimatedTimeSeconds = (System.nanoTime()-startTime)*Math.pow(10, -9);
		gameManager();
		repaint();
	}
	
	public void gameManager() {
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		bedroom.draw(g);
		g.setColor(Color.MAGENTA);
		world.drawCharacters(g);
		g.drawString(String.valueOf(Math.round(estimatedTimeSeconds)), 20, Settings.getHeight()+25);

		ViewWindowLogic.updateCollision(world);
		//world.testDrawWorld(g);
		world.drawMenu(g);
	}

	@Override
	public void keyPressed(KeyEvent k) {
		player.keyEvent(k, world);
		//repaint();
	}

	@Override
	public void keyReleased(KeyEvent arg0) {}

	@Override
	public void keyTyped(KeyEvent arg0) {}
	
}
