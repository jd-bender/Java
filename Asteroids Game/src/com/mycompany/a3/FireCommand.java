package com.mycompany.a3;

import com.codename1.ui.events.*;
import com.codename1.ui.Command;

public class FireCommand extends Command {
	private static FireCommand fire;
	private static GameWorld gw;
	
	public FireCommand() {
		super("Fire Missile (f)");
	}
	
	public static FireCommand getInstance() {
		if (fire == null) {
			fire = new FireCommand();
		}
		return fire;
	}
	
	public static void setTarget(GameWorld game) {
		if (gw == null) {
			gw = game;
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent evt) {
		gw.fireMissile();
	}
}
