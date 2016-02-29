package fr.telecom.durifgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

public class Music {
	
	Sound sound;
	private boolean isPlay;
	
	public Music(String path){
		sound = Gdx.audio.newSound(Gdx.files.internal(path));
		isPlay = false;
	}

	protected void playMusic(){
		if(!isPlay){
			sound.loop();
			isPlay = true;
		}
		
	}
	protected void stopMusic(){
		if(isPlay){
			sound.stop();
			isPlay = false;
		}
		
	}
	
	protected void dispose(){
		sound.dispose();
	}
}
