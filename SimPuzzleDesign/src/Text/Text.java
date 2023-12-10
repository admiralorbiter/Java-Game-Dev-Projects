package Text;

import java.awt.Font;
import java.awt.Graphics;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Text implements Serializable{
	public List<String> text = new ArrayList<String>();
	private  Font font = new Font("TimesRoman", Font.PLAIN, 36);
	
	public Text(List<String> text) {
		this.text=text;
	}
	
	public Text(String string) {
		text.add(string);
	}
	
	public void draw(Graphics g, int x, int y) {
		g.setFont(font);
		for(int i=0; i<text.size(); i++)
			g.drawString(text.get(i), x, y);
	}
	
	public List<String> getText(){return text;}
	public void addText(String string) {text.add(string);}
	public void setFont(Font font) {this.font=font;}
	
}
