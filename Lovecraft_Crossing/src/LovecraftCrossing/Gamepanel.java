package LovecraftCrossing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class Gamepanel extends JPanel implements MouseListener, KeyListener {

	private World world;
	boolean keys[] = new boolean[1000];
	
	Dimension tileSize=Settings.getScreenSize();
	Boolean showGrid=false;
	
	
	public Gamepanel() {
		addKeyListener(this);
		addMouseListener(this);
		setBackground(new Color(64, 64, 64));
		setDoubleBuffered(true);
		setFocusable(true);
		
		world = new World(); 
		repaint();
	}

	public void run() {
		world.update();
		repaint();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		world.draw(g);
		
		if(showGrid) {
			
			g.setColor(Color.white);

			for(int x=0; x<Settings.getTilesOnScreen().width; x++) {
				g.drawLine(Settings.TILESIZE*x, 0, Settings.TILESIZE*x, Settings.getScreenSize().height);
			}
			
			for(int y=0; y<Settings.getTilesOnScreen().height; y++) {
				g.drawLine(0, y*Settings.TILESIZE, Settings.getScreenSize().width, y*Settings.TILESIZE);
			}
		}
	}
	
	public void keyPressed(KeyEvent e) {
	    keys[e.getKeyCode()] = true;
	    
	    if(e.getKeyCode()==32) {
	    	showGrid=true;
	    }else {
	    	showGrid=false;
	    }
	    
	    world.update(e);
	}

	public void keyReleased(KeyEvent e) {
	    keys[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		Point clickPoint = new Point(e.getPoint());
		clickPoint = new Point(clickPoint.x/Settings.TILESIZE, clickPoint.y/Settings.TILESIZE);
		
		
		if(e.getButton()==MouseEvent.BUTTON1) {
			//world.setBlock(clickPoint);
			world.queueStructure(clickPoint);
		}
		
		
		if(e.getButton()==MouseEvent.BUTTON3) {
			//world.test(clickPoint);
			world.newPCDestination(clickPoint);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
