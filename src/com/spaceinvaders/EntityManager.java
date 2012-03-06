package com.spaceinvaders;

import java.util.concurrent.CopyOnWriteArrayList;
import android.graphics.Canvas;

public class EntityManager {
	
	public static final EntityManager INSTANCE = new EntityManager();
	private CopyOnWriteArrayList<Entity> entities;
	private CopyOnWriteArrayList<LaserBeam> shipLasers;
	private CopyOnWriteArrayList<LaserBeam> monsterLasers;
	
	public EntityManager() {
		this.entities = new CopyOnWriteArrayList<Entity>();
		this.shipLasers = new CopyOnWriteArrayList<LaserBeam>();
		this.monsterLasers = new CopyOnWriteArrayList<LaserBeam>();
	}
	
	public CopyOnWriteArrayList<Entity> getArrayListEntity() {
		return entities;
	}
	
	public CopyOnWriteArrayList<LaserBeam> getArrayListShipLasers() {
		return shipLasers;
	}
	
	public CopyOnWriteArrayList<LaserBeam> getArrayListMonsterLasers() {
		return monsterLasers;
	}
	
	public void addEntity(Entity entity) {
		this.entities.add(entity);
	}
	
	public void removeEntity(Entity entity) {
		this.entities.remove(entity);
	}
	
	public void addShipLaser(LaserBeam laser) {
		this.shipLasers.add(laser);
	}
	
	public void removeShipLaser(LaserBeam laser) {
		this.shipLasers.remove(laser);
	}
	
	public void addMonsterLaser(LaserBeam laser) {
		this.monsterLasers.add(laser);
	}
	
	public void removeMonsterLaser(LaserBeam laser) {
		this.monsterLasers.remove(laser);
	}
	
	public void drawEntities(Canvas canvas) {
		for(Entity entity : this.entities) {
			entity.onDraw(canvas);
			entity.updatePosition();
			entity.updateAnimation();
		}
	}
	
}