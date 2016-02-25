package fr.telecom.durifgame;

public class Player implements PlayerStates{

	private float posX; 
	private float posY;
	
	private PlayerAnimation animation;
	
	public Player() {
		animation = new PlayerAnimation(state.STANDBY, direction.DOWN);
	}
	
	public float getPosX() {
		return posX;
	}

	public void setPosX(float posX) {
		this.posX = posX;
	}

	public float getPosY() {
		return posY;
	}

	public void setPosY(float posY) {
		this.posY = posY;
	}

	public PlayerAnimation getAnimation() {
		return animation;
	}

	public void setAnimation(PlayerAnimation animation) {
		this.animation = animation;
	}

}
