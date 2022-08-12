package LovecraftCrossing;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;

public final class Settings {
	public static int MOVE=5;
	public static int TILESIZE=25;
	public static int MOVE_TICK_TOTAL=25;
	
	public static Dimension getScreenSize() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		if(screenSize!=null)
			return screenSize;
		return new Dimension(1900, 900);
	}
	
	public static Dimension getTilesOnScreen() {
		Dimension viewSize = getScreenSize();
		
		return new Dimension(viewSize.width/TILESIZE, viewSize.height/TILESIZE);
	}
	
	public static int TREE_HP=100;
	public static int TREE_DROP_RATE=20;
}
