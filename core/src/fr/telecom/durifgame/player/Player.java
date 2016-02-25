package fr.telecom.durifgame.player;

import fr.telecom.durifgame.Position;

public class Player implements PlayerStates{

	private Position pos;
	private State state;
	private Direction dir;
	private PlayerAnimation animation;
	
	public Player() {
		setPos(new Position(0, 0));
		setState(State.STANDBY);
		setDir(Direction.DOWN);
		setAnimation(new PlayerAnimation(getState(), getDir()));
	}

	public PlayerAnimation getAnimation() {
		return animation;
	}

	public void setAnimation(PlayerAnimation animation) {
		this.animation = animation;
	}
	
	public Position getPos() {
		return pos;
	}

	public void setPos(Position pos) {
		this.pos = pos;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Direction getDir() {
		return dir;
	}

	public void setDir(Direction dir) {
		this.dir = dir;
	}

}
