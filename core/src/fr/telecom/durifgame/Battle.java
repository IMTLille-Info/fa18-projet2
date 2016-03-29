package fr.telecom.durifgame;

import fr.telecom.durifgame.utils.Log;
import fr.telecom.durifgame.utils.Position;

public class Battle extends Position{
	
	
	
	public Battle(float x, float y) {
		super(x, y);
		Log.logd(false, "battlescreen", "x = "+x+" y= "+y);
	}
	
	protected boolean startBattle(Position posPlayer){
		Log.logd(false, "Battle", "difX = "+Math.abs(this.x - posPlayer.getX())+" difY = "+Math.abs(this.y - posPlayer.getY()));
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
