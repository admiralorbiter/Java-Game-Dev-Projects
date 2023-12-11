package game;

public class Tile {
	
	boolean empty;
	
	public Tile() {
		empty=true;
	}
	
	public void toggleEmpty() {empty=!empty;}
	public boolean isEmpty() {return empty;}
}
