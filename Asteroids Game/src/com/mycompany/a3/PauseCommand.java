package com.mycompany.a3;

import com.codename1.ui.events.*;
import com.codename1.ui.Command;

public class PauseCommand extends Command {
	private static PauseCommand pause;
	private static Game game;
	
	
	public PauseCommand() {
		super("Pause Game (p)");
	}
	
	public static PauseCommand getInstance(){ 
        if(pause == null) 
            pause = new PauseCommand(); 
        return pause; 
    } 
	
	public static void setTarget(Game gw){ 
        if(game == null) 
            game = gw; 
    } 
	
	public void actionPerformed(ActionEvent evt) {
		if (game.isPaused()) {
			game.resumeGame();
		} else if (game.isPaused() == false) {
			game.pauseGame();
		}
	}
}
