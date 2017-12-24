package com.mycompany.a3;

import com.codename1.ui.events.*;
import com.codename1.ui.Command;

public class ExterminateCommand extends Command {
	private GameWorld gw;
	
	public ExterminateCommand(GameWorld gw) {
		super("Exterminate (x)");
		this.gw = gw;
	}
	@Override
	
	public void actionPerformed(ActionEvent evt) {
		gw.exterminateTwo();
	}
}
