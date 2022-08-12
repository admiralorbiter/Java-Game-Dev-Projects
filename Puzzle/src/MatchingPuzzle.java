import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MatchingPuzzle extends Puzzlepanel {

	private Entity test = new Entity(new Point(0, 0), new Point(100, 200), Color.white, "matching_card", null);
	
	private List<MatchingCard> cards;
	
	private MatchingCard firstSelection = null;
	private MatchingCard secondSelection = null;
	
	@Override
	public void init() {
		cards = new ArrayList<MatchingCard>();
		
		int index=0;
		for(int x=0; x<4; x++) {
			for(int y=0; y<3; y++) {
				cards.add(new MatchingCard(getOffset().x+x*200, getOffset().y+y*300, index));
				cards.get(index).setMatchID((int)index/2);
				index++;
			}
		}
		
		Collections.shuffle(cards);
	}

	@Override
	public String getTitle() {
		return "Matching Puzzle";
	}
	
	@Override
	public List<String> getInstructions() {
		List<String> instructions = new ArrayList<String>();
		
		instructions.add("This is where the instructions will go.");
		instructions.add("There may be multiple lines,");
		instructions.add("but I will need a max or have the actual game panel change based on instruction size");
		
		return instructions;
	}

	@Override
	public void drawGamePanel(Graphics g) {
	
		for(MatchingCard card : cards) {
			card.draw(g);
			
			if(firstSelection!=null)
				if(card.getID()==firstSelection.getID()) {
					g.setColor(Color.white);
					g.drawString("Card "+card.getMatchID(), card.getScreenPos().x, card.getScreenPos().y+50);
				}
			
			if(secondSelection!=null)
				if(card.getID()==secondSelection.getID()) {
					System.out.println("Test");
					g.setColor(Color.white);
					g.drawString("Card "+card.getMatchID(), card.getScreenPos().x, card.getScreenPos().y+50);
				}
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {	
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(getGameBoard().contains(e.getPoint())){
			for(MatchingCard card : cards)
				if(card.getCollisionBox().contains(e.getPoint())) {
					card.setColor(Color.red);
					if(firstSelection==null)
						firstSelection=card;
					else if(firstSelection!=card) {
						secondSelection=card;
					}
				}
		}
		
		if(secondSelection!=null) {
			checkMatch();
			repaint();
			try {
				Thread.sleep(600);
			} catch (InterruptedException exe) {
				exe.printStackTrace();
			}
			resetCards();
		}
		repaint();
	}
	
	private void checkMatch() {
		if(firstSelection.getMatchID()==secondSelection.getMatchID()) {
			cards.remove(firstSelection);
			cards.remove(secondSelection);
		}
		
		if(cards.size()==0)
			finished=true;
	}
	
	private void resetCards() {
		firstSelection.setColor(Color.white);
		secondSelection.setColor(Color.white);
		firstSelection=null;
		secondSelection=null;
	}

	@Override
	public void mousePressed(MouseEvent e) {	
	}

	@Override
	public void mouseReleased(MouseEvent e) {	
	}

	@Override
	public void mouseEntered(MouseEvent e) {	
	}

	@Override
	public void mouseExited(MouseEvent e) {	
	}
}
