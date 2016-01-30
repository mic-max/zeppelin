package ca.mkmxwl.zeppelin.level;

import java.awt.*;
import java.util.*;

import ca.mkmxwl.zeppelin.*;
import ca.mkmxwl.zeppelin.entities.*;

public class Level {

	public Player player;
	public ArrayList<Entity> entities = new ArrayList<Entity>();
	protected Sound background; // background music

	public Level(String string) {
		// load PNG image to 2d array of the level's tiles
	}

	public void update() {
		for (Entity e : entities)
			e.update();
	}

	public void render(Graphics2D g) {
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, Zepp.WIDTH, Zepp.HEIGHT);
		for (Entity e : entities)
			e.render(g);
	}
}