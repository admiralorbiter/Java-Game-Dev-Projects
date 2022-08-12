package Text;

import java.util.ArrayList;
import java.util.List;

public class Text {
	public List<String> text = new ArrayList<String>();
	
	public Text(List<String> text) {
		this.text=text;
	}
	
	public Text(String string) {
		text.add(string);
	}
	
	public List<String> getText(){return text;}
	public void addText(String string) {text.add(string);}
	
}
