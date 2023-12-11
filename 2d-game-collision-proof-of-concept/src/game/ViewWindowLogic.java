package game;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public final class ViewWindowLogic {
	public static void updateCollision(World world) {
		List<Character> characters = new ArrayList<Character>();
		characters= world.getCharacters();
		
		Tile tiles[][] =world.getTiles();
		int width=Settings.getWidth()/Settings.getTileSize();
		int height=Settings.getHeight()/Settings.getTileSize();
				
		//Clear Board
		for(int x=0; x<width; x++) {
			for(int y=0; y<height; y++) {
				if(!tiles[x][y].isEmpty())
					tiles[x][y].toggleEmpty();
			}
		}
		
		for(int index=0; index<characters.size(); index++) {
			Point position = new Point(characters.get(index).getPosition());
			for(int x=(int) position.getX()/Settings.getTileSize(); x<(int) (position.getX()+Settings.getCharacterWidth())/Settings.getTileSize(); x++) {
				for(int y=(int) position.getY()/Settings.getTileSize(); y<(int) (position.getY()+Settings.getCharacterHeight())/Settings.getTileSize(); y++) {
					if(tiles[x][y].isEmpty())
						tiles[x][y].toggleEmpty();
				}
			}
		}
		
	}
}
