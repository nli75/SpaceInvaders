package com.spaceinvaders;

import android.graphics.Bitmap;
import android.util.Log;

public class LaserBeam extends EntityPic {

	private static final String TAG = null;
	private static final String TAG2 = null;
	int x;
	int y;
	int xMov = 0;
	int yMov = 0;
	Bitmap bitmap;
	Entity entity;
	
	public LaserBeam(int x, int y, Bitmap bitmap, Entity entity) {
		super(x, y, bitmap, 1, 1);
		this.x = x;
		this.y = y;
		this.bitmap = bitmap;
		this.entity = entity;
	}
	
	@Override
	public void collision() {
		EntityManager.INSTANCE.removeEntity(this);
		EntityManager.INSTANCE.removeShipLaser(this);
	}
	
	@Override
	public void updatePosition() {
		movement(xMov, yMov);
		if (this.getyPos()+this.getBitmapHeight() <= 0 || this.getyPos() >= Panel.screenHeight) {
			if (EntityManager.INSTANCE.getArrayListShipLasers().contains(this)) {
				EntityManager.INSTANCE.removeShipLaser(this);	
			}
			if (EntityManager.INSTANCE.getArrayListMonsterLasers().contains(this)) {
				EntityManager.INSTANCE.removeMonsterLaser(this);
			}		
		}
	}
	
	public void setYMov(int i) {
		this.yMov = i;
	}

}
