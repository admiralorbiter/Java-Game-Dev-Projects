package Gamepanels;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

public abstract class Panel extends JPanel implements KeyListener, MouseListener, MouseMotionListener {
	
	protected PanelTrigger panelTrigger = null;
	protected boolean finished = true;
	
	public void setupWindow() {
		addKeyListener(this);
		addMouseListener(this);
		addMouseMotionListener(this);
		setBackground(Color.white);
		setDoubleBuffered(true);
		setFocusable(true);
		init();
		repaint();
	}
	
	public abstract void init();
	public abstract boolean run();

	public void destroy() {
		removeKeyListener(this);
	}
	
	public PanelTrigger getTrigger() {return panelTrigger;}
	
	public void keyReleased(KeyEvent e) {}
	public void keyTyped(KeyEvent e) {}
	public void keyPressed(KeyEvent e) {}
	public void mouseClicked(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mouseDragged(MouseEvent e) {}
	public void mouseMoved(MouseEvent e) {}
}
