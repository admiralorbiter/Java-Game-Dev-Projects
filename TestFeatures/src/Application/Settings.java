package Application;
import java.awt.Dimension;
import java.awt.Toolkit;

public class Settings {
	public static Dimension getScreensize() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		if(screenSize!=null)
			return screenSize;
		else
			return new Dimension(1800, 900);
	}
}
