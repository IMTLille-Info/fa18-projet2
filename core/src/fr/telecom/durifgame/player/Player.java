package fr.telecom.durifgame.player;

import fr.telecom.durifgame.Position;

public class Player implements PlayerStates{

	private Position pos;
	private PlayerAnimation animation;
	
	public Player() {
		pos = new Position(0, 0);
		animation = new PlayerAnimation(state.STANDBY, direction.DOWN);
	}

	public PlayerAnimation getAnimation() {
		return animation;
	}

	public void setAnimation(PlayerAnimation animation) {
		this.animation = animation;
	}

}
