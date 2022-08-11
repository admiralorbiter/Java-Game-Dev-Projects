package Checkers;

import java.util.Random;

public class AI {
	public AI() {
		
	}
	
	void randomMove(Selector s) {
		Random rand = new Random();
		int  n;
		if(s.piecesInList>1)
			n = rand.nextInt(s.piecesInList-1);
		else
			n=0;
		if(s.piecesInList==0)
			System.out.println("No Moves");
		//System.out.println(s.piecesInList+" - "+n);
		//s.setCoord(s.pieces[n].getX(), s.pieces[n].getY());
		s.listIndex=n;
	}
}
