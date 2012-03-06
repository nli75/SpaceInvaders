package com.spaceinvaders;

import android.graphics.Bitmap;

public class Monster extends EntityPic {
	
	int x;
	int y;
	int xMov = 2;
	int yMov = 0;
	int interval = 0;
	Bitmap bitmap;
	
	public Monster(int x, int y, Bitmap bitmap) {
		super(x,y, bitmap, 1, 1);
		this.x = x;
		this.y = y;
		this.bitmap = bitmap;
	}
	
	@Override
	public void collision() {
		
	}
	
	@Override
	public void updatePosition() {
		if (this.interval%70 == 0) {
			xMov *= -1;
		}
		this.interval++;
		movement(xMov, yMov);
	}

}
