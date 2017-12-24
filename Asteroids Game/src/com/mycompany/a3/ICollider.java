package com.mycompany.a3;

public interface ICollider {
	public boolean collidesWith(GameObject obj);
	public void handleCollision(GameObject obj, GameWorld gw);
}
