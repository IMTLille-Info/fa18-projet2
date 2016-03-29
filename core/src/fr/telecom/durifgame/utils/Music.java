package fr.telecom.durifgame.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

public class Music {
	
	protected Sound sound;
	private boolean isPlay;
	
	public Music(String path){
		sound = Gdx.audio.newSound(Gdx.files.internal(path));
		isPlay = false;
	}

	public void playMusic(){
		if(!isPlay){
			sound.loop();
			isPlay = true;
		}
	}

	public void stopMusic(){
		if(isPlay){
			sound.stop();
			isPlay = false;
		}	
	}

	public void dispose(){
		sound.dispose();
	}
}
