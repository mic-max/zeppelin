package ca.mkmxwl.zeppelin.menu;

import java.awt.*;

import ca.mkmxwl.zeppelin.*;

public class PauseMenu extends Menu {

	private String[] options = { "Play", "Exit" };
	private byte selected = 0;

	public void update(Game game, boolean uk, boolean dk, boolean enter) {
		super.update(game, uk, dk, enter);

		if (enter) {
			Zepp.sleep(150);
			Sound.beep.play();
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
		g.fillRect(10, 10, 60, 100);
		super.render(g);
	}
}