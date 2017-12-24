package com.mycompany.a3;

import com.codename1.ui.events.*;
import com.codename1.ui.Command;

public class AddShipCommand extends Command {
	private static AddShipCommand addShip;
	private static GameWorld gw;
	
	public AddShipCommand() {
		super("Add Ship (s)");
	}
	
	public static AddShipCommand getInstance() {
		if (addShip == null) {
			addShip = new AddShipCommand();
		}
		return addShip;
	}
	
	public static void setTarget(GameWorld game) {
		if (gw == null) {
			gw = game;
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent evt) {
		gw.newShip();
	}
}
