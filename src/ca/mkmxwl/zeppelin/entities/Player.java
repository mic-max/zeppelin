package ca.mkmxwl.zeppelin.entities;

import java.awt.*;

import ca.mkmxwl.zeppelin.level.*;

public class Player extends Entity {

	public Player(Level level) {
		this.x = 0; // add level spawn locations
		this.y = 0;
		this.dir = 0;
		level.entities.add(this);
	}

	public void update(boolean uk, boolean dk, boolean lk, boolean rk) {
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
	}

	public void render(Graphics2D g) {
		g.setColor(Color.RED);
		g.fillOval(x, y, 10, 10);
	}
}