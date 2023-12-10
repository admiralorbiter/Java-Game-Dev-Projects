package Gamepanels;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import Application.Entity;
import Application.Player;
import Application.Settings;
import Application.World;
import Text.ConversationTextbox;
import Utility.Selection;
import Utility.Utility;


public class Gamepanel extends Panel implements KeyListener, MouseListener, MouseMotionListener {
	private boolean keys[] = new boolean[1000];
	private World world = null;
	private Player player = new Player();//should i move player to the world class
	private ConversationTextbox textbox = null;
	private Entity activeEntity=null;
	
	public Gamepanel() {
		world = new World(Settings.worldStart, player);
		setupWindow();
	}
	
	public Gamepanel(String filename) {
		world = new World(Settings.worldStart, player);
		setupWindow();
		if(filename!=null)
			loadGame(filename);
	}
	
	@Override
	public void init() {
		setBackground(world.getData().getBackgroundColor());
	}

	@Override
	public boolean run() {
		requestFocusInWindow();
		Entity collisionObject = player.update(keys, world);
		
		world.update(player);

		repaint();
		
		if(panelTrigger!=null) {
			//if(panelTrigger.isPanelTransition())
				saveGame("temp.ser");
			return false;
		}
		
		return finished;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		world.draw(g, player);
		
		if(textbox!=null)
			textbox.draw(g);
	}
	
	private void saveGame() {
		Utility.saveWorld(world, "save.ser");
	}
	
	private void saveGame(String filename) {
		Utility.saveWorld(world, filename);
	}

	private void loadGame(String filename) {
		world = Utility.load(filename);
		player.setPosition(world.getLastPlayerPoint());
	}
	
	//Key and Mouse Methods
	@Override
	public void keyPressed(KeyEvent e) {
		if(textbox!=null) {
			if(e.getKeyCode()==KeyEvent.VK_ESCAPE) {
				textbox=null;
			}else {
				activeEntity.setConversation(textbox.update(e, activeEntity.getConversation()));
				textbox = new ConversationTextbox(activeEntity.getConversation().getCurrentConversationText());
			}
		}
		
		if(e.getKeyChar()==KeyEvent.VK_0)
			saveGame();

		keys[e.getKeyCode()] = true;
		
		if(e.getKeyCode()==KeyEvent.VK_M) {
			panelTrigger = new PanelTrigger(true, new WorldMenu());
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		Entity entityClicked = Selection.selectEntity(e.getPoint(), world.getData().getObjectList());
		
		if(entityClicked!=null) {
			activeEntity=entityClicked;
			if(entityClicked.getType().equals("npc")) {
				textbox = new ConversationTextbox(entityClicked.getConversation().getCurrentConversationText());
			}
		}
	}
}
