package ca.mkmxwl.zeppelin.entities;

import java.awt.*;

import ca.mkmxwl.zeppelin.gfx.*;
import ca.mkmxwl.zeppelin.level.*;

public class Player extends Entity {

	private Level level;

	private int speed = 2;
	private int width = 13;
	private int height = 22;
	public Rectangle hitbox;
	private Sprite sprite;

	public Player(Level level) {
		this.sprite = Sprite.nawiboDown[0];
		this.level = level;
		this.x = level.spawnX;
		this.y = level.spawnY;
		this.dir = level.spawnDir;
		this.level.entities.add(this);
		hitbox = new Rectangle(x, y, width, height);
	}

	public void update(boolean uk, boolean dk, boolean lk, boolean rk, boolean w, boolean s, boolean a, boolean d) {
		move(uk, dk, rk, lk);

		if (w) {
			System.out.println("w");
		} else if (s) {
			System.out.println("s");
		}
		if (a) {
			System.out.println("a");
		} else if (d) {
			System.out.println("d");
		}
	}

	public void render(Graphics2D g) {
		g.drawImage(sprite.getSprite(), x, y, null);
	}

	private void move(boolean uk, boolean dk, boolean rk, boolean lk) {
		int xChange = 0;
		int yChange = 0;

		if (uk)
			yChange -= speed;
		else if (dk)
			yChange += speed;
		if (rk)
			xChange += speed;
		else if (lk)
			xChange -= speed;

		moveX(xChange);
		moveY(yChange);
	}

	private void moveX(int xChange) {
		if (level.map.getTile(x + xChange, y).getWalkSolid())
			return;
		if (level.map.getTile(x + width + xChange, y).getWalkSolid())
			return;
		if (level.map.getTile(x + xChange, y + height).getWalkSolid())
			return;
		if (level.map.getTile(x + width + xChange, y + height).getWalkSolid())
			return;

		x += xChange;
		hitbox.x = x;
	}

	private void moveY(int yChange) {
		if (level.map.getTile(x, y + yChange).getWalkSolid())
			return;
		if (level.map.getTile(x + width, y + yChange).getWalkSolid())
			return;
		if (level.map.getTile(x, y + height + yChange).getWalkSolid())
			return;
		if (level.map.getTile(x + width, y + height + yChange).getWalkSolid())
			return;

		y += yChange;
		hitbox.y = y;
	}
}