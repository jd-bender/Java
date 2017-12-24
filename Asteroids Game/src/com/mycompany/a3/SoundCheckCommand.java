package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.*;

public class SoundCheckCommand extends Command {
	private static SoundCheckCommand sound;
	private static GameWorld gw;
	
	public SoundCheckCommand() {
		super("Sound Check");
	}
	
	public static SoundCheckCommand getInstance() {
		if (sound == null) {
			sound = new SoundCheckCommand();
		}
		return sound;
	}
	
	public static void setTarget(GameWorld game) {
		if (gw == null) {
			gw = game;
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent evt) {
		if (gw.getSound() == false) {
			gw.setSoundOn();
			System.out.println("\nSound is on");
		} else {
			gw.setSoundOff();
			System.out.println("\nSound is off");
		}
	}
}
