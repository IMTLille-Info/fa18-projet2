package fr.telecom.durifgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

public class Music {
	
	private Sound sound;
	private boolean isPlay;
	
	//----------------------------------------------//
    //-Music										//
    //-Constructeur									//
    //----------------------------------------------//
	public Music(String path){
		sound = Gdx.audio.newSound(Gdx.files.internal(path));
		isPlay = false;
	}
	//-----------------------------------------------//
    //-Animation									 //
    //-----------------------------------------------//
	protected void playMusic(){
		if(!isPlay){
			sound.loop();
			isPlay = true;
		}
	}
	//-----------------------------------------------//
    //-stopMusic									 //
    //-----------------------------------------------//
	protected void stopMusic(){
		if(isPlay){
			sound.stop();
			isPlay = false;
		}	
	}
	//-----------------------------------------------//
    //-dispose										 //
    //-----------------------------------------------//
	protected void dispose(){
		sound.dispose();
	}
}
