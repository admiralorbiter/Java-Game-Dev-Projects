import java.awt.Color;
import java.awt.Point;

public class MatchingCard extends Entity{

	private int id;
	private int match_id;
	
	public MatchingCard(int x, int y, int id) {
		super(new Point(x, y), new Point(100, 200), Color.white, "matching_card", null);
		this.id=id;
	}
	
	public int getMatchID() {return match_id;}
	public void setMatchID(int id) {this.match_id=id;}
	public int getID() {return id;}

}
