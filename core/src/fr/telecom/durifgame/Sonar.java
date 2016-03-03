package fr.telecom.durifgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

public class Sonar {
	
	private Boolean haveSonar;
	
	private final static float FAR = 0.1f;
	private final static float MIDDLE = 0.5f;
	private final static float CLOSE = 1f;
	private float distance;
	
	private Sound bip;
	private float difX;
	private float difY;

	public Sonar() {
		bip = Gdx.audio.newSound(Gdx.files.internal("bip1.wav"));
		distance = FAR;
	}
	
	public void setHaveSonar(Boolean have){
		this.haveSonar = have;
	}
	public boolean getHaveSonar(){
		return haveSonar;
	}
	public void playSonard(float distance){
		bip.play(distance,1,0);
	}
	
	public void setDif(float x , float y){
		this.difX = x;
		this.difY = y;
		checkDif();
	}
	
	private void checkDif(){
		
		Log.logd(true, "sonar", "X = "+difX+" Y = "+difY);
		if(difX > 5 || difY > 5){
			distance = FAR;
			//Log.logd(true, "sonar", "sup 5");
			playSonard(distance);
		}else if (difX > 1 || difY > 1){
			distance = MIDDLE;
			//Log.logd(true, "sonar", "sup 1");
			playSonard(distance);
		}else if(difX <= 1 || difY <= 1){
			distance = CLOSE;
			playSonard(distance);
			//Log.logd(true, "sonar", "else");
		}
		
		
		
	}
	

}
