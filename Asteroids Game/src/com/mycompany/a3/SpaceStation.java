package com.mycompany.a3;

import java.util.Random;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;

public class SpaceStation extends FixedObject implements IDrawable {
	private double locX;
	private double locY;
	private int color;
	private int ID;
	private int blinkRate;
	private boolean blinkState;
	
	Random rn = new Random();
	
	public SpaceStation(int width, int height) {
		locX = rn.nextInt(width-0+1) + 0;
		locY = rn.nextInt(height-0+1) + 0;
		color = ColorUtil.rgb(rn.nextInt(255-0+1) + 0, rn.nextInt(255-0+1) + 0, rn.nextInt(255-0+1) + 0);
		ID = 0;
		blinkRate = rn.nextInt(10-0+1) + 0;
		blinkState = false;
		System.out.println("\nSpace Station Created");
	}
	
	public void blink() {
		if (blinkState) {
			blinkState = false;
		} else {
			blinkState = true;
		}
	}
	
	public void draw(Graphics g, Point pCmpRelPrnt) {
		int xLoc = (int) (pCmpRelPrnt.getX()+ locX);
		int yLoc = (int) (pCmpRelPrnt.getY()+ locY);
		int grey = ColorUtil.rgb(192, 192, 192);
		int black = ColorUtil.rgb(0,  0, 0);
		g.setColor(color);
		if (blinkState) {
			g.setColor(grey);
		} else if (!blinkState) {
			g.setColor(black);
		}
		
		g.drawRect(xLoc, yLoc, 100, 100);
		g.fillRect(xLoc, yLoc, 100, 100);
		blink();
	}
	
	public String toString() {
		String s = "Station: Loc = " + locX + "," + locY + " Color = " + color + " Rate = " + blinkRate;
		return s;
	}
}
