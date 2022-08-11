package Mistborn;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Application extends JFrame {

	private Gamepanel game;
	
	public Application() {
		Dimension screenSize =Settings.getTileSize();
		screenSize.setSize(screenSize.getWidth()+50, screenSize.getHeight()+50);
		setSize(screenSize);
		
		setTitle("Mistborn");
		
		game = new Gamepanel();
		add(game);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		repaint();
		setLocationRelativeTo(null);
	}
	
	public void run() {
		game.run();
		
		try {
			Thread.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Application app = new Application();
		app.setVisible(true);
		
		while(true)
			app.run();
	}

}
