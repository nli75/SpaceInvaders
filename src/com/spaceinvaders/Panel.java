package com.spaceinvaders;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class Panel extends SurfaceView implements SurfaceHolder.Callback {

	private Monster monster;
	private Ship ship;
	private LaserBeam laserBeam;
	private GameThread gamethread;
	public static int screenWidth;
	public static int screenHeight;
	public static int shipXPos;

	public Panel(Context c, int screenWidht, int screenHeight) {
		super(c);
		getHolder().addCallback(this);
		this.screenWidth	= screenWidht;
		this.screenHeight	= screenHeight;
		
		Bitmap monsterBitmap	= BitmapFactory.decodeResource(getResources(), R.drawable.monster);
		Bitmap shipBitmap 		= BitmapFactory.decodeResource(getResources(), R.drawable.ship);
		Bitmap laserbeamBitmap	= BitmapFactory.decodeResource(getResources(), R.drawable.laserbeam);
		//monster 		= new Monster(this.screenWidth+50, 100, monsterBitmap);
		for (int i = 0; i <= 150; i+=30) {
			monster 	= new Monster(this.screenWidth+i, 100, monsterBitmap);
		}
		
		ship			= new Ship(this.screenWidth/2, this.screenHeight-20, shipBitmap);
		this.shipXPos	= ship.getCenterX();
		laserBeam		= new LaserBeam(this.screenWidth/2, this.screenHeight-20, laserbeamBitmap);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		int eventX = (int) event.getX();
		int eventAction = event.getAction();
		
		switch(eventAction) {
			case MotionEvent.ACTION_MOVE:
				ship.setCenterX(eventX);
				this.shipXPos = ship.getCenterX();
				break;
		}
		return true;
	}
	
	public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub
		
	}

	public void surfaceCreated(SurfaceHolder arg0) {
		gamethread = new GameThread(getHolder());
		gamethread.setRunning(true);
		gamethread.start();
		
	}

	public void surfaceDestroyed(SurfaceHolder arg0) {
		// TODO Auto-generated method stub
		
	}
	
	

}
