package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.*;

public class PrintDisplayCommand extends Command {
	private static PrintDisplayCommand print;
	private static GameWorld gw;
	
	public PrintDisplayCommand() {
		super("Print Display (m)");
	}
	
	public static PrintDisplayCommand getInstance() {
		if (print == null) {
			print = new PrintDisplayCommand();
		}
		return print;
	}
	
	public static void setTarget(GameWorld game) {
		if (gw == null) {
			gw = game;
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent evt) {
		gw.printMap();
	}
}
