package com.spaceinvaders;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class Welcome extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		Log.v("in welcome", "not launching?");
		setContentView(R.drawable.laserbeam);
	}	
	

}