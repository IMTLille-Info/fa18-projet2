package fr.telecom.durifgame.player;

public interface PlayerStates {
	
	public enum State {
		STANDBY,
		WALKING,
		RUNNING
	}
	
	public enum Direction {
		NO_DIR_LEFT,
		NO_DIR_RIGHT,
		NO_DIR_UP,
		NO_DIR_DOWN,
		LEFT,
		RIGHT,
		UP,
		DOWN
	}

}
