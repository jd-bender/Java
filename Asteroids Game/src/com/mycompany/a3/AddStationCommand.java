package com.mycompany.a3;

import com.codename1.ui.events.*;
import com.codename1.ui.Command;

public class AddStationCommand extends Command {
	private static AddStationCommand addStation;
	private static GameWorld gw;
	
	public AddStationCommand() {
		super("Add Station (b)");
	}
	
	public static AddStationCommand getInstance() {
		if (addStation == null) {
			addStation = new AddStationCommand();
		}
		return addStation;
	}
	
	public static void setTarget(GameWorld game) {
		if (gw == null) {
			gw = game;
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent evt) {
		gw.newSpaceStation();
	}
}
