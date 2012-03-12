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

	public static Monster monster;
	public static Boss boss;
	public static Ship ship;
	public static LaserBeam laserBeam;
	public static Bitmap laserbeamBitmap;
	public static Bitmap monsterBitmap;
	public static Bitmap shipBitmap;
	public static Bitmap bossBitmap;
	public static int screenWidth;
	public static int screenHeight;
	public static Bitmap bg;
	private GameThread gameThread;

	public Panel(Context c, int screenWidht, int screenHeight) {
		super(c);
		getHolder().addCallback(this);
		Panel.screenWidth	= screenWidht;
		Panel.screenHeight	= screenHeight;
		
		Panel.bg				= BitmapFactory.decodeResource(getResources(), R.drawable.bg);
		Panel.monsterBitmap		= BitmapFactory.decodeResource(getResources(), R.drawable.monster);
		Panel.bossBitmap		= BitmapFactory.decodeResource(getResources(), R.drawable.boss);
		Panel.shipBitmap 		= BitmapFactory.decodeResource(getResources(), R.drawable.ship);
		Panel.laserbeamBitmap	= BitmapFactory.decodeResource(getResources(), R.drawable.laserbeam);
		
		populatePanel();
	}
	
	public static void populatePanel() {
		Panel.ship = new Ship(Panel.screenWidth/2, Panel.screenHeight-20, Panel.shipBitmap);
		makeMonsterRows(2);
	}
	
	public static void makeMonsterRows(int monsterRows) {

		boss = new Boss(-500, 80, bossBitmap);
		monsterRows = (monsterRows - 1) * 30 + 100;
		for (int yPos = 100; yPos <= monsterRows; yPos += 30) {
			for (int xPos = 140; xPos <= 290; xPos += 30) {
				monster = new Monster(xPos, yPos, monsterBitmap);
			}
		}

	}
	
	public static void resetPanel() {
		EntityManager.INSTANCE.getArrayListEntity().clear();
		EntityManager.INSTANCE.getArrayListMonsterLasers().clear();
		EntityManager.INSTANCE.getArrayListShipLasers().clear();
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		int eventX = (int) event.getX();
		int eventAction = event.getAction();
		
		switch(eventAction) {
			case MotionEvent.ACTION_MOVE:
				ship.setCenterX(eventX);
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
