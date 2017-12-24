package com.mycompany.a3;

import java.util.Random;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;

import java.lang.Math;


public class Ship extends MoveableObject implements ISteerable, IDrawable, ICollider {
	private double locX;
	private double locY;
	private int color;
	private int speed;
	private int direction;
	private int missileCount;
	private int size;
	private boolean collision;
	
	Random rn = new Random();
	
	public Ship(int width, int height) {
		locX = width/2;
		locY = height/2;
		color = ColorUtil.rgb(rn.nextInt(255-0+1) + 0, rn.nextInt(255-0+1) + 0, rn.nextInt(255-0+1) + 0);
		speed = 0;
		direction = 0;
		missileCount = 10;
		size = 75;
		collision = false;
	}
	
	public void move() {
		double theta = 90 - direction;
		double deltaX = Math.cos(theta)*speed;
		double deltaY = Math.sin(theta)*speed;
		locX = locX + deltaX;
		locY = locY + deltaY;
		locX = Math.round(locX * 100D) / 100D;
		locY = Math.round(locY * 100D) / 100D;
	}
	
	@Override
	public void draw(Graphics g, Point pCmpRelPrnt) {
		int xLoc = (int) (pCmpRelPrnt.getX()+ locX);
		int yLoc = (int) (pCmpRelPrnt.getY()+ locY);
		g.setColor(color);
		g.drawRoundRect(xLoc, yLoc, size, size, 20, 10);
		g.fillRoundRect(xLoc, yLoc, size, size, 20, 10);
	}
	
	public void setLocation(double newLocX, double newLocY) {
		locX = newLocX;
		locY = newLocY;
	}
	
	public int getDirection() {
		return direction;
	}
	
	public double getLocationX() {
		return locX;
	}
	
	public double getLocationY() {
		return locY;
	}
	
	public int getMissileCount() {
		return missileCount;
	}
	
	public void counterClockwiseRotation() {
		direction = 360;
		System.out.println("\nTurn left");
	}
	
	public void clockwiseRotation() {
		direction = 0;
		System.out.println("\nTurn right");
	}
	
	public void increaseSpeed() {
		if (speed < 10) {
			System.out.println("\nSpeed increased");
			speed++;
		} else {
			System.out.println("\nSpeed at maximum power");
		}
	}
	
	public void decreaseSpeed() {
		if (speed > 0) {
			System.out.println("\nSpeed decreased");
			speed--;
		} else {
			System.out.println("\nSpeed already at 0");
		}
	}
	
	public void turnLeft() {
		if (direction > 0) {
			direction--;
			System.out.println("\nTurn left");
		}
	}
	
	public void turnRight() {
		if (direction < 360) {
			direction++;
			System.out.println("\nTurn right");
		}
	}
	
	public void fireMissile() {
		if (missileCount > 0) {
			missileCount--;
		}
//		} else {
//			System.out.println("\nAll out of missiles");
//		}
	}
	
	public void refillMissiles() {
		if (missileCount == 10) {
			System.out.println("\nAlready at maximum missile capacity");
			return;
		}
		missileCount = 10;
		System.out.println("\nNew supply of missiles");
	}
	
	public boolean collidesWith(GameObject obj) {
		
		double p1x = getLocationX(); 
        double p2x = getLocationX() + getSize(); 
        double p3x = getLocationX(); 
        double p4x = getLocationX() + getSize(); 
        double p1y = getLocationY(); 
        double p2y = getLocationY(); 
        double p3y = getLocationY() + getSize(); 
        double p4y = getLocationY() + getSize(); 

        double a1x = obj.getLocationX(); 
        double a2x = obj.getLocationX() + obj.getSize(); 
        double a3x = obj.getLocationX(); 
        double a4x = obj.getLocationX() + getSize(); 
        double a1y = obj.getLocationY(); 
        double a2y = obj.getLocationY(); 
        double a3y = obj.getLocationY() + obj.getSize(); 
        double a4y = obj.getLocationY() + obj.getSize(); 

        if ((p1x > a1x && p1x < a2x) && (p1y > a1y && p1y < a3y) ||
        	(p2x > a1x && p2x < a2x) && (p2y > a1y && p2y < a3y) ||
        	(p3x > a1x && p3x < a2x) && (p3y > a1y && p3y < a3y) ||
        	(p4x > a1x && p4x < a2x) && (p4y > a1y && p4x < a3x)) {
 
        	collision = true; 
        	return true; 
        } else { 
        	collision = false; 
        	return false; 
        } 
	}
	
	public void handleCollision(GameObject obj, GameWorld gw) {
		System.out.println("Ship collision happened");
	}
	
	public String toString() {
		String s = "Ship: Loc = " + locX + "," + locY + " Color = " + color + " Speed = "
				+ speed + " Direction = " + direction + " Missile Count = " + missileCount;
		return s;
	}
	
}
