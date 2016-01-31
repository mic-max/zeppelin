package ca.mkmxwl.zeppelin.gfx;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

public class Particle {

	public boolean shouldRemove;
	public float x, y;
	
	private float speed = 2;
	private float xSpeed, ySpeed;
	
	private Color color;
	private int lifetime;
	
	public Particle(float x, float y, int lifetime, Color color) {
		this.lifetime = lifetime;
		this.x = x;
		this.y = y;
		this.color = color;
		
		xSpeed = (float)new Random().nextGaussian() * speed;
		ySpeed = (float)new Random().nextGaussian() * speed;
	}
	
	public void update() {
		lifetime--;
		if(lifetime <= 0)
			shouldRemove = true;
		
		x += xSpeed;
		y += ySpeed;
	}
	
	public void render(Graphics2D g) {
		g.setColor(color);
		g.fillRect((int)x, (int)y, 5, 5);
	}
	
}
