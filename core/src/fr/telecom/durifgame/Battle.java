package fr.telecom.durifgame;

import fr.telecom.durifgame.utils.Log;
import fr.telecom.durifgame.utils.Position;

public class Battle extends Position{
	
	private final static boolean DBG = false;
	private final static String TAG = Battle.class.getSimpleName();
	
	
	public Battle(float x, float y) {
		super(x, y);
		Log.logd(DBG, TAG, "x = "+x+" y= "+y);
	}
	
	protected boolean startBattle(Position posPlayer){
		//Log.logd(DBG, TAG, "difX = "+Math.abs(this.x - posPlayer.getX())+" difY = "+Math.abs(this.y - posPlayer.getY()));
		if(Math.abs(this.x - posPlayer.getX()) < 0.5){
			if(Math.abs(this.y - posPlayer.getY()) < 0.5){
				return true;
			}else{
				return false;
			}	
		}else{
			return false;
		}
		
		
	}
	
	

}
