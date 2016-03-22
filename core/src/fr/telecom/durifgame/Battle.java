package fr.telecom.durifgame;

public class Battle extends Position{
	
	
	
	public Battle(float x, float y) {
		super(x, y);
		Log.logd(true, "battlescreen", "x = "+x+" y= "+y);
	}
	
	protected boolean startBattle(Position posPlayer){
		Log.logd(true, "Battle", "difX = "+Math.abs(this.x - posPlayer.x)+" difY = "+Math.abs(this.y - posPlayer.y));
		if(Math.abs(this.x - posPlayer.x) < 0.5){
			if(Math.abs(this.y - posPlayer.y) < 0.5){
				return true;
			}else{
				return false;
			}	
		}else{
			return false;
		}
		
		
	}
	
	

}
