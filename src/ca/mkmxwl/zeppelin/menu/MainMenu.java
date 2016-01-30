package ca.mkmxwl.zeppelin.menu;

import java.awt.*;

import ca.mkmxwl.zeppelin.*;
import ca.mkmxwl.zeppelin.gfx.*;

public class MainMenu extends Menu {

	public MainMenu() {
		Sound.lavender.play();
		this.options = new String[] { "Play", "About", "Exit" };
	}

	public void update(Game game, boolean uk, boolean dk, boolean enter) {
		super.update(game, uk, dk, enter);

		if (enter) {
			switch (selected) {
			case 0:
				game.setMenu(null);
				game.newGame();
				break;
			case 1:
				// game.setMenu(new AboutMenu());
				break;
			default:
				System.exit(0);
			}
		}
	}

	public void render(Graphics2D g) {
		g.drawImage(SpriteSheet.mainMenu.getSheet(), 0, 0, Zepp.WIDTH, Zepp.HEIGHT, null);
		super.render(g);
	}
}