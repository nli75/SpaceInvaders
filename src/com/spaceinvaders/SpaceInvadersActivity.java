package com.spaceinvaders;

import android.app.Activity;
import android.os.Bundle;
import android.view.Display;

public class SpaceInvadersActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       
        Display display = getWindowManager().getDefaultDisplay();
        int screenWidht = display.getWidth();
        int screenHeight = display.getHeight();
        
        Panel panel = new Panel(this, screenWidht, screenHeight);
        setContentView(panel);
    }
}