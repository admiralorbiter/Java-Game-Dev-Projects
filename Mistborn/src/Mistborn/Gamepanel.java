package Mistborn;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class Gamepanel extends JPanel implements KeyListener {

	private World world;
	boolean keys[] = new boolean[1000];
	
	Dimension tileSize=Settings.getTileSize();
	
	public Gamepanel() {
		addKeyListener(this);
		setBackground(new Color(64, 64, 64));
		setDoubleBuffered(true);
		setFocusable(true);
		
		world = new World(); 
		repaint();
	}

	public void run() {
		world.update(keys);
		repaint();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		world.draw(g);
	}
	
	public void keyPressed(KeyEvent e) {
	    keys[e.getKeyCode()] = true;
	}

	public void keyReleased(KeyEvent e) {
	    keys[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
