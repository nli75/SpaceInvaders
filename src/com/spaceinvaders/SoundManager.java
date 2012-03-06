package com.spaceinvaders;


import java.util.HashMap;

import org.apache.commons.logging.Log;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

public class SoundManager {
	
	SoundPool soundPool;
	HashMap<Integer, Integer> soundPoolMap;
	AudioManager audioManager;
	Context context;

	public static SoundManager INSTANCE = new SoundManager();
	
	public SoundManager(){
		
	}
	
	public void initSounds(Context context){
		this.context = context;
		soundPool = new SoundPool(4, AudioManager.STREAM_MUSIC, 0);
		soundPoolMap = new HashMap<Integer, Integer>();
		audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
	}
	
	public void loadSounds(){
		soundPoolMap.put(1, soundPool.load(context, R.raw.ufo_laser, 1));
		soundPoolMap.put(2, soundPool.load(context, R.raw.screem, 1));
		
		
	}
	
	public void playSound(int index){
		float streamVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
		streamVolume = streamVolume / audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
		soundPool.play(soundPoolMap.get(index), streamVolume, streamVolume, 1, 0, 1);
	}
	
	public void clean(){
		soundPool.release();
		soundPoolMap.clear();
		audioManager.unloadSoundEffects();
	}

}

