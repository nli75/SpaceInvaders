package com.spaceinvaders;

import com.spaceinvaders.ScoreManager;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.SurfaceHolder;

public class GameThread extends Thread {
	
	SurfaceHolder surfaceHolder;
	private boolean running;
	private final int MAX_FPS = 50;
	private final int FRAME_PERIOD = 1000 / MAX_FPS;

	public GameThread(SurfaceHolder holder) {
		super();
		this.surfaceHolder = holder;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}
	
	public void run() {
		Canvas canvas;
		long beginTime;
		long timeDiff = 20;
		int sleepTime;
		int MAX_FRAMES_SKIPPED = 5;
		int FRAMES_SKIPPED = 0;
		
		while(this.running) {
			canvas = null;
		
			try {
				canvas = this.surfaceHolder.lockCanvas(null);
				synchronized (surfaceHolder) {
					beginTime = System.currentTimeMillis();
					
				    canvas.drawColor(Color.BLACK);
				    canvas.drawBitmap(Panel.bg, 10, 10, null);
					EntityManager.INSTANCE.drawEntities(canvas);
					CollisionManager.INSTANCE.collision();
					ScoreManager.INSTANCE.updateScore(canvas);
					
					timeDiff = System.currentTimeMillis() - beginTime;
					sleepTime = (int)(FRAME_PERIOD - timeDiff);
					while (sleepTime <= 0 && FRAMES_SKIPPED < MAX_FRAMES_SKIPPED) {
						sleepTime += FRAME_PERIOD;
						FRAMES_SKIPPED++;
					}
				}
			}
			finally {
				if(canvas != null) {
					surfaceHolder.unlockCanvasAndPost(canvas);
				}
			}
		}
	}

}
