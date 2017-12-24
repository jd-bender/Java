package com.mycompany.a3;

import com.codename1.ui.events.*;
import com.codename1.ui.Command;

public class IncreaseCommand extends Command {
	private static IncreaseCommand increase;
	private static GameWorld gw;
	
	public IncreaseCommand() {
		super("Increase Speed (i)");
	}
	
	public static IncreaseCommand getInstance() {
		if (increase == null) {
			increase = new IncreaseCommand();
		}
		return increase;
	}
	
	public static void setTarget(GameWorld game) {
		if (gw == null) {
			gw = game;
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent evt) {
		gw.increaseSpeed();
	}
}
