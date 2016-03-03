package fr.telecom.durifgame;

public class Gold extends Position {

	private enum Cost{GOLD,SILVER,BRONZE}
	
	private int value;
	private final static int GOLD_VALUE = 150;
	private final static int SILVER_VALUE = 100;
	private final static int BRONZE_VALUE = 50;
	
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
