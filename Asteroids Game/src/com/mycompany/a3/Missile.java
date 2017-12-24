package com.mycompany.a3;

import java.util.Random;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;

public class Missile extends MoveableObject implements ISelectable, IDrawable, ICollider {
	private double locX;
	private double locY;
	private static int color;
	private int speed;
	private int direction;
	private int fuelLevel;
	private boolean selected;
	private boolean collision;
	private int size;
	
	Random rn = new Random(); 
	
	public Missile(Ship ship) {
		locX = ship.getLocationX();
		locY = ship.getLocationY();
		color = ColorUtil.rgb(255, 0, 0);
		speed = 10;
		direction = ship.getDirection();
		fuelLevel = 10;
		collision = false;
		selected = false;
	}
	
	public int getFuel() {
		return fuelLevel;
	}
	
	public void useFuel() {
		System.out.println("Use fuel called");
		if (fuelLevel > 0) {
			fuelLevel--;
		} else {
			System.out.println("Out of fuel");
		}
	}
	
	public void refuelMissile() {
		fuelLevel = 10;
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
	
	public int getSize() {
		return size;
	}
	
	public void draw(Graphics g, Point pCmpRelPrnt) {
		int xLoc = (int) (pCmpRelPrnt.getX()+ locX);
		int yLoc = (int) (pCmpRelPrnt.getY()+ locY);
		int red = ColorUtil.rgb(255, 0, 0);
		int yellow = ColorUtil.rgb(255, 255, 7);
		g.setColor(color);
		if (selected) {
			g.setColor(yellow);
		} else {
			g.setColor(red);
		}
		
		g.drawRect(xLoc, yLoc, 10, 80);
		g.fillRect(xLoc, yLoc, 10, 80);
	}
	
	public void setSelected(boolean select) {
		selected = select;
	}
	
	public boolean isSelected() {
		return selected;
	}
	
	public boolean contains(Point p) {
		double x1, x2, y1, y2;
		x1 = getLocationX()-(getSize()/2);
		x2 = getLocationX()+(getSize()/2);
		y1 = getLocationY()-(getSize()/2);
		y2 = getLocationY()+(getSize()/2);
		
		if(p.getX() >= x1 && p.getX() <= x2){
			if(p.getY() >= y1 && p.getY() <= y2){
				return true;
			}
		}
		return false;
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
		System.out.println("Missile collision happened");
	}
	
	public String toString() {
		String s = "Missile: Loc = " + locX + "," + locY + " Color = " + color + " Speed = " + speed
				+ " Direction = " + direction + " Fuel = " + fuelLevel;
		return s;
	}
}
