package com.spaceinvaders;


import com.spaceinvaders.Panel;
import android.graphics.Bitmap;

public class Monster extends EntityPic {
	
	int x;
	int y;
	int xMov;
	int yMov;
	Bitmap bitmap;
	
	
	//rörelsemönster
	
	
	public Monster(int x, int y, Bitmap bitmap){
		super(x,y, bitmap);
		this.x = x;
		this.y = y;
		this.bitmap = bitmap;
		xMov = 3;
		yMov = 0;
		
	}
	@Override
	public void updatePosition(){
		
		
		if(getCenterX() > Panel.screenWidth -10){
			xMov = - 3;
		}else if(getCenterX() < 10){
			xMov = 3;
		}
		
		if (getyPos() <= 0){
		
			setxPos(Panel.screenWidth /2);
			
			
		}else if(getyPos() >= Panel.screenHeight){
			
			setxPos(Panel.screenWidth /2);
			
		}
		movement(xMov, yMov);
	}

}
