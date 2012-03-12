package com.spaceinvaders;

import android.graphics.Bitmap;

public class Boss extends EntityPic {

	int xMov = 2;
	int yMov = 0;
	Bitmap bitmap;
	int frameTicker = 1+(int)(100*Math.random());
	int fps			= 100 + 1+(int)(30*Math.random());
	
	public Boss(int x, int y, Bitmap bitmap) {
		super(x,y, bitmap, 1, 1);
		this.bitmap = bitmap;
	}
	
	@Override
	public void collision() {
		ScoreManager.INSTANCE.addScore(10);
		EntityManager.INSTANCE.removeEntity(this);
		SoundManager.INSTANCE.playSound(2);
	}
	
	@Override
	public void updatePosition() {
		if (this.getxPos() + this.getBitmapWidth() >= Panel.screenWidth) {
			xMov *= -1;
		}
		if(this.getxPos() <= 0){
			xMov *= -1;
		}
		movement(xMov, yMov);
		frameTicker++;
		if (frameTicker >= fps) {
			LaserBeam laser	= new LaserBeam(this.getCenterX(), this.getyPos()-10, Panel.laserbeamBitmap, this);
			laser.setYMov(5);
			EntityManager.INSTANCE.addMonsterLaser(laser);
			frameTicker = 0;
		}
		
	}
}
