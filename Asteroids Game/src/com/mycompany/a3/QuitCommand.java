package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;

public class QuitCommand extends Command {
	private static QuitCommand quit;
	private static GameWorld gw;
	
	public QuitCommand(){
		super( "Quit (Q)" );
	}
	
	public static QuitCommand getInstance() {
		if (quit == null) {
			quit = new QuitCommand();
		}
		return quit;
	}
	
	public static void setTarget(GameWorld game) {
		if (gw == null) {
			gw = game;
		}
	}
	
	@Override
	public void actionPerformed( ActionEvent e ){
		gw.quit();
	}
}
