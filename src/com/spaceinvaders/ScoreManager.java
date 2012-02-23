package com.spaceinvaders;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.spaceinvaders.Panel;

public class ScoreManager {
	
	public static final ScoreManager INSTANCE = new ScoreManager();
	private int score;
	
	Paint scorePaint = new Paint();
	
	private ScoreManager() {
		score = 0;
		scorePaint.setColor(Color.WHITE);
		scorePaint.setTextSize(45);
		scorePaint.setShadowLayer(5, 0, 0, Color.MAGENTA);
	}
	
	public void drawText(Canvas c, String text, int x, int y, Paint p) {
		c.drawText(text, x, y, p);
	}
	
	public void updateScore(Canvas c) {
		String scoreToDisplay = Integer.toString(score);
		drawText(c, scoreToDisplay, (Panel.screenWidth/2)-10, 40, scorePaint);
	}
	
	public void addScore(int amount) {
		score += amount;
	}

}
