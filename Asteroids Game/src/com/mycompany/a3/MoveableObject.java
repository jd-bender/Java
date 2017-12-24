package com.mycompany.a3;

public abstract class MoveableObject extends GameObject {
	private double locX;
	private double locY;
	private int color;
	private int speed;
	private int direction;
	
	public void setLocation(double newLocX, double newLocY) {
		locX = newLocX;
		locY = newLocY;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public int getDirection() {
		return direction;
	}
	
	public void move() {
		double theta = 90 - this.direction;
		double deltaX = Math.cos(theta)*this.speed;
		double deltaY = Math.sin(theta)*this.speed;
		this.locX = this.locX + deltaX;
		this.locY = this.locY + deltaY;
		this.locX = Math.round(this.locX * 100D) / 100D;
		this.locY = Math.round(this.locY * 100D) / 100D;
	};
}
