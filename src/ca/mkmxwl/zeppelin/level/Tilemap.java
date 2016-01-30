package ca.mkmxwl.zeppelin.level;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import ca.mkmxwl.zeppelin.gfx.Sprite;

public class Tilemap {
	
	private int width, height;
	
	private int[] pixels;
	private Tile[][] tiles;
	
	public Tilemap(String path) {
		try {
			BufferedImage map = ImageIO.read(Tilemap.class.getResourceAsStream(path));
			width = map.getWidth();
			height = map.getHeight();
			pixels = map.getRGB(0, 0, width, height, null, 0, width);
			map = null;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		load();
	}
	
	private void load() {
		tiles = new Tile[height][width];
		
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				int col = pixels[x + y * width];
				Tile toPlace = null;
				switch(col) {
				case 0xFF823400:
					toPlace = new InterchangeableFloorTile(x, y, Sprite.dirt.getSprite());
					break;
				case 0xFF333333:
					toPlace = new InterchangeableWallTile(x, y, Sprite.stoneWall.getSprite());
					break;
				}
				
				tiles[y][x] = toPlace;
			}
		}
	}
	
	public void update() {
		
	}
	
	public void render(Graphics2D g) {
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				tiles[y][x].render(g);
			}
		}
	}
	
	// Getters 
	
	// Pixel precision coordinates
	public Tile getTile(int x, int y) {
		return tiles[y >> 5][x >> 5];
	}
	
}
