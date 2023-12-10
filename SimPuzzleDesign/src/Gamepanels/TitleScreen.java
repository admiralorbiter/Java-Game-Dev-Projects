package Gamepanels;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import Gamepanels.PanelTrigger;
import Text.TitleSceenText;

public class TitleScreen extends Panel{
	
	private titlestate state = titlestate.TITLE_STATE;
	private TitleSceenText text=new TitleSceenText();
	
	public enum titlestate {
	    TITLE_STATE,
	    STORY_STATE;
	}
	
	public TitleScreen() {
		text.TitleMessage();
		setupWindow();
		panelTrigger = new PanelTrigger(true, new Gamepanel());
	}
	
	@Override
	public boolean run() {
		repaint();
		
		if(finished)
			return false;
		
		return true;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g); 
		text.drawText(g);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		text.update(e);
		
		if(text.isFinished())
			stateChange();
		
		repaint();
		
		if(e.getKeyCode()==KeyEvent.VK_L)
			panelTrigger = new PanelTrigger(true, new Gamepanel("save.ser"));
	}

	private void stateChange() {
		if (state==titlestate.TITLE_STATE) {
			text.StoryMessage();
			state=titlestate.STORY_STATE;
		}
		else if(state==titlestate.STORY_STATE) {
			finished=true;
			destroy();
		}
	}

	@Override
	public void init() {
		setBackground(Color.white);
	}
}
