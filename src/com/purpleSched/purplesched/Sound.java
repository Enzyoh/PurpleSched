package com.purpleSched.purplesched;

import android.media.AudioManager;

public class Sound {
	AudioManager am;
	public Sound(AudioManager audioMan){
		am = audioMan;
	}
	public void silent(){
		am.setRingerMode(AudioManager.RINGER_MODE_SILENT);
	}
	public void normal(){
		am.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
	}
	public void vibrate(){
		am.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
	}
}
