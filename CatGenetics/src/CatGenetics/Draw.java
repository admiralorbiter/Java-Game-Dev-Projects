package CatGenetics;

import java.awt.Font;
import java.awt.Graphics;
import java.util.List;

public final class Draw {
	
	public static void gameover(Graphics g) {
		g.setFont(new Font("Serif", Font.PLAIN, 24));
		g.drawString("GAME OVER", 400, 25);
	}
	
	public static void kitten(Graphics g, Cat kitten) {
		g.setFont(new Font("Serif", Font.PLAIN, 24));
		if(kitten!=null)
			g.drawString("Kitten successsfully created.", 400, 25);
		else
			g.drawString("You killed both cats", 400, 25);
	}
	
	public static void results(Graphics g, List<String> results) {
		g.setFont(new Font("Serif", Font.PLAIN, 24));
		g.drawString("Past Results", 900, 25);
		
		for(int i=0; i<results.size(); i++) {
			g.drawString(results.get(i), 900, 50+25*i);
		}
	}
	
	public static void testResult(Graphics g, String result) {
		g.setFont(new Font("Serif", Font.PLAIN, 24));
		g.drawString("Results: Press space to continue", 400, 25);
		
		g.drawString(result, 400, 50);
		
	}
	
	public static void state(Graphics g, String state) {
		g.setFont(new Font("Serif", Font.PLAIN, 24));
		g.drawString(state, 10, 25);
	}
	
	public static void coreElementList(Graphics g) {
		g.drawRect(400, 1, 325, 175);
		List<String> elementList = Elements.getCoreElementList();
		
		g.setFont(new Font("Serif", Font.PLAIN, 24));
		g.drawString("Pick one of the elements below: ", 400+10, 25);
		
		for(int i=0; i<elementList.size(); i++) {
			g.drawString(i+": "+elementList.get(i), 400+10, 50+25*i);
		}
		
		g.drawString("5: Mate Cats", 400+10, 50+25*5);
	}
	
	public static void cats(Graphics g, List<Cat> cats) {
		g.setFont(new Font("Serif", Font.PLAIN, 24));
		g.drawString("Cats", 10, 50);
		
		for(int i=0; i<cats.size(); i++) {
			g.drawString(i+": "+cats.get(i).getCharacterID(), 10, 75+25*i);
		}
	}
}
