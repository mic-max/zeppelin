package ca.mkmxwl.zeppelin.menu;

import java.awt.*;

import ca.mkmxwl.zeppelin.*;

public class PauseMenu extends Menu {

	public PauseMenu() {
		this.options = new String[] { "Resume", "Exit" };
		this.background = Sound.hongkong;
		background.play();
	}

	public void update(Game game, boolean uk, boolean dk, boolean enter) {
		super.update(game, uk, dk, enter);

		if (enter) {
			switch (selected) {
			case 0:
				game.setMenu(null);
				break;
			default:
				game.setMenu(new MainMenu());
			}
		}
	}

	public void render(Graphics2D g) {
		g.setColor(Color.BLACK);
		g.fillRect(10, 10, 90, 90);
		super.render(g);
	}
}