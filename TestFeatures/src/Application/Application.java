package Application;
import java.awt.Panel;

import javax.swing.JFrame;

import Panels.TextFeatures;

public class Application extends JFrame {
	private TextFeatures panel;
	
	public Application() {
		setSize(Settings.getScreensize());
		setTitle("Testing Features");
		
		panel = new TextFeatures();
		
		add(panel);
		panel.setupWindow();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		repaint();
		setLocationRelativeTo(null);
	}
	
	public void run() {
		panel.run();
	}
	
	public static void main(String[] args) {
		Application app = new Application();
		app.setVisible(true);
		
		while(true) {
			app.run();
		}
	}
}
