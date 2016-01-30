package ca.mkmxwl.zeppelin.menu;

import java.awt.*;

import ca.mkmxwl.zeppelin.*;

public abstract class Menu {

	public abstract void update(Game game, boolean uk, boolean dk, boolean enter);

	public abstract void render(Graphics2D g);
}