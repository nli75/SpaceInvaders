package com.spaceinvaders;

import android.graphics.Bitmap;

public class LaserBeam extends EntityPic {

	int x;
	int y;
	int xMov = 0;
	int yMov = -8;
	Bitmap bitmap;
	
	public LaserBeam(int x, int y, Bitmap bitmap) {
		super(x, y, bitmap, 1, 1);
		this.x = x;
		this.y = y;
		this.bitmap = bitmap;
	}
	
	@Override
	public void collision() {
		setxPos(Panel.shipXPos);
		setyPos(Panel.screenHeight-20);
		ScoreManager.INSTANCE.addScore(1);
	}
	
	@Override
	public void updatePosition(){
		if (getyPos() < 0) {
			setxPos(Panel.shipXPos);
			setyPos(Panel.screenHeight-20);
		}
		movement(xMov, yMov);
	}

}
