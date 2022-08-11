package Checkers;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

public class Application extends JFrame{

	GamePanel game;
	Boolean playing;
	
	public Application() {
		initUI();
	}
	
	public static void main(String[] args) {
		Application app = new Application();
		app.setVisible(true);

	}
	
	void initUI() {
		setSize(800, 900);
		setTitle("Checkers");
		game=new GamePanel();
		setJMenuBar(initMenuBar());
		add(game);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		repaint();
		setLocationRelativeTo(null);
		playing=true;
	}
	
	public JMenuBar initMenuBar() {
		setLayout(new BorderLayout());
		JMenuBar menubar=new JMenuBar();
		JMenu menu = new JMenu("Game");
		menu.setMnemonic('G');
		JMenuItem menuItem = new JMenuItem("New");
		menuItem.setActionCommand("new_game");
		menuItem.setMnemonic('N');
		menu.add(menuItem);
		menubar.add(menu);
		
		return menubar;	
	}
}
