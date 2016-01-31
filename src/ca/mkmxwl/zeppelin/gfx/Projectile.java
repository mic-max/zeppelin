package ca.mkmxwl.zeppelin.gfx;

import java.awt.Color;
import java.awt.Graphics2D;

public class Projectile {

	public float speed = 3.1f;
	public float x, y;
	
	private float xSpeed, ySpeed;
	private double angle;
	private Color color;
	private int lifetime;
	
	public Projectile(float x, float y, float xDest, float yDest, int lifetime, Color color) {
		this.x = x; this.y = y;
		this.color = color;
		this.lifetime = lifetime;
		angle = Math.atan2(yDest - y, xDest - x);
		xSpeed = (float)Math.cos(angle) * speed;
		ySpeed = (float)Math.sin(angle) * speed;
	}
	
	public void update() {
		x += xSpeed;
		y += ySpeed;
	}
	
	public void render(Graphics2D g) {
		g.setColor(color);
		g.fillRect((int)x, (int)y, 5, 5);
	}
	
}
