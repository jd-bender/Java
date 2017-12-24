package com.mycompany.a3;

import java.util.Random;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;

public class Asteroid extends MoveableObject implements IDrawable, ISelectable, ICollider {
	private double locX;
	private double locY;
	private int mapWidth;
	private int mapHeight;
	private int color;
	private int black = ColorUtil.rgb(0, 0, 0);
	private int grey = ColorUtil.rgb(192, 192, 192);
	private final int speed;
	private final int direction;
	private int size;
	private boolean selected;
	private boolean collision;
	
	Random rn = new Random();
	
	public Asteroid(int width, int height) {
		locX = rn.nextInt(width-0+1) + 0;
		locY = rn.nextInt(height-0+1) + 0;
		mapWidth = width;
		mapHeight = height;
		color = ColorUtil.rgb(rn.nextInt(255-0+1) + 0, rn.nextInt(255-0+1) + 0, rn.nextInt(255-0+1) + 0);
		speed = rn.nextInt(10-1+1) + 1;
		direction = rn.nextInt(359-0+1) + 0;
		size = rn.nextInt(50-30+1) + 30;
		selected = false;
		collision = false;
		System.out.println("\nAsteroid created");
	}
	
	public int getSize() {
		return size;
	}
	
	@Override
	public void draw(Graphics g, Point pCmpRelPrnt) {
		int xLoc = (int) (pCmpRelPrnt.getX()+ locX);
		int yLoc = (int) (pCmpRelPrnt.getY()+ locY);
		if (selected) {
			g.setColor(black);
		} else {
			g.setColor(grey);
		}
		//g.setColor(color);
		g.drawArc(xLoc, yLoc, 2*size, 2*size, 0, 360);
		g.fillArc(xLoc, yLoc, 2*size, 2*size, 0, 360);
		move();
	}
	
	public void move() {
		double theta = 90 - direction;
		double deltaX = Math.cos(theta)*speed;
		double deltaY = Math.sin(theta)*speed;
		if ( (locX+size >= mapWidth) || (locX < 0) ) deltaX = -deltaX ; 
		if ( (locY+size >= mapHeight) || (locY < 0) ) deltaY = -deltaY;
		locX = locX + deltaX;
		locY = locY + deltaY;
		locX = Math.round(locX * 100D) / 100D;
		locY = Math.round(locY * 100D) / 100D;
//		if ( (locX+size >= mapWidth) || (locX < 0) ) deltaX = -deltaX ; 
//		if ( (locY+size >= mapHeight) || (locY < 0) ) deltaY = -deltaY;
	}
	
	public void setSelected(boolean select) {
		selected = select;
		System.out.println("Asteroid selected: " + select);
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
		System.out.println("Asteroid collision happened");
	}
	
	public String toString() {
		String s =  "Asteroid: Loc = " + locX + "," + locY + " Color = " + color + " Speed = "
				+ speed + " Direction = " + direction + " Size = " + size;
		return s;
	}
}
