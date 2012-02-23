package com.spaceinvaders;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

public abstract class EntityPic extends Entity {

	Bitmap bitmap;
	Rect rectangle;
	//kollision
	
	public EntityPic(int x, int y, Bitmap bitmap) {
		super(x, y);
		this.bitmap = bitmap;
	}
	
	public int getBitmapWidth(){
		return this.bitmap.getWidth();
	}
	
	public int getBitmapHeight(){
		return this.bitmap.getHeight();
	}

	//Rita ut på skärmen
	@Override
	public void onDraw(Canvas canvas){
		Rect destinationRect = new Rect(getxPos(), getyPos(), getxPos() + getBitmapWidth(), getyPos() + getBitmapHeight());
		canvas.drawBitmap(this.bitmap, rectangle, destinationRect, null);
	}
	
	public void updateAnimation(){
		
	}
}
