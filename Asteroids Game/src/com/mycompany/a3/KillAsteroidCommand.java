package com.mycompany.a3;

import com.codename1.ui.events.*;
import com.codename1.ui.Command;

public class KillAsteroidCommand extends Command {
	private GameWorld gw;
	
	public KillAsteroidCommand(GameWorld gw) {
		super("Kill Asteroid (k)");
		this.gw = gw;
	}
	@Override
	
	public void actionPerformed(ActionEvent evt) {
		gw.killAsteroid();
	}
}
