package Text;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class TitleSceenText{
	protected List<Text> textArray = new ArrayList<Text>();
	protected Font font = new Font("TimesRoman", Font.PLAIN, 36);
	
	private int y=100;
	private int x=10;
	private int index=0;
	private boolean finished=false;
	
	public TitleSceenText() {
		
	}
	
	public void drawText(Graphics g) {
		g.setFont(font);
		for(int i=0; i<=index; i++) {	
			for(int j=0; j<textArray.get(i).getText().size(); j++)
				g.drawString(textArray.get(i).getText().get(j), x, y+30*(i+1)+30*j);
		}
		
	}
	
	public void update(KeyEvent e) {
		
		if(textArray.size()-1==getIndex())
			finished=true;
		
		if(e.getKeyCode()==KeyEvent.VK_SPACE)
			index++;
		
		if(index==textArray.size())
			index=0;

	}
	
	private void resetVariables() {
		finished=false;
		textArray = new ArrayList<Text>();
	}
	
	public int getIndex() {return index;}
	public boolean isFinished() {return finished;}
	
	//Load message
	//Could separate into a loader to decouple
	public void StoryMessage() {
		resetVariables();
		
		textArray.add(new Text("I might be standing in the entrance of something big, and inside lay a world that belonged to Kumiko alone,"));
		textArray.add(new Text("a vast world that I had never known."));
		textArray.add(new Text("I saw it as a big, dark room."));
		textArray.add(new Text("I was standing there holding a cigarette lighter, its tiny flame showing me only the smallest part of the room."));
		textArray.add(new Text(" Would I ever see the rest? "));
		textArray.add(new Text("Or would I grow old and die without ever really knowing her? "));
		textArray.add(new Text("If that was all that lay in store for me, then what was the point of this married life I was leading?"));
		textArray.add(new Text("What was the point of my life at all if I was spending it in bed with an unknown companion? "));
		textArray.add(new Text("This was what I thought about that night and what I went on thinking about long afterward from time to time. "));
		textArray.add(new Text("Only much later did it occur to me that I had found my way into the core of the problem."));
	}
	
	public void TitleMessage() {
		resetVariables();
		
		List<String> m = new ArrayList<String>();	
		m.add("The Last Good Deed In A Weary World");
		m.add("Press 'L' to load previous world state.");
		m.add("While playing, press '0' to save anytime.");
		textArray.add(new Text(m));
	}
}
