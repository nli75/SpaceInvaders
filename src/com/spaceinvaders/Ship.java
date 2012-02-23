package com.spaceinvaders;

import com.spaceinvaders.Panel;
import android.graphics.Bitmap;

public class Ship extends EntityPic {
	
	int x;
	int y;
	int xMov;
	int yMov;
	Bitmap bitmap;

	public Ship(int x, int y, Bitmap bitmap) {
		super(x, y, bitmap);
		this.x = x;
		this.y = y;
		xMov = 3;
		yMov = 3;
		this.bitmap = bitmap;
	}
	
	@Override
	public void updatePosition() {
		if(getCenterX() > Panel.screenWidth) {
			xMov = -3;
		}
		else if(getCenterX() < 0) {
			xMov = 3;
		}
		
		if(getyPos() <= 0) {
			setyPos(Panel.screenHeight/2);
			setxPos(Panel.screenWidth/2);
			yMov *= -1;
		}
		else if(getyPos() >= Panel.screenHeight) {
			setyPos(Panel.screenHeight/2);
			setxPos(Panel.screenWidth/2);
			yMov *= -1;
		}
		movement(xMov, yMov);
	}

}
