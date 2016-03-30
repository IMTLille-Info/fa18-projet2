package fr.telecom.durifgame.gold;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

import fr.telecom.durifgame.player.Player;
import fr.telecom.durifgame.utils.Log;

public class GoldDetector {
	
	private final static boolean DBG = true;
	private final static String TAG = Player.class.getSimpleName();
	
	private Boolean haveSonar;
	
	private final static float FAR = 0.1f;
	private final static float MIDDLE = 0.5f;
	private final static float CLOSE = 1f;
	private float distance;
	
	private Sound bip;
	private float difX;
	private float difY;
	
	private int nbBoucle = 0;

	public GoldDetector() {
		bip = Gdx.audio.newSound(Gdx.files.internal("resources/sound/bip1.wav"));
		distance = FAR;
	}
	
	public void setHaveSonar(Boolean have){
		this.haveSonar = have;
	}
	public boolean getHaveSonar(){
		return haveSonar;
	}
	public void playSonard(float distance){
		nbBoucle++;
		if(nbBoucle > 50){
			bip.play(distance,1,0);
			nbBoucle = 0;
		}
	}
	
	public void setDif(float x , float y){
		this.difX = x;
		this.difY = y;
		checkDif();
	}
	
	private void checkDif(){
		//LOG A ACTIV2 POUR CHERCHER OR
		Log.logd(DBG, TAG , "X = "+difX+" Y = "+difY);
		if(difX > 5 || difY > 5){
			distance = FAR;
			//Log.logd(DBG, TAG, "sup 5");
			playSonard(distance);
		}else if (difX > 1 || difY > 1){
			distance = MIDDLE;
			//Log.logd(DBG, TAG, "sup 1");
			playSonard(distance);
		}else if(difX <= 1 || difY <= 1){
			distance = CLOSE;
			playSonard(distance);
			//Log.logd(DBG, TAG, "else");
		}
		
		
		
	}
	

}
