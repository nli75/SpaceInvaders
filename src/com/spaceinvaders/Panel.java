package com.spaceinvaders;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class Panel extends SurfaceView implements SurfaceHolder.Callback {

	private Monster monster;
	private Ship ship;
	//private LaserBeam laserBeam;
	private static int screenWidth;
	private static int screenHeight;

	public Panel(Context c, int screenWidht, int screenHeight) {
		super(c);
		getHolder().addCallback(this);
		this.screenWidth	= screenWidht;
		this.screenHeight	= screenHeight;
		
		//Bitmap monsterBitmap		= BitmapFactory.decodeResource(getResources(), R.drawable.monster);
		//Bitmap shipBitmap 		= BitmapFactory.decodeResource(getResources(), R.drawable.ship);
		
	//	monster 		= new Monster(this.screenWidth /2, 50, monsterBitmap);
	//	ship			= new Ship(this.screenHeight, this.screenHeight -20, shipBitmap);
	}

	public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub
		
	}

	public void surfaceCreated(SurfaceHolder arg0) {
		// TODO Auto-generated method stub
		
	}

	public void surfaceDestroyed(SurfaceHolder arg0) {
		// TODO Auto-generated method stub
		
	}
	
	

}
