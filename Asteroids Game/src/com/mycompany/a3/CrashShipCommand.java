package com.mycompany.a3;

import com.codename1.ui.events.*;
import com.codename1.ui.Command;

public class CrashShipCommand extends Command {
	private static CrashShipCommand crash;
	private static GameWorld gw;
	
	public CrashShipCommand() {
		super("Crash Ship (c)");
	}
	
	@Override
	public void actionPerformed(ActionEvent evt) {
		gw.crashAsteroid();
	}
	
	public static CrashShipCommand getInstance() {
		if (crash == null) {
			crash = new CrashShipCommand();
		}
		return crash;
	}
	
	public static void setTarget(GameWorld game) {
		if (gw == null) {
			gw = game;
		}
	}
}
