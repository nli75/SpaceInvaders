package com.spaceinvaders;

import java.util.concurrent.CopyOnWriteArrayList;
import android.graphics.Rect;

public class CollisionManager {
	
	public static final CollisionManager INSTANCE = new CollisionManager();
	
	public CollisionManager() {
		
	}
	
	public boolean collision() {
		CopyOnWriteArrayList<Entity> entityArray		= EntityManager.INSTANCE.getArrayListEntity();
		CopyOnWriteArrayList<LaserBeam> shipLasers		= EntityManager.INSTANCE.getArrayListShipLasers();
		CopyOnWriteArrayList<LaserBeam> monsterLasers	= EntityManager.INSTANCE.getArrayListMonsterLasers();
		
		for (Entity entity : entityArray) {
			if (entity instanceof Monster) {
				for (LaserBeam laser : shipLasers) {
					if (Rect.intersects(entity.getDestRect(), laser.getDestRect())) {
						entity.collision();
						laser.collision();
						return true;
					}
				}
			}
			if (entity instanceof Ship) {
				for (LaserBeam laser : monsterLasers) {
					if (Rect.intersects(entity.getDestRect(), laser.getDestRect())) {
						entity.collision();
						laser.collision();
						return true;
					}
				}
			}
		}
		return false;
		
	}
}
