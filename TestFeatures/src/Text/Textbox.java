package Text;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import Application.Settings;
import Conversation.ConversationNode;

public class Textbox {

	private List<Text> textArray = new ArrayList<Text>();
	private boolean active=false;
	private int index=0;
	
	public Textbox(List<Text> textArray) {
		if(textArray!=null)
			active=true;
		
		this.textArray=textArray;
	}
	
	public ConversationNode update(KeyEvent e, ConversationNode conversation) {	
		if(Character.getNumericValue(e.getKeyChar())>0 && Character.getNumericValue(e.getKeyChar())<=textArray.size()-1) {
			index=Character.getNumericValue(e.getKeyChar());
			System.out.println(conversation.getChildren().get(index-1).getData().getText().get(0));
			return conversation.getChildren().get(index-1);
		}
		
		return null;
	}
	
	public void draw(Graphics g) {
		if(active) {
			g.setColor(Color.gray);
			g.fill3DRect(100, Settings.getScreensize().height-400, Settings.getScreensize().width-200, 250, true);
			
			g.setColor(Color.WHITE);
			g.setFont(new Font("TimesRoman", Font.PLAIN, 36));
			g.drawString(textArray.get(index).text.get(0), 150, Settings.getScreensize().height-350);
			for(int i=1; i<textArray.get(index).text.size(); i++) {
				g.drawString(i+": "+textArray.get(index).text.get(i), 150, Settings.getScreensize().height-350+i*45);
			}
		}
	}
	
	//Getters and Setters
	public boolean isActive() {return active;}
	public void setActive(boolean active) {this.active=active;}
	
}
