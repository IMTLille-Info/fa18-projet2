package fr.telecom.durifgame.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import fr.telecom.durifgame.Camera;
import fr.telecom.durifgame.Gold;
import fr.telecom.durifgame.Log;
import fr.telecom.durifgame.Position;
import fr.telecom.durifgame.Sonar;

public class Player implements PlayerStates{
	
	private final static boolean DBG = false;
	private final static String TAG = Player.class.getSimpleName();


	protected Position pos;
	private State state;
	private Direction dir;
	private PlayerAnimation animation;
	private Sprite sprite;
	private Sonar sonar;
           
    private int money;
	
    private SpriteBatch spriteBatch;            
    private TextureRegion currentFrame;           
    
    private float stateTime;
    
    private Camera camera;
    
    private int speed;
	public static final int RUN = 5;
    public static final int WALK = 1;
    private static final double DELTA = 0.5;
    
    int temp = 0;
    
    Inventory inventory;
    Gold gold;
    
    
	//----------------------------------------------//
    //-Player										//
    //-Constructeur									//
    //----------------------------------------------//
	public Player(String path,Camera camera) {
  
    	this.camera = camera;
    	
        spriteBatch = new SpriteBatch();               
        stateTime = 0f;                         
        setPos(new Position(0, 0));
        state = State.STANDBY;
        speed = WALK;
        dir = Direction.NO_DIR_RIGHT;
        animation = new PlayerAnimation(state, dir,path);
        inventory = new Inventory();
        inventory.debugInventory();
        newGold();
        sonar = new Sonar();
        money = 0;
        Log.logd(true, TAG, "GOLD    X = "+gold.getPosX()+" Y = "+gold.getPosY());
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
		//Log.logd(true, TAG,"X = "+pos.getPosX()+" Y = "+pos.getPosY());
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
	//----------------------------------------------//
    //-setX										 	//
    //----------------------------------------------//
    public void setX(float x){
    	//Log.logd(true, TAG, "x "+x);
    	pos.setPosX(x);
    	//Log.logd(true, TAG, "x after "+pos.getPosX());
    }
	//----------------------------------------------//
    //-setY										 	//
    //----------------------------------------------//
    public void setY(float y){
    	pos.setPosY(y);
    }
    
	//----------------------------------------------//
    //-checkPosition							 	//
    //----------------------------------------------/
    public boolean checkPosition(){
    	
    	//Log.logd(true, TAG, " GOLD ::X = "+gold.getPosX()+" Y = "+gold.getPosY());
    	
    	float x = Math.abs(gold.getPosX()-pos.getPosX());
    	
    	float y = Math.abs(gold.getPosY()-pos.getPosY());
    	
    	if(sonar != null){
    		sonar.setDif(x, y);
    	}
    	//Log.logd(true, TAG, "checkPosition :: x "+x+" y "+y);
    	
    	if(x<=DELTA){
    		if(y<=DELTA){
    			temp++;
    			money += gold.getValue();
    			Log.logd(true, TAG, "money = "+money);
    			if(temp>2)
    				sonar = null;
    			return true;
    		}
    			
    			
    	}
    	
    	return false;
    }
    
    public void newGold(){
    	gold = new Gold((float)(Math.random()*10), (float)(Math.random()*10));
    }
}
