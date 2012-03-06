package com.spaceinvaders;

import android.graphics.Canvas;
import android.graphics.Rect;

public abstract class Entity {

	private int xPos;
	private int yPos;
	
	public Entity(int x, int y) {
		this.xPos = x;
		this.yPos = y;
		EntityManager.INSTANCE.addEntity(this);
	}
	
	public void movement(int deltaX, int deltaY) {
		setxPos(getxPos() + deltaX);
		setyPos(getyPos() + deltaY);
	}
	
	public Rect getDestRect() {
		return null;
	}
	
	public void updateAnimation() {
		
	}
	
	public void updatePosition() {
		
	}
	
	public void collision() {
		
	}
	
	public void directionRadian() {
		
	}
	
	public void onDraw(Canvas canvas) {
		
	}
	
	public int getxPos() {
		return xPos;
	}
	public void setxPos(int xPos) {
		this.xPos = xPos;
	}
	public int getyPos() {
		return yPos;
	}
	public void setyPos(int yPos) {
		this.yPos = yPos;
	}
	
}
