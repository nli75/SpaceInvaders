package com.spaceinvaders;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Display;

public class SpaceInvadersActivity extends Activity {
    private static Intent gameFinish;
	public static Activity activity;
	/** Called when the activity is first created. */
	private Panel panel;
	private SensorManager sensormanager;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int screenWidht = size.x;
        int screenHeight = size.y;
        activity = this;
        panel = new Panel(this, screenWidht, screenHeight);
        setContentView(panel);
    }
    
    @Override
    public void onResume(){
    	super.onResume();
    	sensormanager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
    	sensormanager.registerListener(panel, sensormanager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), 
				SensorManager.SENSOR_DELAY_FASTEST);    	
    }
    
    @Override
    public void onStart(){
    	super.onStart();
    	SoundManager.INSTANCE.initSounds(this);
    	SoundManager.INSTANCE.loadSounds();
    }
    
    @Override
    public void onPause(){
    	super.onPause();
    	sensormanager.unregisterListener(panel);
    }
    
    public static void gameOver(){
    	Bundle message = new Bundle();
    	message.putString("string", "Game Over");
    	gameFinish = new Intent(activity, Welcome.class);
    	gameFinish.putExtras(message);
    	activity.startActivity(gameFinish);
    	activity.finish();//stäng denna activity eftersom vi går över
    }
    
    @Override
    public void onStop(){
    	super.onStop();
    	SoundManager.INSTANCE.clean();
    }
    
}