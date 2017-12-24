package com.mycompany.a3;

import com.codename1.ui.events.*;
import com.codename1.ui.Command;

public class AddAsteroidCommand extends Command {
	private static AddAsteroidCommand addAsteroid;
	private static GameWorld gw;
	
	public AddAsteroidCommand() {
		super("Add Asteroid (a)");
	}
	
	public static AddAsteroidCommand getInstance() {
		if (addAsteroid == null) {
			addAsteroid = new AddAsteroidCommand();
		}
		return addAsteroid;
	}
	
	public static void setTarget(GameWorld game) {
		if (gw == null) {
			gw = game;
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent evt) {
		gw.newAsteroid();
	}
}
