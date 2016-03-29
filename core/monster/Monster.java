
public abstract class Monster {

	protected static int LIFE;
	protected static int SPEED;
	protected static int POWER;
	
	protected int currentLife;

	protected int currentPower;
	protected int currentSpeed;
	protected int life;
	
	public Monster() {
		
	}
	
	protected void hurt(int power){
		currentLife -= power;
	}

	protected int attack(){ 
		return currentPower;
	}
	
	protected boolean isAlive(){
		if(currentLife <= 0)
			return true;
		else 
			return false;
	}
	
	
	
	
	public int getCurrentLife() {
		return currentLife;
	}

	public int getCurrentPower() {
		return currentPower;
	}

	public int getCurrentSpeed() {
		return currentSpeed;
	}
}

