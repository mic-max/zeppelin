package ca.mkmxwl.zeppelin.level;

import java.awt.*;
import java.util.*;

import ca.mkmxwl.zeppelin.entities.*;

public class Level {

	public Player player;
	public ArrayList<Entity> entities = new ArrayList<Entity>();

	public Level(String string) {
		// load PNG image to 2d array of the level's tiles
	}

	public void update() {
		for (Entity e : entities)
			e.update();
	}

	public void render(Graphics2D g) {
		// render level, i.e. wall, other static shit
		for (Entity e : entities)
			e.render(g);
	}
}