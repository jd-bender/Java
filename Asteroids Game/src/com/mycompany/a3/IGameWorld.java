package com.mycompany.a3;

public interface IGameWorld {
	public void newAsteroid();
	public void newSpaceStation();
	public int getAsteroidCount();
	public int getScoreCount();
	public int getGameTime();
	public boolean getSound();
	public void setSoundOn();
	public void setSoundOff();
	public void updateWorld();
	public void newShip();
	public void increaseSpeed();
	public void decreaseSpeed();
	public void turnLeft();
	public void turnRight();
	public void fireMissile();
	public void hyperSpace();
	public void refillMissiles();
	public void killAsteroid();
	public void crashAsteroid();
	public void exterminateTwo();
	public void tick();
	public void printDisplay();
	public void quit();
}
