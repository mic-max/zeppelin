package ca.mkmxwl.zeppelin.gfx;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

public class Particle {

	public enum Type {
		RANDOM, PLAYER;
	}
	
	public boolean shouldRemove;
	public float x, y;
	
	private float speed;
	private float xSpeed, ySpeed;
	
	private Color color;
	private int lifetime;
	private Type type;
	
	public Particle(float x, float y, int lifetime, float speed, Color color, Type type) {
		this.lifetime = lifetime;
		this.speed = speed;
		this.type = type;
		this.x = x;
		this.y = y;
		this.color = color;
		
		if(type == Type.RANDOM) {
			xSpeed = (float)new Random().nextGaussian() * speed;
			ySpeed = (float)new Random().nextGaussian() * speed;
		}
		else if(type == Type.PLAYER) {
			xSpeed = (float)(Math.random() * 4 - 2) * speed;
			ySpeed = (float)-Math.random() * speed;
		}
	}
	
	public void update() {
		if(type == Type.PLAYER) {
			color = new Color((int)(Math.random() * 255), (int)(Math.random() * 255), (int)(Math.random() * 255));
		}
		
		lifetime--;
		if(lifetime <= 0)
			shouldRemove = true;
		
		x += xSpeed;
		y += ySpeed;
	}
	
	public void render(Graphics2D g) {
		g.setColor(color);
		g.fillRect((int)x, (int)y, 1, 1);
	}
	
}
