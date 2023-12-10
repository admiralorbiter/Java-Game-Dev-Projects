package Application;

import javax.swing.JFrame;

import Gamepanels.Gamepanel;
import Gamepanels.Panel;
import Gamepanels.TitleScreen;

public class Application extends JFrame {

	private Panel panel=null;
	
	public Application() {
		
		setSize(Settings.getScreensize());
		
		setTitle("The Last Good Deed");

		if(Settings.skipIntro)
			panel = new Gamepanel();
		else
			panel = new TitleScreen();
		
		add(panel);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		repaint();
		setLocationRelativeTo(null);
	}
	
	public void run() {
		
		if(!panel.run())
			checkGameState();
		
		try {
			Thread.sleep(Settings.delayBetweenScreenRefresh);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	
	public static void main(String[] args) {
		Application app = new Application();
		app.setVisible(true);
		
		while(true) {
			app.run();
		}
	}
	
	public void checkGameState() {
		remove(panel);
		panel = panel.getTrigger().getNextPanel();
		add(panel);
		revalidate();
		repaint();		
	}
	
}
