package ca.mkmxwl.zeppelin.gfx;

import java.awt.Color;
import java.awt.Graphics2D;

import ca.mkmxwl.zeppelin.Zepp;
import ca.mkmxwl.zeppelin.gfx.Particle.Type;
import ca.mkmxwl.zeppelin.level.Level;

public class Projectile {

	public boolean shouldRemove;
	public float speed = 3.1f;
	public float x, y;
	private int width = 8;
	private int height = 8;
	
	private float xSpeed, ySpeed;
	private double angle;
	private Color color;
	private int lifetime;
	private Level level;
	
	public Projectile(float x, float y, float xDest, float yDest, int lifetime, Color color, Level level) {
		this.x = x; this.y = y;
		this.color = color;
		this.lifetime = lifetime;
		this.level = level;
		angle = Math.atan2(yDest - y, xDest - x);
		xSpeed = (float)Math.cos(angle) * speed;
		ySpeed = (float)Math.sin(angle) * speed;
	}
	
	public Projectile(float x, float y, int lifetime, float xSpeed, float ySpeed, Color color, Level level) {
		this.x = x; this.y = y;
		this.color = color;
		this.lifetime = lifetime;
		this.xSpeed = xSpeed;
		this.ySpeed = ySpeed;
		this.level = level;
	}
	
	public void update() {
		lifetime--;
		if(lifetime <= 0)
			shouldRemove = true;
		
		x += xSpeed;
		y += ySpeed;
		
		checkCol();
	}
	
	public void render(Graphics2D g) {
		// Bounds check
		if(x < 0 || x > Zepp.WIDTH || y < 0 || y > Zepp.HEIGHT) {
			shouldRemove = true;
			return;
		}
		
		g.setColor(color);
		g.fillOval((int)x, (int)y, width, height);
	}
	
	private void checkCol() {
		if(level.map.getTile((int)x, (int)y).getProjectileSolid()) {
			shouldRemove = true;
		}
		if(level.map.getTile((int)x + width, (int)y).getProjectileSolid()) {
			shouldRemove = true;
		}
		if(level.map.getTile((int)x + width, (int)y + height).getProjectileSolid()) {
			shouldRemove = true;
		}
		if(level.map.getTile((int)x, (int)y + height).getProjectileSolid()) {
			shouldRemove = true;
		}
		
		// If shouldRemove is true, explode!
		if(shouldRemove) {
			for(int i = 0; i < 25; i++)
				level.particles.add(new Particle(x + width / 2, y + height / 2, 25, 0.3f, color, Type.RANDOM));
		}
	}
	
}
