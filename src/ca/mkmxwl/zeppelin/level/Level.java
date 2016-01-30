package ca.mkmxwl.zeppelin.level;

import java.awt.*;
import java.util.*;

import ca.mkmxwl.zeppelin.*;
import ca.mkmxwl.zeppelin.entities.*;

public class Level {

	public Player player;
	public ArrayList<Entity> entities = new ArrayList<Entity>();
	protected Sound background;
	public int spawnX, spawnY, spawnDir;
	public Tilemap map;

	public Level(String file, Sound sound) {
		// load PNG image to 2d array of the level's tiles
		background = sound;
		background.play();
		map = new Tilemap("/levels/room1.bmp");
		spawnX = 32 * 10;
		spawnY = 32 * 5;
	}

	public static void load(Game game, Level level) {
		game.level.background.stop();
		game.level = level;
	}

	public void update() {
		map.update();
		for (Entity e : entities)
			e.update();
	}

	public void render(Graphics2D g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Zepp.WIDTH, Zepp.HEIGHT);
		map.render(g);
		for (Entity e : entities)
			e.render(g);
	}
}