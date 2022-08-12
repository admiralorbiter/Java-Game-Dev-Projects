

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;

public final class Settings {
	public static int size = 20;
	public static int  worldStart = 0;
	public static int sleepTime = 60;
	public static Dimension getScreensize() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		if(screenSize!=null)
			return screenSize;
		else
			return new Dimension(1800, 900);
	}
	
	public static Dimension getWindowSize() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		if(screenSize!=null)
			return new Dimension(screenSize.width-rightWindowWidth, screenSize.height);
		else
			return new Dimension(1800-rightWindowWidth, 900);
	}
	public static int rightWindowWidth = size*5;
}
