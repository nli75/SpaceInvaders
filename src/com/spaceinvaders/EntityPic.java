package com.spaceinvaders;

import android.graphics.Bitmap;
import android.graphics.Rect;

public abstract class EntityPic extends Entity {

	Bitmap bitmap;
	Rect rectangle;
	//kollision
	
	public EntityPic(int x, int y, Bitmap bitmap) {
		super(x, y);
		this.bitmap = bitmap;
		this.rectangle = new Rect(0, 0, getBitmapWidth(), getBitmapHeight());
	}

	private int getBitmapHeight() {
		return bitmap.getWidth();
	}

	private int getBitmapWidth() {
		return bitmap.getHeight();
	}

	
}
