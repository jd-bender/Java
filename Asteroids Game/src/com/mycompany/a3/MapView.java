package com.mycompany.a3;


import java.util.Observable;
import java.util.Observer;
import java.util.Random;

import com.codename1.ui.Container;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;

public class MapView extends Container implements Observer {
	private int mapWidth;
	private int mapHeight; 
	private GameWorld gw;
	private Game game;
	private GameCollection go;
	private Point pCmpRelPrnt;
	
	public MapView() {
	}
	
	public void setMapWidth(int width) {
		mapWidth = width;
	}
	
	public void setMapHeight(int height) {
		mapHeight = height;
	}
	
	public int getMapWidth() {
		return mapWidth;
	}
	
	public int getMapHeight() {
		return mapHeight;
	}
	
	public void setGame(Game gm) {
		this.game = gm;
	}
	
	public void update(Observable observable, Object data) {
		
		gw = (GameWorld) observable;
		go = gw.getGameObjects();
		repaint();
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Point pCmpRelPrnt = new Point(this.getX(), this.getY());
		IIterator gameIterator = go.getIterator();
	
		while (gameIterator.hasNext()) {
			Object obj = gameIterator.getNext();
			if (obj instanceof Asteroid) {
				((Asteroid) obj).draw(g, pCmpRelPrnt);
				((Asteroid) obj).move();
			} else if (obj instanceof Ship) {
				((Ship) obj).draw(g, pCmpRelPrnt);
				((Ship) obj).move();
			} else if (obj instanceof Missile) {
				((Missile) obj).draw(g, pCmpRelPrnt);
				((Missile) obj).move();
			} else if (obj instanceof SpaceStation) {
				((SpaceStation) obj).draw(g, pCmpRelPrnt);
			}
		}
	}
	
	public void pointerPressed(int x, int y) {
		if (this.game.isPaused() == false) {
			System.out.println("Game not paused");
			return;
		}
		System.out.println("Game is paused");
		

//		Point testPnt = new Point(x, y);
//		System.out.println("x1: " + x + " y1: " + y);
		x = x - getParent().getAbsoluteX() - getX();
		y = y - getParent().getAbsoluteY() - getY();
//		System.out.println("x2: " + x + " y2: " + y);
		Point p = new Point(x, y);
		IIterator clickIterator = go.getIterator();
//		Point pPtrRelPrnt = new Point(x, y);
//		Point pCmpRelPrnt = new Point(getX(), getY());
		while (clickIterator.hasNext()) {
			Object obj = clickIterator.getNext();
			if (obj instanceof ISelectable && (((ISelectable) obj).contains(p))) {
				System.out.println("made it this far");
				((ISelectable) obj).setSelected(!((ISelectable) obj).isSelected());
			}
		}
		repaint(); 
	}

}
