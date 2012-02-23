package com.spaceinvaders;

import java.util.ArrayList;

import android.graphics.Canvas;

public class EntityManager {
	
	public static final EntityManager INSTANCE = new EntityManager();
	
	private ArrayList<Entity> entities;
	
	public EntityManager(){
		this.entities = new ArrayList<Entity>();
	}
	
	public void addEntity(Entity entity){
		this.entities.add(entity);
	}
	
	public void drawEntity(Canvas canvas){
		for(Entity entity : this.entities){
			entity.onDraw(canvas);
			entity.updatePosition();
		}
	}
	

}
