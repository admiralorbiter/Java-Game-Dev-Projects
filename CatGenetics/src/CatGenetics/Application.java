package CatGenetics;

import javax.swing.JFrame;

public class Application extends JFrame{
	
	Gamepanel game;
	
	public Application() {
		setSize(1900, 1200);
		setTitle("Cat Genetics");
		
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
