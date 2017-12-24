package com.mycompany.a3;

import com.codename1.ui.events.*;
import com.codename1.ui.Command;

public class AboutCommand extends Command {
	private static AboutCommand about;
	private static GameWorld gw;
	
	public AboutCommand() {
		super("About (A)");
	}
	
	public static AboutCommand getInstance() {
		if (about == null) {
			about = new AboutCommand();
		}
		return about;
	}
	
	public static void setTarget(GameWorld game) {
		if (gw == null) {
			gw = game;
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent evt) {
		System.out.println("Author: Jacob Bender   Class: CSC 133    Assignment #3");
	}
}
