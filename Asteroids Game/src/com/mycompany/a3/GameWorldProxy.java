package com.mycompany.a3;

import java.util.Observable;

public class GameWorldProxy extends Observable implements IGameWorld {
	private GameWorld realGameWorld;
	
	public GameWorldProxy(GameWorld gw) {
		realGameWorld = gw;
	}
	
	public void init() {
		realGameWorld.init();
	}
	
	public void newAsteroid() {
		realGameWorld.newAsteroid();
		realGameWorld.updateWorld();
	}
	
	public void newSpaceStation() {
		realGameWorld.newSpaceStation();
		realGameWorld.updateWorld();
	}
	
	public int getAsteroidCount() {
		return realGameWorld.getAsteroidCount();
	}
	
	public int getScoreCount() {
		return realGameWorld.getScoreCount();
	}
	
	public int getGameTime() {
		return realGameWorld.getGameTime();
	}
	
	public boolean getSound() {
		return realGameWorld.getSound();
	}
	
	public void setSoundOn() {
		realGameWorld.setSoundOn();
	}
	
	public void setSoundOff() {
		realGameWorld.setSoundOff();
	}
	
	public void updateWorld() {
		realGameWorld.updateWorld();
	}
	public void newShip() {
		realGameWorld.newShip();
	}
	public void increaseSpeed() {
		realGameWorld.increaseSpeed();
	}
	public void decreaseSpeed() {
		realGameWorld.decreaseSpeed();
	}
	public void turnLeft() {
		realGameWorld.turnLeft();
	}
	public void turnRight() {
		realGameWorld.turnRight();
	}
	public void fireMissile() {
		realGameWorld.fireMissile();
	}
	public void hyperSpace() {
		realGameWorld.hyperSpace();
	}
	public void refillMissiles() {
		realGameWorld.refillMissiles();
	}
	public void killAsteroid() {
		realGameWorld.killAsteroid();
	}
	public void crashAsteroid() {
		realGameWorld.crashAsteroid();
	}
	public void exterminateTwo() {
		realGameWorld.exterminateTwo();
	}
	public void tick() {
		realGameWorld.tick();
		realGameWorld.updateWorld();
	}
	public void printDisplay() {
		realGameWorld.printDisplay();
	}
	public void quit() {
		realGameWorld.quit();
	}
}
