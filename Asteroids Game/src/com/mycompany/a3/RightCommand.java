package com.mycompany.a3;

import com.codename1.ui.events.*;
import com.codename1.ui.Command;

public class RightCommand extends Command {
	private static RightCommand right;
	private static GameWorld gw;
	
	public RightCommand() {
		super("Turn Right (r)");
	}
	
	public static RightCommand getInstance() {
		if (right == null) {
			right = new RightCommand();
		}
		return right;
	}
	
	public static void setTarget(GameWorld game) {
		if (gw == null) {
			gw = game;
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent evt) {
		gw.turnRight();
	}
}
