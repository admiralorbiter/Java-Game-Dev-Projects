import java.awt.Color;

import javax.swing.JPanel;

public abstract class Panel extends JPanel {
	
	protected boolean finished=false;
	
	public void setupWindow() {
		setDoubleBuffered(true);
		setFocusable(true);
		repaint();
	}
	public abstract void run();
	public void draw() {
		repaint();
	}
	
	public boolean finished() {return finished;}
}

