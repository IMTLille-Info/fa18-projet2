package fr.telecom.durifgame.player;

public interface PlayerStates {
	
	public enum State {
		STANDBY,
		WALKING
	}
	
	public enum Direction {
		NO_DIR,
		LEFT,
		RIGHT,
		UP,
		DOWN
	}

}
