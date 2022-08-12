import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

public abstract class Puzzlepanel extends Panel implements KeyListener, MouseListener{

	private Font titleFont = new Font("TimesRoman", Font.PLAIN, 36);
	private Font instructionFont = new Font("TimesRoman", Font.PLAIN, 24);
	public abstract String getTitle();
	public abstract List<String> getInstructions();
	
	public Puzzlepanel() {
		addKeyListener(this);
		addMouseListener(this);
		setBackground(Color.black);
		repaint();
		setupWindow();
		init();
	}
	
	public abstract void init();
	
	@Override
	public void run() {
		requestFocusInWindow();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.white);
		g.setFont(titleFont);
		g.drawString(getTitle(), 25, 50);
		
		g.setFont(instructionFont);
		for(int i=0; i<getInstructions().size(); i++)
			g.drawString(getInstructions().get(i), 25, 50+25*(i+1));
		
		g.drawRect(25, 50+25*getInstructions().size()+25, Settings.getWindowSize().width-50, Settings.getWindowSize().height-2*(50+25*getInstructions().size())+50);
		
		drawGamePanel(g);
	}
	
	public abstract void drawGamePanel(Graphics g);
	
	public Point getOffset() {return new Point(50, 50+25*getInstructions().size()+50);}
	public Rectangle getGameBoard() {return new Rectangle(25, 50+25*getInstructions().size()+25, Settings.getWindowSize().width-50, Settings.getWindowSize().height-2*(50+25*getInstructions().size())+50);}
	
}
