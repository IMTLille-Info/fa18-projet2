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

    private TextureRegion[] walkFrames;             
    
    private SpriteBatch spriteBatch;            
    private TextureRegion currentFrame;           
    
    private float stateTime;
    
    private Camera camera;
    
	//----------------------------------------------//
    //-Player										//
    //-Constructeur									//
    //----------------------------------------------//
	public Player(String path,Camera camera) {
  
    	this.camera = camera;
    	
        spriteBatch = new SpriteBatch();               
        stateTime = 0f;                         

        setPos(new Position(0, 0));
        setState(State.STANDBY);
        setDir(Direction.NO_DIR);
        setAnimation(new PlayerAnimation(getState(), getDir(),path));
	}

	//-----------------------------------------------//
    //-displayPlayer								 //
    //-----------------------------------------------//
	public void displayPlayer(){

        stateTime += Gdx.graphics.getDeltaTime();           
        currentFrame = animation.getAnimation(dir).getKeyFrame(stateTime, true);  
        spriteBatch.begin();
        spriteBatch.draw(currentFrame , camera.getWidth()/2 , camera.getHeight()/2);             
        spriteBatch.end();
        
	}
	//----------------------------------------------//
    //-getAnimation								 	//
    //----------------------------------------------//
	public PlayerAnimation getAnimation() {
		return animation;
	}
	
	//----------------------------------------------//
    //-setAnimation								 	//
    //----------------------------------------------//
	public void setAnimation(PlayerAnimation animation) {
		this.animation = animation;
	}
	//----------------------------------------------//
    //-getPos								 		//
    //----------------------------------------------//
	public Position getPos() {
		return pos;
	}
	//----------------------------------------------//
    //-setPos								 		//
    //----------------------------------------------//
	public void setPos(Position pos) {
		this.pos = pos;
	}
	//----------------------------------------------//
    //-getState								 		//
    //----------------------------------------------//
	public State getState() {
		return state;
	}
	//----------------------------------------------//
    //-setState								 		//
    //----------------------------------------------//
	public void setState(State state) {
		this.state = state;
	}
	//----------------------------------------------//
    //-getDir									 	//
    //----------------------------------------------//
	public Direction getDir() {
		return dir;
	}
	//----------------------------------------------//
    //-setDir								 		//
    //----------------------------------------------//
	public void setDir(Direction dir) {
		this.dir = dir;
	}
	//----------------------------------------------//
    //-getSprite								 	//
    //----------------------------------------------//
	public Sprite getSprite() {
		return sprite;
	}

}
