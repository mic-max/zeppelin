package ca.mkmxwl.zeppelin.level;

import java.awt.Graphics2D;

public abstract class Tile {

	public static int TILE_SIZE = 32;
	
	protected int x, y;
	protected boolean walkSolid;
	protected boolean projectileSolid;
	
	public Tile(int x, int y) {
		this.x = x;
		this.y = y;
		
		init();
	}
	
	public abstract void init();
	
	public abstract void update();
	public abstract void render(Graphics2D g);
	
	// Getters
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public boolean getWalkSolid() {
		return walkSolid;
	}
	public boolean getProjectileSolid() {
		return projectileSolid;
	}
	
}
