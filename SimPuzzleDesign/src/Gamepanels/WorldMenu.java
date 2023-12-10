package Gamepanels;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import Application.Entity;
import Application.SelectWorld;
import Application.Settings;

public class WorldMenu extends Panel{
	private List<Entity> objectList = new ArrayList<Entity>();
	private SelectWorld selection = null;
	private String tempSaveFile=null;
	
	public WorldMenu() {
		setupWindow();
		panelTrigger = null;
		objectList = load();
	}
	
	public WorldMenu(String file) {
		setupWindow();
		panelTrigger = null;
		objectList = load();
		tempSaveFile=file;
	}
	
	@Override
	public void init() {
		setBackground(Color.white);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g); 
		g.setColor(Color.BLACK);
		drawObjects(g);
	}

	@Override
	public boolean run() {
		requestFocusInWindow();
		repaint();
		
		if(panelTrigger!=null) {
			return false;
		}
		
		return true;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_M) {
			if(selection==null && tempSaveFile!=null)
				panelTrigger = new PanelTrigger(true, new Gamepanel(tempSaveFile));
			else if(selection!=null)
				panelTrigger = new PanelTrigger(true, new Gamepanel());
		}
	}
	
	private List<Entity> load() {
		int row=1;
		List<Entity> objectList = new ArrayList<Entity>();
		objectList.add(new Entity(new Point((int) (Settings.getScreensize().width*.4)/Settings.size,(int) (Settings.getScreensize().height*.05)/Settings.size), new Point((int)(Settings.getScreensize().width-Settings.getScreensize().width*.8)/Settings.size,((int) (Settings.getScreensize().height*.1))/Settings.size),Color.black, "title", new ImageIcon("src/img/worldselection.png")));
		row=2;
		objectList.add(new Entity(new Point((int) (Settings.getScreensize().width*.4)/Settings.size,(int) (Settings.getScreensize().height*.05*row+((int) (Settings.getScreensize().height*.1)))/Settings.size), new Point((int)(Settings.getScreensize().width-Settings.getScreensize().width*.8)/Settings.size,((int) (Settings.getScreensize().height*.1))/Settings.size),Color.black, "world1", new ImageIcon("src/img/world1.png")));
		return objectList;
	}
	
	private ImageIcon loadHighlight(int index) {
		switch(index) {
			case 0:
				selection = SelectWorld.ONE;
				return new ImageIcon("src/img/worldselectionhighlight.png");
			case 1:
				selection = SelectWorld.TWO;
				return new ImageIcon("src/img/world1highlight.png");
			default:
				selection = null;
				return null;
		}
	}
	
	private void drawObjects(Graphics g) {
		for(Entity entity : objectList)
			entity.draw(g);
	}

	@Override
	public void mousePressed(MouseEvent e) {

		objectList = load();
		
		for(int i=1; i<objectList.size(); i++) {
			if(objectList.get(i).getCollisionBox().contains(e.getPoint())) {
				objectList.get(i).setImageIcon(loadHighlight(i));
				return;
			}
		}	
	}
	
	public SelectWorld getWorldSelection() {return selection;}
}
