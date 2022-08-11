package Mistborn;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class World {

	private Player player;
	private Tile[][] grid = new Tile[Settings.WIDTH][Settings.HEIGHT];
	private Point tileIndex = new Point(2, 2);
	private Dimension tileSize=Settings.getTileSize();
	private List<Platformer> testPlatform = new ArrayList<Platformer>();
	private int platformIndex;
	
	private Metal metalTest;
	
	public World() {
		for(int i=0; i<Settings.WIDTH; i++)
			testPlatform.add(new Platformer(new Point(0, 400), Settings.getTileSize(), new Point(i, 4)));
		player = new Player(new Point(500, 500), new Dimension(50, 50));
		metalTest = new Metal(new Point(600, 50), new Dimension(50, 50), new Point(2, 4));
		Random r = new Random();
		
		for(int x=0; x<Settings.WIDTH; x++)
			for(int y=0; y<Settings.HEIGHT; y++)
				grid[x][y] = new Tile(new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256)));
		
		
	}
	
	public void draw(Graphics g) {
		
		g.setColor(grid[tileIndex.x][tileIndex.y].getColor());
		g.fillRect(0, 0, tileSize.width, tileSize.height);
		g.setColor(Color.white);
		g.drawString(tileIndex.x+","+tileIndex.y, 10, 50);
		
		for(int i=0; i<Settings.WIDTH; i++)
			if(tileIndex.equals(testPlatform.get(i).getTileIndex())) {
				testPlatform.get(i).draw(g);
				platformIndex=i;
			}
		
		
		player.draw(g);
		g.setColor(Color.DARK_GRAY);
		metalTest.draw(g);
	}
	
	public void update(boolean[] keys) {
		player.update(keys, tileIndex, testPlatform.get(platformIndex));
		if(metalTest.getTileIndex().equals(tileIndex))
			metalTest.update(tileIndex, testPlatform.get(platformIndex));
		
		if(player.getPosition().x-Settings.MOVE<=0 && tileIndex.x-1>=0) {
			tileIndex.translate(-1, 0);
			player.getPosition().translate(tileSize.width-player.getDimension().width-Settings.WIDTH, 0);
		}
		
		if(player.getPosition().y-Settings.MOVE<=0 && tileIndex.y-1>=0) {
			tileIndex.translate(0, -1);
			player.getPosition().translate(0, tileSize.height-player.getDimension().height-Settings.HEIGHT);
		}
		if(player.getPosition().x>=(Settings.getTileSize().width-player.getDimension().width-Settings.MOVE) && tileIndex.x+1<Settings.WIDTH) {
			tileIndex.translate(1, 0);
			player.setPosition(new Point(1, player.getPosition().y));
		}
		
		if(player.getPosition().y>=(Settings.getTileSize().height-player.getDimension().height) && tileIndex.y<(Settings.HEIGHT)) {
			tileIndex.translate(0, 1);
			player.setPosition(new Point(player.getPosition().x, Settings.HEIGHT));
		}
	}
}
