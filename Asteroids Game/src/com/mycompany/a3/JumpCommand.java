package com.mycompany.a3;

import com.codename1.ui.events.*;
import com.codename1.ui.Command;

public class JumpCommand extends Command {
	private static JumpCommand jump;
	private static GameWorld gw;
	
	public JumpCommand() {
		super("Jump to Hyperspace (j)");
	}
	
	public static JumpCommand getInstance() {
		if (jump == null) {
			jump = new JumpCommand();
		}
		return jump;
	}
	
	public static void setTarget(GameWorld game) {
		if (gw == null) {
			gw = game;
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent evt) {
		gw.hyperSpace();
	}
}
