package Level;

import java.awt.Color;
import java.awt.Point;
import java.util.List;

import Application.Entity;

public interface Level {
	public Point getDimensions();
	public List<Entity> getObjectList();
	public Point getPlayerPosition();
	public Color getBackgroundColor();
	public List<Entity> getPathObjects();
}
