package com.spaceinvaders;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Welcome extends Activity {

	Button button;
	private Intent gameFinish;
	public static Activity activity;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
//		Log.v("in welcome", "not launching?");
		activity = this;
		setContentView(R.layout.main);
		button = (Button) findViewById(R.id.bPlay);
		button.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				gameFinish = new Intent(activity, SpaceInvadersActivity.class);
		    	activity.startActivity(gameFinish);
		    	activity.finish();//stäng denna activity eftersom vi går över
				Log.v("oncklick", "Load acitityt here");
				
			}
		});
	}
	
/**	public void start(){
		
		Log.v("Welcomeactivity", "just clicked");
		gameFinish = new Intent(this, SpaceInvadersActivity.class);
    	this.startActivity(gameFinish);
    	this.finish();//stäng denna activity eftersom vi går över
    	
	}*/
	

}