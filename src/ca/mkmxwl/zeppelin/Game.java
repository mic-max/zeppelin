package ca.mkmxwl.zeppelin;

import java.awt.*;
import java.awt.event.*;

import ca.mkmxwl.zeppelin.entities.*;
import ca.mkmxwl.zeppelin.level.*;
import ca.mkmxwl.zeppelin.menu.*;
import ca.mkmxwl.zeppelin.menu.Menu;

public class Game {

	public Menu menu;
	public Level level;
	public Player player;

	public Game() {
		setMenu(new MainMenu());
	}

	public void newGame() {
		level = new Level("map1", Sound.hongkong);
		player = new Player(level);
	}

	public void update(boolean[] keys) {

		boolean uk = keys[KeyEvent.VK_UP];
		boolean dk = keys[KeyEvent.VK_DOWN];
		boolean lk = keys[KeyEvent.VK_LEFT];
		boolean rk = keys[KeyEvent.VK_RIGHT];

		boolean w = keys[KeyEvent.VK_W];
		boolean s = keys[KeyEvent.VK_S];
		boolean a = keys[KeyEvent.VK_A];
		boolean d = keys[KeyEvent.VK_D];

		boolean shoot = keys[KeyEvent.VK_SPACE];

		boolean enter = keys[KeyEvent.VK_ENTER];

		if (keys[KeyEvent.VK_ESCAPE]) {
			if (menu == null)
				setMenu(new PauseMenu());
		}

		if (menu != null)
			menu.update(this, uk, dk, enter);
		else {
			player.update(uk, dk, lk, rk, w, s, a, d, shoot);
			level.update();
		}
	}

	public void render(Graphics2D g) {
		if (menu != null)
			menu.render(g);
		else
			level.render(g);
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}
}