package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class RefuelCommand extends Command {
	private static RefuelCommand refuel;
	private static GameWorld gw;
	
	public RefuelCommand() {
		super("Refuel (R)");
	}
	
	public static RefuelCommand getInstance() {
		if (refuel == null) {
			refuel = new RefuelCommand();
		}
		return refuel;
	}
	
	public static void setTarget(GameWorld game) {
		if (gw == null) {
			gw = game;
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent evt) {
		gw.refuel();
	}
}
