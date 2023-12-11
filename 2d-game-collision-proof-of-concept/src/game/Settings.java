package game;

public final class Settings {
	static int width=800;
	static int height=800;
	static int pixels_to_move=10;
	static int characterWidth=50;
	static int characterHeight=50;
	static int bottomMenuHeight=200;
	static int tileSize=5;
	static long healthDecreaseRate = 10000L;
	public static int getCharacterWidth() {return characterWidth;}
	public static int getCharacterHeight() {return characterHeight;}
	public static int getWidth() {return width;}
	public static int getHeight() {return height;}
	public static int getMove() {return pixels_to_move;}
	public static int getBottomMenuHeight() {return bottomMenuHeight;}
	public static int getTileSize() {return tileSize;}
	public static long getHealthDecreaseRate() {return healthDecreaseRate;}
}
