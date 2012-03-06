package com.spaceinvaders;

import java.util.concurrent.CopyOnWriteArrayList;
import android.graphics.Rect;
import android.util.Log;

public class CollisionManager {
	
	public static final CollisionManager INSTANCE = new CollisionManager();
	private String TAG = getClass().getSimpleName().toString();
	
	private LaserBeam laser;
	//private CopyOnWriteArrayList<LaserBeam> lasers;
	
	public CollisionManager() {
		
	}
	
	public boolean collision() {
		CopyOnWriteArrayList<Entity> entityArray = EntityManager.INSTANCE.getArrayListEntity();
		
		for (Entity entity : entityArray) {
			if (entity instanceof LaserBeam) {
				this.laser = (LaserBeam) entity;
			}
		}
		
		for (Entity entity : entityArray) {
			if (!entity.equals(this.laser) && !(entity instanceof Ship)) {
				if (Rect.intersects(this.laser.getDestRect(), entity.getDestRect())) {
					this.laser.collision();
					entity.collision();
					return true;
				}
			}
		}
		return false;
		
//		for (Entity entity1 : entityArray) {
//			for (Entity entity2 : entityArray) {
//				if (!entity1.equals(entity2)) {
//					if (Rect.intersects(entity1.getDestRect(), entity2.getDestRect())) {
//						entity1.collision();
//						entity2.collision();
//						return true;
//					}
//				}
//			}
//		}
//		return false;
	}
}
