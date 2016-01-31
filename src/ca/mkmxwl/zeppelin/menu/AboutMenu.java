package ca.mkmxwl.zeppelin.menu;

import java.awt.*;

import ca.mkmxwl.zeppelin.*;
import ca.mkmxwl.zeppelin.gfx.*;

public class AboutMenu extends Menu {
	public AboutMenu() {
		this.options = new String[] { "Exit" };
		this.background = null;
	}

	public void update(Game game, boolean uk, boolean dk, boolean enter) {
		super.update(game, uk, dk, enter);

		if (enter) {
			switch (selected) {
			default:
				game.setMenu(new MainMenu());
			}
		}
	}

	public void render(Graphics2D g) {
		g.drawImage(SpriteSheet.mainMenu.getSheet(), 0, 0, Zepp.WIDTH, Zepp.HEIGHT, null);
		super.render(g);
		g.setColor(Color.CYAN);
		g.drawString("Michael Maxwell", 300, 40);
		g.drawString("Brady Jessup", 300, 70);
	}
}