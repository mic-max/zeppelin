package ca.mkmxwl.zeppelin;

import java.awt.*;
import java.awt.image.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class Zepp extends Canvas implements Runnable {

	public static final int WIDTH = 480;
	public static final int HEIGHT = 320;
	public static boolean running;

	private Thread thread;
	private JFrame frame;
	private Input input;
	private Game game;

	private Graphics2D gScreen;
	private BufferedImage image;

	public Zepp() {
		setSize(WIDTH * 2, HEIGHT * 2);

		frame = new JFrame("Zeppelin");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.add(this, BorderLayout.CENTER);
		frame.setResizable(false);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		requestFocus();

		image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		gScreen = (Graphics2D) image.getGraphics();

		game = new Game();
		input = new Input(this);
	}

	public synchronized void start() {
		if (!running) {
			running = true;
			thread = new Thread(this);
			thread.start();
		}
	}

	public synchronized void stop() {
		if (running) {
			running = false;
			try {
				thread.join();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void run() {
		final double NS_PER_UPDATE = 1000000000D / 60D;
		long last = System.nanoTime();
		double delta = 0;
		while (running) {
			long now = System.nanoTime();
			delta += (now - last) / NS_PER_UPDATE;
			last = now;
			while (delta >= 1) {
				update();
				delta--;
			}
			render();
			sleep(2);
		}
	}

	private void update() {
		game.update(input.keys);
	}

	private void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(2);
			return;
		}
		Graphics2D g = (Graphics2D) bs.getDrawGraphics();
		game.render(gScreen);
		g.drawImage(image, 0, 0, WIDTH * 2, HEIGHT * 2, null);

		g.dispose();
		bs.show();
	}

	public static void sleep(int n) {
		try {
			Thread.sleep(n);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new Zepp().start();
	}
}