package ca.mkmxwl.zeppelin.gfx;

import java.awt.image.*;

public class Sprite {

	private BufferedImage sprite;
	private int width, height;

	public Sprite(int x, int y, SpriteSheet sheet) {
		sprite = sheet.getSheet().getSubimage(x * sheet.getSpriteWidth(), y * sheet.getSpriteHeight(), sheet.getSpriteWidth(), sheet.getSpriteHeight());
		width = sprite.getWidth();
		height = sprite.getHeight();
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