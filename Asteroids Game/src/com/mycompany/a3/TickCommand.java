package com.mycompany.a3;

import com.codename1.ui.events.*;
import com.codename1.ui.Command;

public class TickCommand extends Command {
	private static TickCommand tick;
	private static GameWorld gw;
	
	public TickCommand() {
		super("Tick (t)");
	}
	
	public static TickCommand getInstance() {
		if (tick == null) {
			tick = new TickCommand();
		}
		return tick;
	}
	
	public static void setTarget(GameWorld game) {
		if (gw == null) {
			gw = game;
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent evt) {
		gw.tick();
	}
}
