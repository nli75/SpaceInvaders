package com.spaceinvaders;

import com.spaceinvaders.Panel;
import android.graphics.Bitmap;

public class Monster extends EntityPic {
	
	int x;
	int y;
	int xMov = 0;
	int yMov = 0;
	Bitmap bitmap;
	
	public Monster(int x, int y, Bitmap bitmap){
		super(x,y, bitmap);
		this.x = x;
		this.y = y;
		this.bitmap = bitmap;
	}
	
	@Override
	public void updatePosition(){
		if(getCenterX() > Panel.screenWidth - 20){
			xMov = -2;
		}else if(getCenterX() < 20){
			xMov = 2;
		}
		movement(xMov, yMov);
	}

}
