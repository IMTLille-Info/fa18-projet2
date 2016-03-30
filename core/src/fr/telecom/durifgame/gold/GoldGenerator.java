package fr.telecom.durifgame.gold;

import fr.telecom.durifgame.utils.Log;
import fr.telecom.durifgame.utils.Position;

public class GoldGenerator extends Position {

	private enum Cost{GOLD,SILVER,BRONZE}
	
	private int value;
	private final static int GOLD_VALUE = 150;
	private final static int SILVER_VALUE = 100;
	private final static int BRONZE_VALUE = 50;
	
	private Cost cost;
	
	private final static boolean DBG = true;
	private final static String TAG = GoldGenerator.class.getSimpleName();
	
	public GoldGenerator(float posX, float posY) {
		super(posX, posY);
		double temp = Math.random();
		if(temp <= 0.333333)
			cost = Cost.GOLD;
		else if (temp <= 0.666666)
			cost = Cost.SILVER;
		else
			cost = Cost.BRONZE;
		Log.logd(DBG, TAG, "cost = "+cost);
		setValue();
		
	}
	
	public Cost getCost(){
		return this.cost;
	}
	
	public int getValue(){
		return value;
	}
	
	
	private void setValue(){
		switch(cost){
		case BRONZE:
			value = BRONZE_VALUE;
			break;
		case GOLD:
			value = GOLD_VALUE;
			break;
		case SILVER:
			value = SILVER_VALUE;
			break;
			
		}
		
	}
	
	
	
	

}
