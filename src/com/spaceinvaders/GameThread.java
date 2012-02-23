package com.spaceinvaders;

import android.graphics.Canvas;
import android.graphics.Color;
import android.view.SurfaceHolder;

public class GameThread extends Thread {
	
	SurfaceHolder surfaceholder;
	private boolean running;

	public GameThread(SurfaceHolder holder) {
		super();
		this.surfaceholder = holder;
	}

	public void setRunning(boolean running){
		this.running = running;
	}
	
	public void run(){
		Canvas canvas;
		
		while(this.running){
			canvas = null;
			
			try{
				canvas = this.surfaceholder.lockCanvas(null);
				synchronized(surfaceholder){
					
					//SKRIV IN ALLT SOM SKA HÄNDA FRÅN INSTANCE
					canvas.drawColor(Color.BLACK);
					
				}
			}finally{
				if(canvas!=null){
					surfaceholder.unlockCanvasAndPost(canvas);
				}
			}
		}
		
	}

}
