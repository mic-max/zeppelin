package ca.mkmxwl.zeppelin.entities;

import java.awt.*;

import ca.mkmxwl.zeppelin.level.*;

public class Player extends Entity {

	public Player(Level level) {
		this.x = level.spawnX;
		this.y = level.spawnY;
		this.dir = level.spawnDir;
		level.entities.add(this);
	}

	public void update(boolean uk, boolean dk, boolean lk, boolean rk, boolean w, boolean s, boolean a, boolean d, boolean shoot) {
		// up to go forward through door
		// left & right to move
		// down to crouch / hide
		// need an interact key
		if (uk) {
			y--;
		} else if (dk) {
			y++;
		}
		if (rk) {
			x++;
		} else if (lk) {
			x--;
		}

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

		if (shoot) {
			System.out.println("shoot");
		}
	}

	public void render(Graphics2D g) {
		g.setColor(Color.RED);
		g.fillOval(x, y, 10, 10);
	}
}