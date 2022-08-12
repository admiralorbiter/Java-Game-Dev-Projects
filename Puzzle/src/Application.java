
import javax.swing.JFrame;

public class Application extends JFrame{
	
	private Panel currentPanel;
	
	public Application() {
		setSize(Settings.getScreensize());
		setTitle("Puzzle Tester");
		currentPanel = new MatchingPuzzle();
		add(currentPanel);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		repaint();
		setLocationRelativeTo(null);
	}
	
	public void run() {
		currentPanel.run();
		
		try {
			Thread.sleep(60);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		if(currentPanel.finished())
			System.exit(0);
	}
	
	public static void main(String[] args) {
		Application app = new Application();
		app.setVisible(true);
		
		while(true) {
			app.run();
		}
	}
}
