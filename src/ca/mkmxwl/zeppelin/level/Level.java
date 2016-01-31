package ca.mkmxwl.zeppelin.level;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

import ca.mkmxwl.zeppelin.Game;
import ca.mkmxwl.zeppelin.Sound;
import ca.mkmxwl.zeppelin.Zepp;
import ca.mkmxwl.zeppelin.entities.Entity;
import ca.mkmxwl.zeppelin.entities.Player;
import ca.mkmxwl.zeppelin.gfx.Particle;
import ca.mkmxwl.zeppelin.gfx.Projectile;

public class Level {

	public Player player;
	public ArrayList<Entity> entities = new ArrayList<Entity>();
	public ArrayList<Particle> particles = new ArrayList<Particle>();
	public ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
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
		for (Particle p: particles)
			p.update();
		for (Projectile p: projectiles)
			p.update();
		checkLists();
	}

	public void render(Graphics2D g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Zepp.WIDTH, Zepp.HEIGHT);
		map.render(g);
		for (Particle p: particles)
			p.render(g);
		for (Projectile p: projectiles)
			p.render(g);
		for (Entity e : entities)
			e.render(g);
	}
	
	private void checkLists() {
		for(int i = 0; i < particles.size(); i++) {
			Particle p = particles.get(i);
			if(p.shouldRemove) 
				particles.remove(p);
		}
		for(int i = 0; i < projectiles.size(); i++) {
			Projectile p = projectiles.get(i);
			if(p.shouldRemove)
				projectiles.remove(p);
		}
	}
}