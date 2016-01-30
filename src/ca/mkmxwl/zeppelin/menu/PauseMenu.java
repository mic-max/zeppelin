package ca.mkmxwl.zeppelin.menu;

import java.awt.*;

import ca.mkmxwl.zeppelin.*;

public class PauseMenu extends Menu {

	public PauseMenu() {
		this.options = new String[] { "Resume", "About", "Exit" };
		this.background = null;
	}

	public void update(Game game, boolean uk, boolean dk, boolean enter) {
		super.update(game, uk, dk, enter);

		if (enter) {
			switch (selected) {
			case 0:
				game.setMenu(null);
				break;
			case 1:
				// game.setMenu(new AboutMenu());
				break;
			default:
				game.setMenu(new MainMenu());
			}
		}
	}

	public void render(Graphics2D g) {
		g.setColor(new Color(20, 24, 22));
		g.fillRect(20, 20, 64, options.length * 40 - 8);
		super.render(g);
	}
}