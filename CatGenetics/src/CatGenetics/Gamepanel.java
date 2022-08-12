package CatGenetics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class Gamepanel extends JPanel implements KeyListener{
	
	public enum GameState {
	    PICK_CAT,
	    PICK_TEST,
	    TEST_CAT,
	    PICK_MATE,
	    MATE_CATS,
	    CHECK_GOAL,
	    GAME_OVER
	}
	
	private GameState state = GameState.PICK_CAT;
	private int year = 0;
	private Cat kitten = null;
	private List<Cat> cats = new ArrayList<Cat>();
	private KeyEvent key=null;
	private int catChoice=-1;
	private int elementChoice=-1;
	private int catMateChoice=-1;
	private List<String> results = new ArrayList<String>();
	private int startingCats = 10;
	
	private int goalTotalCats = 50;
	
	public Gamepanel() {
		setBackground(new Color(64, 64, 64));
		setDoubleBuffered(true);
		setFocusable(true);
		addKeyListener(this);
		init();
	}
	
	public void init() {
		
		for(int i=0; i<startingCats; i++)
			cats.add(new Cat("Cat "+i));
	}
	
	public void run() {
		repaint();
		
		year++;
		//if(year%1000==0)
			//System.out.println(year);
		
	}
	
	public void gamemanager(Graphics g) {
		switch(state) {
			case PICK_CAT:
				catChoice=-1;
				if(key!=null)
					catChoice=Utilities.parseKeyNum(key);
				
				if(catChoice>=0 && catChoice<cats.size()) {
					state=GameState.PICK_TEST;
					key=null;
				}
				break;
				
			case PICK_TEST:
				Draw.coreElementList(g);
				
				elementChoice=-1;
				if(key!=null)
					elementChoice=Utilities.parseKeyNum(key);
				
				if(elementChoice>=0 && elementChoice<=5) {
					if(elementChoice==5)
						state=GameState.PICK_MATE;
					else
						state=GameState.TEST_CAT;
					key=null;
				}
				break;
				
			case TEST_CAT:
				String result=CatTest.element(cats.get(catChoice), Elements.getCoreElementList().get(elementChoice));
				Draw.testResult(g, result);
				
				
				if(key!=null)
					if(key.getKeyCode()==KeyEvent.VK_SPACE) {
						if(result.equals("You killed the cat.")) {
							cats.remove(catChoice);
						}
						
						results.add(result);
						state=GameState.CHECK_GOAL;
						key=null;
					}
				break;
			case PICK_MATE:
				catMateChoice=-1;
				if(key!=null)
					catMateChoice=Utilities.parseKeyNum(key);
				
				if(catMateChoice!=catChoice)
					if(catMateChoice>=0 && catMateChoice<cats.size()) {
						kitten = Mate.getOffspring(cats.get(catChoice), cats.get(catMateChoice));
						state=GameState.MATE_CATS;
						key=null;
					}
				break;
			case MATE_CATS:
				Draw.kitten(g, kitten);
				
				if(kitten==null) {
					cats.remove(catChoice);
					cats.remove(catMateChoice-1);
				}
				
				if(key!=null)
					if(key.getKeyCode()==KeyEvent.VK_SPACE) {
						if(kitten!=null)
							cats.add(kitten);
						kitten=null;
						state=GameState.CHECK_GOAL;
						key=null;
					}
				break;
			case CHECK_GOAL:
				if(CatTest.checkTotalCats(goalTotalCats, cats) || CatTest.checkCatElements(cats)) {
					state=GameState.GAME_OVER;
				}
				else {
					state=GameState.PICK_CAT;
				}
				break;
			case GAME_OVER:
				Draw.gameover(g);
				break;
		}
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.white);
		Draw.state(g, state.toString());
		Draw.cats(g, cats);
		Draw.results(g, results);
		
		gamemanager(g);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		key = e;	
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
