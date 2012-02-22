package com.spaceinvaders;

public abstract class Entity {

	private int xPos;
	private int yPos;
	
	public Entity(int x, int y){
		this.setxPos(x);
		this.setyPos(y);
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
