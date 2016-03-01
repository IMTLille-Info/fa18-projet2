package fr.telecom.durifgame.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import fr.telecom.durifgame.Camera;
import fr.telecom.durifgame.Log;
import fr.telecom.durifgame.Position;

public class Player implements PlayerStates{
	
	private final static boolean DBG = true;
	private final static String TAG = Player.class.getSimpleName();


	private Position pos;
	private State state;
	private Direction dir;
	private PlayerAnimation animation;
	private Sprite sprite;
           
    
    private SpriteBatch spriteBatch;            
    private TextureRegion currentFrame;           
    
    private float stateTime;
    
    private Camera camera;
    
    private int speed;
	public static final int RUN = 5;
    public static final int WALK = 1;
    
    
	//----------------------------------------------//
    //-Player										//
    //-Constructeur									//
    //----------------------------------------------//
	public Player(String path,Camera camera) {
  
    	this.camera = camera;
    	
        spriteBatch = new SpriteBatch();               
        stateTime = 0f;                         
        setPos(new Position(100, 100));
        state = State.STANDBY;
        speed = WALK;
        dir = Direction.NO_DIR_RIGHT;
        animation = new PlayerAnimation(state, dir,path);
	}

	//-----------------------------------------------//
    //-displayPlayer								 //
    //-----------------------------------------------//
	public void displayPlayer(){

        stateTime += Gdx.graphics.getDeltaTime();
        try{
        	currentFrame = animation.getAnimation(dir,state).getKeyFrame(stateTime, true);  	
        }catch(Exception e){
        	e.printStackTrace();
        }
        
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
		//Log.logd(DBG, TAG, "setState = "+state.name());
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
	
	//----------------------------------------------//
    //-setSpeed									 	//
    //----------------------------------------------//
	public void setSpeed(int speed){
		Log.logd(DBG, TAG, "setSpeed = "+speed);
		this.speed=speed;	
	}
	//----------------------------------------------//
    //-setSpeed									 	//
    //----------------------------------------------//
    public int getSpeed() {
		return speed;
	}
}
