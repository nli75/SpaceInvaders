package com.spaceinvaders;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Welcome extends Activity {

	Button button;
	private Intent gameFinish;
	public static Activity activity;
	String string;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		activity = this;
		
		setContentView(R.layout.main);
		button = (Button) findViewById(R.id.bPlay);
		button.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				gameFinish = new Intent(activity, SpaceInvadersActivity.class);
		    	activity.startActivity(gameFinish);
		    	activity.finish();				
			}
		});	
	}
}