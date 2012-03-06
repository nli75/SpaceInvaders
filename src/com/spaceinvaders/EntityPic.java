package com.spaceinvaders;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

public abstract class EntityPic extends Entity {

	private Bitmap bitmap;
	private Rect sourceRect;
	private Rect destinationRect;
	private int fps;
	private int frameCount;
	private int currentFrame;
	private long frameTicker;
	
	public EntityPic(int x, int y, Bitmap bitmap, int fps, int frameCount) {
		super(x, y);
		this.bitmap 		= bitmap;
		this.fps 			= fps;
		this.frameCount		= frameCount;
		this.frameTicker 	= 1;
		this.currentFrame 	= 0;
		sourceRect = new Rect(0, 0, getBitmapWidth(), getBitmapHeight());
	}
	
	@Override
	public void updateAnimation() {
		currentFrame++;
		if (currentFrame >= frameCount) {
			currentFrame = 0;
		}
		this.sourceRect.left	= currentFrame * getBitmapWidth();
		this.sourceRect.right	= this.sourceRect.left + getBitmapWidth();
	}

	@Override
	public void onDraw(Canvas canvas){
		destinationRect = new Rect(getxPos(), getyPos(), getxPos() + getBitmapWidth(), getyPos() + getBitmapHeight());
		canvas.drawBitmap(this.bitmap, this.sourceRect, destinationRect, null);
	}
	
	@Override
	public Rect getDestRect() {
		return destinationRect;
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
