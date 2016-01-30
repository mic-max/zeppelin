package ca.mkmxwl.zeppelin.menu;

import java.awt.*;

import ca.mkmxwl.zeppelin.*;
import ca.mkmxwl.zeppelin.gfx.*;

public class MainMenu extends Menu {

	public MainMenu() {
		Sound.lavender.play();
	}

	private String[] options = { "Play", "Exit" };
	private byte selected = 0;

	public void update(Game game, boolean uk, boolean dk, boolean enter) {
		if (uk && selected > 0) {
			Zepp.sleep(150);
			Sound.beep.play();
			selected--;
		}
		if (dk && selected < options.length - 1) {
			Zepp.sleep(150);
			Sound.beep.play();
			selected++;
		}

		if (enter) {
			switch (selected) {
			case 0:
				game.setMenu(null);
				game.newGame();
				break;
			default:
				System.exit(0);
			}
		}
	}

	public void render(Graphics2D g) {
		g.drawImage(SpriteSheet.mainMenu.getSheet(), 0, 0, Zepp.WIDTH, Zepp.HEIGHT, null);
		for (int i = 0; i < options.length; i++) {
			g.setColor(Color.WHITE);
			if (selected == i)
				g.setColor(Color.GREEN);
			g.drawString(options[i], 40, 60 + i * 40);
		}
	}
}