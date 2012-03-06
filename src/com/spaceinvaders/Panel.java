package com.spaceinvaders;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class Panel extends SurfaceView implements SurfaceHolder.Callback, SensorEventListener {

	private Monster monster;
	private Ship ship;
	private LaserBeam laserBeam;
	private GameThread gameThread;
	public static int screenWidth;
	public static int screenHeight;
	public static int shipXPos;
	public static Bitmap bg;

	public Panel(Context c, int screenWidht, int screenHeight) {
		super(c);
		getHolder().addCallback(this);
		this.screenWidth	= screenWidht;
		this.screenHeight	= screenHeight;
		
		this.bg					= BitmapFactory.decodeResource(getResources(), R.drawable.bg);
		Bitmap monsterBitmap	= BitmapFactory.decodeResource(getResources(), R.drawable.monster);
		Bitmap shipBitmap 		= BitmapFactory.decodeResource(getResources(), R.drawable.ship);
		Bitmap laserbeamBitmap	= BitmapFactory.decodeResource(getResources(), R.drawable.laserbeam);
		int monsterXPos = 140;
		for (int i = 0; i <= 5; i++) {
			monster 	= new Monster(monsterXPos, 100, monsterBitmap);
			monsterXPos += 30;
		}
		
		ship			= new Ship(this.screenWidth/2, this.screenHeight-20, shipBitmap);
		Panel.shipXPos	= ship.getCenterX();
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
	
	public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
		
	}

	public void surfaceCreated(SurfaceHolder holder) {
		gameThread = new GameThread(getHolder());
		gameThread.setRunning(true);
		gameThread.start();
		
	}

	public void surfaceDestroyed(SurfaceHolder holder) {
		boolean retry = true;
		gameThread.setRunning(false);
		while(retry) {
			try {
				gameThread.join();
				retry = false;
			}
			catch(InterruptedException e) {
				
			}
		}
	}

	public void onAccuracyChanged(Sensor arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	public void onSensorChanged(SensorEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	

}
