package com.mycompany.a3;

import java.io.IOException;
import java.util.Observable;
import java.util.Vector;
import com.codename1.ui.*;

public class GameWorld extends Observable implements IGameWorld {
	private int mapWidth;
	private int mapHeight;
	private int score;
	private int gameTime;
	private int lives;
	private int missileCount;
	private Sound fireMissile;
	private Sound gameOver;
	private BGSound backGround;
	private boolean sound;
	private GameCollection go;
	private Vector<GameObject> collisionArray = new Vector<GameObject>();
	
	
	public GameWorld() {
		mapWidth = 0;
		mapHeight = 0;
		score = 0;
		gameTime = 0;
		lives = 3;
		missileCount = 0;
		sound = true;
//		try {
//			sounds = new Sound("drumSolo.mp3");
//			sounds.play();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		go = new GameCollection();
		backGround = new BGSound("8bitSuperStar.mp3");
		backGround.run();
	}
	
	
	public void init() {
//		go = new GameCollection();
//		updateWorld();
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
	
	public GameCollection getGameObjects() {
		return go;
	}
	
	public int getAsteroidCount() {
		Object gob;
		IIterator gameIterator = this.go.getIterator();
		int count = 0;
		while (gameIterator.hasNext()) {
			gob = gameIterator.getNext();
			if (gob instanceof Asteroid) {
				count++;
			}
		}
		return count;
	}
	
	
	public int getScoreCount() {
		return this.score;
	}
	
	
	public int getLivesCount() {
		return this.lives;
	}
	
	public int getMissileCount() {
		Object obj;
		int missileCount = 0;
		IIterator shipIterator = this.go.getIterator();
		
		for (int i = 0; i < go.getSize(); i++) {
			while (shipIterator.hasNext()) {
				obj = shipIterator.getNext();
				if (obj instanceof Ship) {
					return ((Ship) obj).getMissileCount();
				}
			}
		}
		
		return missileCount;
	}
	
	
	public int getGameTime() {
		return this.gameTime;
	}
	
	
	public boolean getSound() {
		return this.sound;
	}
	
	
	public void setSoundOn() {
		this.sound = true;
		backGround.play();
		//sounds.play();
		updateWorld();
	}
	
	public void setSoundOff() {
		this.sound = false;
		backGround.pause();
		//sounds.pause();
		//sounds.stopBackGroundSound();
		updateWorld();
	}
	
	
	public void updateWorld() {
		setChanged();
		GameWorldProxy gwProxy = new GameWorldProxy(this);
		notifyObservers(gwProxy);
	}
	
	
	public void newAsteroid() {
		go.add(new Asteroid(mapWidth, mapHeight));
        updateWorld();
	}
	
	
	public void newSpaceStation() {
		go.add(new SpaceStation(mapWidth, mapHeight));
        updateWorld();
	}
	
	
	public void newShip() {
		boolean shipCheck = false;
		Object gob;
		IIterator gameIterator = this.go.getIterator();
		
		for (int i = 0; i < go.getSize(); i++) {
			while (gameIterator.hasNext()) {
				gob = gameIterator.getNext();
				if (gob instanceof Ship) {
					shipCheck = true;
					break;
				}
			}
		}
		
		if (shipCheck) {
			System.out.println("\nOnly one ship can exist at a time");
		} else {
			go.add(new Ship(mapWidth, mapHeight));
			System.out.println("\nShip created");
		}
		
		updateWorld();
	}
	
	
	public void increaseSpeed() {
		Object gob;
		IIterator gameIterator = this.go.getIterator();
		boolean flag = false;
		
		for (int i = 0; i < go.getSize(); i++) {
			while (gameIterator.hasNext()) {
				gob = gameIterator.getNext();
				if (gob instanceof Ship) {
					Ship ship = (Ship) gob;
					flag = true;
					ship.increaseSpeed();
				}
			}
		}
		
		if (flag == false) {
			System.out.println("\nNo ship to accelerate");
		}

		updateWorld();
	}
	
	
	public void decreaseSpeed() {
		Object gob;
		IIterator gameIterator = this.go.getIterator();
		boolean flag = false;
		
		for (int i = 0; i < go.getSize(); i++) {
			while (gameIterator.hasNext()) {
				gob = gameIterator.getNext();
				if (gob instanceof Ship) {
					Ship ship = (Ship) gob;
					flag = true;
					ship.decreaseSpeed();
				}
			}
		}
		
		if (flag == false) {
			System.out.println("\nNo ship to decelerate");
		}

		updateWorld();
	}
	
	
	public void turnLeft() {
		Object gob;
		IIterator gameIterator = this.go.getIterator();
		boolean flag = false;
		
		for (int i = 0; i < go.getSize(); i++) {
			while (gameIterator.hasNext()) {
				gob = gameIterator.getNext();
				if (gob instanceof Ship) {
					Ship ship = (Ship) gob;
					flag = true;
					if (ship.getDirection() == 0) {
						ship.counterClockwiseRotation();
					} else {
						ship.turnLeft();
					}
				}
			}
		}
		
		if (flag == false) {
			System.out.println("\nNo ship to steer");
		}
		
		updateWorld();
	}
	
	
	public void turnRight() {
		Object gob;
		IIterator gameIterator = this.go.getIterator();
		boolean flag = false;
		
		for (int i = 0; i < go.getSize(); i++) {
			while (gameIterator.hasNext()) {
				gob = gameIterator.getNext();
				if (gob instanceof Ship) {
					Ship ship = (Ship) gob;
					flag = true;
					if (ship.getDirection() == 360) {
						ship.clockwiseRotation();
					} else {
						ship.turnRight();
					}
				}
			}
		}
		
		if (flag == false) {
			System.out.println("\nNo ship to steer");
		}
			
		updateWorld();
	}
	
	
	public void hyperSpace() {
		Object gob;
		IIterator gameIterator = this.go.getIterator();
		boolean flag = false;
		
		for (int i = 0; i < go.getSize(); i++) {
			while (gameIterator.hasNext()) {
				gob = gameIterator.getNext();
				if (gob instanceof Ship) {
					Ship ship = (Ship) gob;
					flag = true;
					if (ship.getLocationX() == mapWidth/2 && ship.getLocationY() == mapHeight/2) {
						System.out.println("\nShip already at origin point");
						return;
					}
					
					ship.setLocation(mapWidth/2, mapHeight/2);
					System.out.println("\nJump through hyperspace");
				}
			}
		}
		
		if (flag == false) {
			System.out.println("\nNo ship to jump");
		}
		
		updateWorld();
	}
	
	
	public void fireMissile() {
		Object gob;
		IIterator gameIterator = this.go.getIterator();
		boolean flag = false;
		Ship ship = new Ship(mapWidth, mapHeight);
		
		for (int i = 0; i <= go.getSize(); i++) {
			while (gameIterator.hasNext()) {
				gob = gameIterator.getNext();
				if (gob instanceof Ship) {
					ship = (Ship) gob;
					flag = true;
				}
			}
		}
		
		if (flag == false) {
			System.out.println("\nNo ship to fire missiles from");
			return;
		}
		
		if (ship.getMissileCount() == 0) {
			System.out.println("All out of missiles");
			return;
		}
		
		Missile tmp = new Missile(ship);
		go.add(tmp);
		ship.fireMissile();
		
		if (sound) {
			fireMissile = new Sound("missileFire.wav");
			fireMissile.play();
		}
		
		System.out.println("\nMissile fired");
		updateWorld();
	}
	
	
	public void refillMissiles() {
		Object gob;
		Ship ship = new Ship(mapWidth, mapHeight);
		IIterator shipIterator = this.go.getIterator();
		boolean shipFlag = false;
		boolean spaceStationFlag = false;
		
		for (int i = 0; i < go.getSize(); i++) {
			while (shipIterator.hasNext()) {
				gob = shipIterator.getNext();
				if (gob instanceof Ship) {
					shipFlag = true;
					ship = (Ship) gob;
				}
			}
		}
		
		IIterator spaceStationIterator = this.go.getIterator();
		
		for (int i = 0; i < go.getSize(); i++) {
			while (spaceStationIterator.hasNext()) {
				gob = spaceStationIterator.getNext();
				if ((gob instanceof SpaceStation) && (shipFlag)) {
					spaceStationFlag = true;
					ship.refillMissiles();
				}
			}
		}
		
		if (shipFlag == false) {
			System.out.println("\nNo ship to load missiles into");
			return;
		}
		
		if (spaceStationFlag == false) {
			System.out.println("\nNo space station to take missiles from");
			return;
		}
		
		updateWorld();
	}
	
	
	public void killAsteroid() {
		Object obj = new Object();
		Object missile = new Object();
		Object asteroid = new Object();
		
		boolean missileCheck = false;
		boolean asteroidCheck = false;
		
		IIterator missileIterator = this.go.getIterator();
		
		for (int i = 0; i < go.getSize(); i++) {
			while (missileIterator.hasNext()) {
				obj = missileIterator.getNext();
				if (obj instanceof Missile) {
					missile = obj;
					missileCheck = true;
					break;
				}
			}
		}
		
		if (!missileCheck) {
			System.out.println("\nNo missile to hit asteroid");
			return;
		}
		
		IIterator asteroidIterator = this.go.getIterator();
		
		for (int i = 0; i < go.getSize(); i++) {
			while (asteroidIterator.hasNext()) {
				obj = asteroidIterator.getNext();
				if (obj instanceof Asteroid) {
					asteroid = obj;
					asteroidCheck = true;
					break;
				}
			}
		}
		
		if (!asteroidCheck) {
			System.out.println("\nNo asteroid for missile to hit");
			return;
		}
		
		if (missileCheck && asteroidCheck) {
			go.remove(missile);	
			go.remove(asteroid);
			score++;
		}
		
		System.out.println("\nKilled an asteroid");
		updateWorld();
	}
	
	
	public void crashAsteroid() {
		Object obj = new Object();
		Object ship = new Object();
		Object asteroid = new Object();
		
		boolean shipCheck = false;
		boolean asteroidCheck = false;
		
		IIterator shipIterator = this.go.getIterator();
		
		for (int i = 0; i < go.getSize(); i++) {
			while (shipIterator.hasNext()) {
				obj = shipIterator.getNext();
				if (obj instanceof Ship) {
					ship = obj;
					shipCheck = true;
					break;
				}
			}
		}
		
		if (!shipCheck) {
			System.out.println("\nNo ship to crash into asteroid");
			return;
		}
		
		IIterator asteroidIterator = this.go.getIterator();
		
		for (int i = 0; i < go.getSize(); i++) {
			while (asteroidIterator.hasNext()) {
				obj = asteroidIterator.getNext();
				if (obj instanceof Asteroid) {
					asteroid = obj;
					asteroidCheck = true;
					break;
				}
			}
		}
		
		if (!asteroidCheck) {
			System.out.println("\nNo asteroid for ship to crash into");
			return;
		}
		
		if (shipCheck && asteroidCheck) {
			go.remove(ship);
			go.remove(asteroid);
			System.out.println("\nKaboom!");
			newShip();
		}
		
		if (lives > 0) {
			lives--;
		} else {
			System.out.println("Game over!");
			gameOver = new Sound("gameOver.mp3");
			backGround.pause();
			gameOver.play();
			TextField myText = new TextField();
			Dialog.show("Final score: " + score, myText, new Command( "Enter" ) );
			
			System.exit(0);
		}
		
		updateWorld();
	}
	
	public void refuel() {
		Object obj = new Object();		
		
		IIterator fuelIterator = this.go.getIterator();
		
		for (int i=0; i<go.getSize(); i++) {
			while (fuelIterator.hasNext()) {
				obj = fuelIterator.getNext();
				if (obj instanceof Missile) {
					((Missile) obj).refuelMissile();
				}
			}
		}
	}
	
	public void exterminateTwo() {
		Object obj = new Object();		
		int count = 0;
		
		IIterator countIterator = this.go.getIterator();
		
		for (int i=0; i<go.getSize(); i++) {
			while (countIterator.hasNext()) {
				obj = countIterator.getNext();
				if (obj instanceof Asteroid) {
					count++;
				}
			}
		}
		
		IIterator ast1Iterator = this.go.getIterator();
		
		if (count >= 2) {
			for (int i=0; i<go.getSize(); i++) {
				while (ast1Iterator.hasNext()) {
					obj = ast1Iterator.getNext();
					if (obj instanceof Asteroid) {
						go.remove(obj);
						break;
					}
				}
			}
			
			IIterator ast2Iterator = this.go.getIterator();
			
			for (int i=0; i<go.getSize(); i++) {
				while (ast2Iterator.hasNext()) {
					obj = ast2Iterator.getNext();
					if (obj instanceof Asteroid) {
						go.remove(obj);
						break;
					}
				}
			}
			
			System.out.println("\n2 asteroids exterminated");
			
		} else {
			System.out.println("\nNot enough asteroids for collision");
		}
		
		updateWorld();
	}
	
	public void tick() {
		Object gob;
		IIterator moveIterator = this.go.getIterator();
		
		for (int i=0; i<go.getSize(); i++) {
			while (moveIterator.hasNext()) {
				gob = moveIterator.getNext();
				if (gob instanceof MoveableObject && !(gob instanceof SpaceStation)) {
					MoveableObject mObj = (MoveableObject) gob;
					if (mObj instanceof Missile) { 
						mObj.move();
						((Missile) mObj).useFuel();
						if (((Missile) mObj).getFuel() == 0) {
							go.remove(mObj);
						}
					} else {
						mObj.move();
					}
					break;
				} else if (gob instanceof FixedObject && gob instanceof SpaceStation) {
					SpaceStation fObj = (SpaceStation) gob;
					fObj.blink();
				} 
			}
		}
		
		gameTime++;
		updateWorld();
		
		collision();
	}
	
	private void collision() {
		Object firstObject;
		Object secondObject;
		int intNum;
		
		IIterator iterate1 = go.getIterator();
		while (iterate1.hasNext()) {
			firstObject = iterate1.getNext();
			
			if (firstObject instanceof Asteroid) {
				//System.out.println("Asteroid found");
				Asteroid ast = (Asteroid) firstObject;
				//IIterator iterate2 = go.getIterator();
				while(iterate1.hasNext()){
					secondObject = iterate1.getNext();
					if (secondObject instanceof Asteroid) {
						//System.out.println("Second asteroid found");
						Asteroid ast2 = (Asteroid) secondObject;
						if (ast.collidesWith(ast2) && !collisionCheck(ast)) {
							//currentTime = clockTick;
							System.out.println("Collision between asteroid and asteroid");
							ast.handleCollision(ast, this);
							addCollision(ast);
						}
					} else if (secondObject instanceof Ship) {
						Ship ship = (Ship) secondObject;
						if (ast.collidesWith(ship) && !collisionCheck(ast)) {
							System.out.println("Collision between asteroid and ship");
							ast.handleCollision(ast, this);
							addCollision(ast);
						}
					} else if (secondObject instanceof Missile) {
						Missile missile = (Missile) secondObject;
						if (ast.collidesWith(missile) && !collisionCheck(ast)) {
							System.out.println("Collision between asteroid and missile");
							ast.handleCollision(ast, this);
							addCollision(ast);
						}
					}
				}
			} else if (firstObject instanceof Ship) {
				Ship ship = (Ship) firstObject;
				IIterator iterate2 = go.getIterator();
				while(iterate2.hasNext()){
					secondObject = iterate2.getNext();
					if (secondObject instanceof Asteroid) {
						Asteroid ast2 = (Asteroid) secondObject;
						if (ship.collidesWith(ast2) && !collisionCheck(ship)) {
							System.out.println("Collision between ship and asteroid");
							ship.handleCollision(ship, this);
							addCollision(ship);
						}
					}
				}
			} else if (firstObject instanceof Missile) {
				Missile missile = (Missile) firstObject;
				IIterator iterate2 = go.getIterator();
				while(iterate2.hasNext()){
					secondObject = iterate2.getNext();
					if (secondObject instanceof Asteroid) {
						Asteroid ast = (Asteroid) secondObject;
						if (missile.collidesWith(ast) && !collisionCheck(missile)) {
							System.out.println("Collision between missile and asteroid");
							missile.handleCollision(missile, this);
							addCollision(missile);
						}
					}
				}
			}
		}
	}
	
	public boolean collisionCheck(GameObject obj) {
		for(int i = 0; i < collisionArray.size(); i++){
			if(collisionArray.get(i) == obj){
				return true;
			}
		}
		return false;
	}
	
	public void addCollision(GameObject obj) {
		collisionArray.add(obj);
	}
	
	public void printDisplay() {
		Object gob;
		IIterator gameIterator = this.go.getIterator();
		int missileCount = 0; 
		for (int i = 0; i < go.getSize(); i++) {
			while (gameIterator.hasNext()) {
				gob = gameIterator.getNext();
				if (gob instanceof Missile) {
					missileCount++;
				}
			}
		}
		System.out.println("Player Score: " + score);
		System.out.println("No. Missiles in Ship: " + missileCount);
		System.out.println("Elapsed Game Time: " + gameTime);
	}
	
	
	public void printMap() {
		System.out.println("\n" + go);
	}
	
	
	public void quit() {
		System.out.println("Quit button pushed");
		TextField myText = new TextField();
		Dialog.show("Are You Sure You Wish to Exit?", myText, new Command( "Enter" ) );
		String value = myText.getText();
		value = value.toUpperCase();
		
		if ( value.equals("Y") || value.equals("YES") ){
			System.exit(1);
			return;
		} else if ( value.equals("N") || value.equals("NO") ){
			return;
		} else {
			System.out.println( "Invalid response. Ignoring input." );
			return;
		}
	}
	
}
