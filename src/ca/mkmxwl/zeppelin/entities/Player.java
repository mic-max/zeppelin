package ca.mkmxwl.zeppelin.entities;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import ca.mkmxwl.zeppelin.gfx.Particle;
import ca.mkmxwl.zeppelin.gfx.Particle.Type;
import ca.mkmxwl.zeppelin.gfx.Projectile;
import ca.mkmxwl.zeppelin.gfx.Sprite;
import ca.mkmxwl.zeppelin.level.Level;

public class Player extends Entity {

	private Level level;

	private int speed = 2;
	private int width = 12;
	private int height = 10;
	private int removeYHeight = 10;

	// Moving particle stats
	private int particleAmount = 4;
	private Color pColor = Color.RED;
	private int pLife = 10;
	private float pSpeed = 1f;
	// Projectile stats
	final int P_COOLDOWN = 30;
	private int currentPCooldown = P_COOLDOWN;
	private float projectileSpeed = 3.1f;
	private int projectileLife = 200;
	private Color projectileCol = Color.RED;

	public Rectangle hitbox;
	private byte sprite;

	public Player(Level level) {
		this.sprite = 0;
		this.level = level;
		this.x = level.spawnX;
		this.y = level.spawnY;
		this.dir = level.spawnDir;
		this.level.entities.add(this);
		hitbox = new Rectangle(x, y, width, height);
	}

	public void update(boolean uk, boolean dk, boolean lk, boolean rk, boolean w, boolean s, boolean a, boolean d) {
		move(uk, dk, rk, lk);
		shoot(w, s, a, d);
	}

	private void shoot(boolean w, boolean s, boolean a, boolean d) {
		currentPCooldown--;
		if (currentPCooldown <= 0) {
			// Make sure int doesn't get too negative
			if (currentPCooldown <= -100000)
				currentPCooldown = 0;

			// Check to see if the player is shooting
			checkShoot(w, s, a, d);
		}

	}

	private void checkShoot(boolean w, boolean s, boolean a, boolean d) {
		if (w || s || a || d) {
			currentPCooldown = P_COOLDOWN;

			if (w)
				level.projectiles.add(new Projectile(x + width / 2, y + height / 2, projectileLife, 0f, -projectileSpeed, projectileCol, level));
			else if (s)
				level.projectiles.add(new Projectile(x + width / 2, y + height / 2, projectileLife, 0f, projectileSpeed, projectileCol, level));
			else if (d)
				level.projectiles.add(new Projectile(x + width / 2, y + height / 2, projectileLife, projectileSpeed, 0f, projectileCol, level));
			else if (a)
				level.projectiles.add(new Projectile(x + width / 2, y + height / 2, projectileLife, -projectileSpeed, 0f, projectileCol, level));
		}
	}

	public void render(Graphics2D g) {
		g.drawImage(Sprite.nawiboDown[sprite].getSprite(), x, y, null);
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

		sprite++;
		sprite %= 3;

		moveX(xChange);
		moveY(yChange);
	}

	private void moveX(int xChange) {
		if (level.map.getTile(x + xChange, y + removeYHeight).getWalkSolid())
			return;
		if (level.map.getTile(x + width + xChange, y + removeYHeight).getWalkSolid())
			return;
		if (level.map.getTile(x + xChange, y + height + removeYHeight).getWalkSolid())
			return;
		if (level.map.getTile(x + width + xChange, y + height + removeYHeight).getWalkSolid())
			return;

		if (xChange != 0) {
			for (int i = 0; i < particleAmount; i++) {
				level.particles.add(new Particle(x + (width / 2), y + height + 10, pLife, pSpeed, pColor, Type.PLAYER));
			}
		}

		x += xChange;
		hitbox.x = x;
	}

	private void moveY(int yChange) {
		if (level.map.getTile(x, y + yChange + removeYHeight).getWalkSolid())
			return;
		if (level.map.getTile(x + width, y + yChange + removeYHeight).getWalkSolid())
			return;
		if (level.map.getTile(x, y + height + yChange + removeYHeight).getWalkSolid())
			return;
		if (level.map.getTile(x + width, y + height + yChange + removeYHeight).getWalkSolid())
			return;

		if (yChange != 0) {
			for (int i = 0; i < particleAmount; i++) {
				level.particles.add(new Particle(x + (width / 2), y + height + 10, pLife, pSpeed, pColor, Type.PLAYER));
			}
		}

		y += yChange;
		hitbox.y = y;
	}
}