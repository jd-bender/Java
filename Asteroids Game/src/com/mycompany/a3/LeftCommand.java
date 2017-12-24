package com.mycompany.a3;

import com.codename1.ui.events.*;
import com.codename1.ui.Command;

public class LeftCommand extends Command {
	private static LeftCommand left;
	private static GameWorld gw;
	
	public LeftCommand() {
		super("Turn Left (l)");
	}
	
	public static LeftCommand getInstance() {
		if (left == null) {
			left = new LeftCommand();
		}
		return left;
	}
	
	public static void setTarget(GameWorld game) {
		if (gw == null) {
			gw = game;
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent evt) {
		gw.turnLeft();
	}
}
