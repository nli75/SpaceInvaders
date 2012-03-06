package com.spaceinvaders;

import java.util.concurrent.CopyOnWriteArrayList;
import android.graphics.Canvas;

public class EntityManager {
	
	public static final EntityManager INSTANCE = new EntityManager();
	private CopyOnWriteArrayList<Entity> entities;
	
	public EntityManager() {
		this.entities = new CopyOnWriteArrayList<Entity>();
	}
	
	public CopyOnWriteArrayList<Entity> getArrayListEntity() {
		return entities;
	}
	
	public void addEntity(Entity entity) {
		this.entities.add(entity);
	}
	
	public void drawEntities(Canvas canvas) {
		for(Entity entity : this.entities) {
			entity.onDraw(canvas);
			entity.updatePosition();
			entity.updateAnimation();
		}
	}
}
