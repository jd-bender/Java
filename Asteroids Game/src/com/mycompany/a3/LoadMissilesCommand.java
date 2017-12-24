package com.mycompany.a3;

import com.codename1.ui.events.*;
import com.codename1.ui.Command;

public class LoadMissilesCommand extends Command {
	private GameWorld gw;
	
	public LoadMissilesCommand(GameWorld gw) {
		super("Load Missiles (n)");
		this.gw = gw;
	}
	@Override
	
	public void actionPerformed(ActionEvent evt) {
		gw.refillMissiles();
	}
}
