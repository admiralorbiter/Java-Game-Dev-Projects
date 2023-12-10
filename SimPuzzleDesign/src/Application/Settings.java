package Application;

import java.awt.Dimension;
import java.awt.Toolkit;

public final class Settings {

	public static Dimension getScreensize() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		if(screenSize!=null)
			return screenSize;
		else
			return new Dimension(1800, 900);
	}
	
	public static int delayBetweenScreenRefresh=60;
	public static int size=20;
	
	//Debugging Settings
	public static boolean skipIntro=true;
	public static SelectWorld worldStart=SelectWorld.ONE;
}
