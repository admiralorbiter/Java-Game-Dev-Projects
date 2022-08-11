package Mistborn;

import java.awt.Dimension;
import java.awt.Toolkit;

public final class Settings {
	public static int MOVE=5;
	public static int WIDTH=5;
	public static int HEIGHT=5;
	
	public static Dimension getTileSize() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		return new Dimension(1600, 800);
		/*
		if(screenSize!=null)
			return screenSize;
		
		return new Dimension(1900, 900);
		*/
	}
}
