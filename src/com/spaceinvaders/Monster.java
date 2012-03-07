package com.spaceinvaders;

import android.graphics.Bitmap;

public class Monster extends EntityPic {
	
//	int x;
//	int y;
	int xMov = 2;
	int yMov = 0;
	int interval = 0;
	Bitmap bitmap;
	int frameTicker = 1+(int)(100*Math.random());
	int fps			= 100 + 1+(int)(30*Math.random());
	
	public Monster(int x, int y, Bitmap bitmap) {
		super(x,y, bitmap, 15, 2);
//		this.x = x;
//		this.y = y;
		this.bitmap = bitmap;
	}
	
	@Override
	public void collision() {
		ScoreManager.INSTANCE.addScore(1);
		EntityManager.INSTANCE.removeEntity(this);
		SoundManager.INSTANCE.playSound(2);
	}
	
	@Override
	public void updatePosition() {
		if (this.interval%70 == 0) {
			xMov *= -1;
			yMov = 10;
		}
		this.interval++;
		movement(xMov, yMov);
		yMov = 0;
		
		frameTicker++;
		if (frameTicker >= fps) {
			LaserBeam laser	= new LaserBeam(this.getCenterX(), this.getyPos()-10, Panel.laserbeamBitmap, this);
			laser.setYMov(5);
			EntityManager.INSTANCE.addMonsterLaser(laser);
			frameTicker = 0;
		}
		
		// Game restart
		if (this.getyPos()+this.getBitmapHeight() >= Panel.screenHeight) {
			Panel.resetPanel();
			Panel.populatePanel();
			ScoreManager.INSTANCE.clearScore();
			SoundManager.INSTANCE.playSound(3);
		}
	}

}
