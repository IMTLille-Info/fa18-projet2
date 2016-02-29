package fr.telecom.durifgame.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import fr.telecom.durifgame.Camera;
import fr.telecom.durifgame.Position;

public class Player implements PlayerStates{

	private Position pos;
	private State state;
	private Direction dir;
	private PlayerAnimation animation;
	private Sprite sprite;

    TextureRegion[] walkFrames;             
    
    SpriteBatch spriteBatch;            
    TextureRegion currentFrame;           
    
    float stateTime;
    
    Camera camera;
    
	
	public Player(String path,Camera camera) {
  
    	this.camera = camera;
    	
        spriteBatch = new SpriteBatch();               
        stateTime = 0f;                         

        setPos(new Position(0, 0));
        setState(State.STANDBY);
        setDir(Direction.NO_DIR);
        setAnimation(new PlayerAnimation(getState(), getDir(),path));
	}

	public void displayPlayer(){

        stateTime += Gdx.graphics.getDeltaTime();           
        currentFrame = animation.getAnimation(dir).getKeyFrame(stateTime, true);  
        spriteBatch.begin();
        spriteBatch.draw(currentFrame , camera.getWidth()/2 , camera.getHeight()/2);             
        spriteBatch.end();
        
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
