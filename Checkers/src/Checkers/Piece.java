package Checkers;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Piece extends Sprite {

	public boolean destroyed;
	String player;
	boolean king;
	/*  
	 	int x;
    	int y;
    	Image image;
    	int width;
    	int height;
    	String name;
	 */
	
	String getName() {return name;}
	String getPlayer() {return player;}
	
	/*
	@Override
	public Piece clone() throws CloneNotSupportedException {
		return (Piece)super.clone();
	}*/
	
	public Piece(String choice, int x, int y) {
		super(x, y);
		destroyed=false;
		king=false;
		ImageIcon icon;
		
		switch(choice) {
				case "red":
					icon = new ImageIcon("src/Checkers/Sprites/red.png");
					image = icon.getImage();
					setImage(image);
					name="red";
					player="red";
					break;
				case "black":
					//castle
					icon = new ImageIcon("src/Checkers/Sprites/black.png");
					image = icon.getImage();
					setImage(image);
					name="black";
					player="black";
					break;
				case "empty":
					icon = new ImageIcon("src/Checkers/Sprites/empty.png");
					image = icon.getImage();
					setImage(image);
					name="empty";
					player="empty";
					break;
				default:
					//error
					icon = new ImageIcon("src/Checkers/Sprites/empty.png");
					image = icon.getImage();
					setImage(image);
					name="empty";
					player="empty";
		}
	}
	
	void kingMe() {
		king=true;
		ImageIcon icon;
		if(player=="red")
			icon = new ImageIcon("src/Checkers/Sprites/redKing.png");
		else
			icon = new ImageIcon("src/Checkers/Sprites/blackKing.png");
		setImage(icon.getImage());
	}
}
