package fr.telecom.durifgame;

public class Position {

	protected float x;
	protected float y;
	
	public Position(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public float x() {
		return x;
	}

	public void setPosX(float x) {
		this.x = x;
	}

	public float y() {
		return y;
	}

	public void setPosY(float y) {
		this.y = y;
	}
	
}
