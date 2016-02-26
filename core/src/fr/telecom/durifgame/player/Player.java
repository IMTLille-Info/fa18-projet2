package fr.telecom.durifgame.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import fr.telecom.durifgame.Position;
import fr.telecom.durifgame.*;

public class Player implements PlayerStates{

	private Position pos;
	private State state;
	private Direction dir;
	private PlayerAnimation animation;
	private SpriteBatch sb;
	private Texture texture;
	private Sprite sprite;

	private Camera cam;
	
	public Player(String path, Camera cam) {
		
		sb = new SpriteBatch();
        texture = new Texture(Gdx.files.internal(path));
        sprite = new Sprite(texture);
        
        this.cam = cam;
        
		setPos(new Position(0, 0));
		setState(State.STANDBY);
		setDir(Direction.DOWN);
		setAnimation(new PlayerAnimation(getState(), getDir()));
	}

	public void displayPlayer(){
		
        sb.setProjectionMatrix(cam.getCamera().combined);
        sb.begin();
        sprite.draw(sb);
        sb.end();
        
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
	
	public Sprite getSprite() {
		return sprite;
	}

}
