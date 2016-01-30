package ca.mkmxwl.zeppelin.menu;

import java.awt.*;

import ca.mkmxwl.zeppelin.*;

public class Menu {

	protected String[] options;
	protected byte selected = 0;

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