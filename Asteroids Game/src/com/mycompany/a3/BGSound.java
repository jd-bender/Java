package com.mycompany.a3;

import java.io.InputStream;
import java.io.IOException;
import com.codename1.media.*;
import com.codename1.ui.Display;

public class BGSound  implements Runnable{
	private Media m;
	private static Sound gameSound;
	private static Sound asteroidCollision;
	private static Sound shipCollision;
	private static Sound fireMissile;
	private static Sound missileCollision;
	private static Sound backGround;
	private static Sound gameOver;
	
	public BGSound() {
		
	}
	
	public BGSound (String fileName) {
		try {
			InputStream is = Display.getInstance().getResourceAsStream(getClass(), "/" + fileName);
			m = MediaManager.createMedia(is, "audio/wav", this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Sound getInstance() {
		if (gameSound == null) {
			gameSound = new Sound();
		}
		return gameSound;
	}
	
	public void play() {
		m.setTime(0);
		m.play();
	}
	
	public void pause() {
		m.setTime(0);
		m.pause();
	}
	
	public void run() {
		m.setTime(0);
		m.play();
	}
}
