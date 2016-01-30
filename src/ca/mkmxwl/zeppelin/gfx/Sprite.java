package ca.mkmxwl.zeppelin.gfx;

import java.awt.image.*;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sprite {

	public static Sprite dirt = new Sprite(0, 0, SpriteSheet.tiles);
	
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