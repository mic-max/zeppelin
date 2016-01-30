package ca.mkmxwl.zeppelin.menu;

import java.awt.*;

import ca.mkmxwl.zeppelin.*;

public class Menu {

	protected String[] options;
	protected byte selected = 0;
	protected Sound background; // background music

	public void update(Game game, boolean uk, boolean dk, boolean enter) {
		if (uk && selected > 0 || dk && selected < options.length - 1 || enter) {
			Zepp.sleep(150);
			Sound.beep.play();
		}

		if (uk && selected > 0)
			selected--;
		else if (dk && selected < options.length - 1)
			selected++;
		else if (enter)
			background.stop();
	}

	public void render(Graphics2D g) {
		g.setFont(new Font("Courier New", Font.PLAIN, 12));
		for (int i = 0; i < options.length; i++) {
			g.setColor(Color.WHITE);
			if (selected == i)
				g.setColor(Color.GREEN);
			g.drawString(options[i], 30, 40 + i * 40);
		}
	}
}