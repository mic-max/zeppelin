package ca.mkmxwl.zeppelin;

import javax.sound.sampled.*;

public class Sound {

	private Clip clip;
	private boolean loop;

	public static Sound beep = new Sound("beep", false);
	public static Sound lavender = new Sound("lavender", true);
	public static Sound hongkong = new Sound("hongkong", true);

	private Sound(String file, boolean loop) {
		this.loop = loop;
		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(Sound.class.getResourceAsStream("/snd/" + file + ".wav"));
			clip = AudioSystem.getClip();
			clip.open(ais);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void play() {
		try {
			new Thread() {
				public void run() {
					synchronized (clip) {
						clip.stop();
						clip.setFramePosition(0);
						if (loop)
							clip.loop(Clip.LOOP_CONTINUOUSLY);
						else
							clip.start();
					}
				}
			}.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void stop() {
		clip.stop();
	}
}