package Panels;

import java.awt.Color;

import javax.swing.JPanel;

public abstract class Panel extends JPanel{
	public void setupWindow() {
		setBackground(Color.white);
		setDoubleBuffered(true);
		setFocusable(true);
		init();
		repaint();
	}
	
	public abstract void init();
	public abstract void run();
	public void draw() {
		repaint();
	}
}
