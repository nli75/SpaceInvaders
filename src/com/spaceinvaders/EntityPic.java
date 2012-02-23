package com.spaceinvaders;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

public abstract class EntityPic extends Entity {

	private Bitmap bitmap;
	private Rect rectangle;
	
	public EntityPic(int x, int y, Bitmap bitmap) {
		super(x, y);
		this.bitmap = bitmap;
		this.rectangle = new Rect(0, 0, getBitmapWidth(), getBitmapHeight());
	}

	@Override
	public void onDraw(Canvas canvas){
		Rect destinationRect = new Rect(getxPos(), getyPos(), getxPos() + getBitmapWidth(), getyPos() + getBitmapHeight());
		canvas.drawBitmap(this.bitmap, this.rectangle, destinationRect, null);
	}
	
	public int getCenterX() {
		return getxPos() + getBitmapWidth()/2;
	}
	
	public void setCenterX(int x) {
		setxPos(x - getBitmapWidth()/2);
	}
	
	public int getBitmapWidth() {
		return bitmap.getWidth();
	}
	
	public int getBitmapHeight() {
		return bitmap.getHeight();
	}
}
