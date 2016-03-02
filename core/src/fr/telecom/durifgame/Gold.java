package fr.telecom.durifgame;

public class Gold extends Position {

	private enum Cost{GOLD,SILVER,BRONZE}
	private Cost cost;
	
	private final static boolean DBG = true;
	private final static String TAG = Gold.class.getSimpleName();
	
	public Gold(float posX, float posY) {
		super(posX, posY);
		double temp = Math.random();
		//cost = Cost.GOLD;
		if(temp <= 0.333333)
			cost = Cost.GOLD;
		else if (temp <= 0.666666)
			cost = Cost.SILVER;
		else
			cost = Cost.BRONZE;
		Log.logd(DBG, TAG, "temp ="+temp+"cost = "+cost);	
	}
	
	public Cost getCost(){
		return this.cost;
	}
	
	
	
	

}
