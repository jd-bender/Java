package com.mycompany.a3;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;

public abstract class GameObject {
	
	private double locX;
	private double locY;
	private static int color;
	private int size;
	
	
	public double getLocationX() {
		return locX;
	}
	
	public int getSize() {
		return size;
	}
	
	public double getLocationY() {
		return locY;
	}
	
	public int getColor() {
		return color;
	}
	
	public void setColor(int r, int g, int b) {
		color = ColorUtil.rgb(r, g, b);
	}
	
	public void draw(Graphics g, Point pCmpRelPrnt) {
		
	}
}
