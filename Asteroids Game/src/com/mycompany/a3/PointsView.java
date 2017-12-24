package com.mycompany.a3;

import java.util.Observable;
import java.util.Observer;

import com.codename1.ui.*;
import com.codename1.charts.util.ColorUtil;

public class PointsView extends Container implements Observer {

	private Label numberAsteroid = new Label("Asteroid:   XXX");
	private Label sound = new Label("Sound:   XXX");
	private Label score = new Label("Score:   XXX");
	private Label gameTime = new Label("Gametime:   XXX");
	private Label lives = new Label("Lives:   XXX");
	private Label missiles = new Label("Missiles:   XXX");
	
	public PointsView() {		
		score.getAllStyles().setFgColor(ColorUtil.rgb(0,0,255));
		lives.getAllStyles().setFgColor(ColorUtil.rgb(0,0,255));
		gameTime.getAllStyles().setFgColor(ColorUtil.rgb(0,0,255));
		numberAsteroid.getAllStyles().setFgColor(ColorUtil.rgb(0,0,255));
		sound.getAllStyles().setFgColor(ColorUtil.rgb(0,0,255));
		missiles.getAllStyles().setFgColor(ColorUtil.rgb(0,0,255));
		
		this.add(score);
		this.add(lives);
		this.add(missiles);
		this.add(gameTime);
		this.add(numberAsteroid);
		this.add(sound);
	}
	
	public void update(Observable observable, Object data) {
		GameWorld gw = (GameWorld) observable;
		score.setText("Score:   " + Integer.toString(gw.getScoreCount()));
		lives.setText("Lives:   " + Integer.toString(gw.getLivesCount()));
		missiles.setText("Missiles:   " + Integer.toString(gw.getMissileCount()));
		gameTime.setText("Gametime:   " + Integer.toString(gw.getGameTime()));
		numberAsteroid.setText("Asteroids:   " + Integer.toString(gw.getAsteroidCount()));
		if (gw.getSound() == true) {
			sound.setText("Sound:   ON");
		} else {
			sound.setText("Sound:   OFF");
		}

	}

}
