package com.mycompany.a3;

import com.codename1.ui.events.*;
import com.codename1.ui.Command;

public class DecreaseCommand extends Command {
	private static DecreaseCommand decrease;
	private static GameWorld gw;
	
	public DecreaseCommand() {
		super("Decrease Speed (d)");
	}
	
	public static DecreaseCommand getInstance() {
		if (decrease == null) {
			decrease = new DecreaseCommand();
		}
		return decrease;
	}
	
	public static void setTarget(GameWorld game) {
		if (gw == null) {
			gw = game;
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent evt) {
		gw.decreaseSpeed();
	}
}
