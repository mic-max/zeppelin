package ca.mkmxwl.zeppelin.gfx;

import java.awt.image.*;
import java.io.*;

import javax.imageio.*;

public class Sprite {

	public static Sprite dirt = new Sprite(0, 0, SpriteSheet.tiles);
	public static Sprite stoneWall = new Sprite(1, 0, SpriteSheet.tiles);

	public static Sprite[] nawiboDown = { new Sprite(0, 0, SpriteSheet.nawibo), new Sprite(1, 0, SpriteSheet.nawibo), new Sprite(2, 0, SpriteSheet.nawibo) };
	public static Sprite[] nawiboUp = { new Sprite(0, 1, SpriteSheet.nawibo), new Sprite(1, 1, SpriteSheet.nawibo), new Sprite(2, 1, SpriteSheet.nawibo) };

	private BufferedImage sprite;
	private int width, height;

	public Sprite(int x, int y, SpriteSheet sheet) {
		sprite = sheet.getSheet().getSubimage(x * sheet.getSpriteWidth(), y * sheet.getSpriteHeight(), sheet.getSpriteWidth(), sheet.getSpriteHeight());
		width = sprite.getWidth();
		height = sprite.getHeight();
	}

	public Sprite(String path) {
		try {
			sprite = ImageIO.read(Sprite.class.getResourceAsStream(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public BufferedImage getSprite() {
		return sprite;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
}