package fr.telecom.durifgame.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import fr.telecom.durifgame.Sonar;
import fr.telecom.durifgame.gold.Gold;
import fr.telecom.durifgame.items.Inventory;
import fr.telecom.durifgame.utils.Camera;
import fr.telecom.durifgame.utils.Log;
import fr.telecom.durifgame.utils.Position;

public class Player implements PlayerStates{
	
	private final static boolean DBG = true;
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
    
    private int life;
    private int score;

	private int speed;
	public static final int RUN = 5;
    public static final int WALK = 1;
    public static final int STANDBY = 0; 
    private static final double DELTA = 0.5;
    
    int temp = 0;
    
    private Inventory inventory;
	Gold gold;
    
    
	public Player(String path,Camera camera) {
  
    	this.camera = camera;
    	
        spriteBatch = new SpriteBatch();               
        stateTime = 0f;                         
        setPos(new Position(0, 0));
        score = 200;
        life = 68;
        state = State.STANDBY;
        speed = STANDBY;
        dir = Direction.NO_DIR_RIGHT;
        animation = new PlayerAnimation(state, dir,path);
        inventory = new Inventory();
        inventory.toString();
        newGold();
        sonar = new Sonar();
        money = 0;
        Log.logd(true, TAG, "GOLD    X = "+gold.getX()+" Y = "+gold.getY());
	}

	public void displayPlayer(){
		Log.logd(DBG, TAG, "POMME");
        stateTime += Gdx.graphics.getDeltaTime();
     
        try{
        	Log.logd(DBG, TAG, "PWAR");
        	Log.logd(DBG, TAG, "dir = "+dir.name()+" state = "+state.name());
        	currentFrame = animation.getAnimation(dir,state).getKeyFrame(stateTime, true);  
        	Log.logd(DBG, TAG, "PAISH");
        }catch(Exception e){
        	e.printStackTrace();
        }
      
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
		//Log.logd(true, TAG,"X = "+pos.getPosX()+" Y = "+pos.getPosY());
		return pos;
	}
	
	public void setPos(Position pos) {
		this.pos = pos;
	}
	
	public State getState() {
		return state;
	}
	
	public void setState(State state) {
		//Log.logd(DBG, TAG, "setState = "+state.name());
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
	
	public void setSpeed(int speed){
		Log.logd(DBG, TAG, "setSpeed = "+speed);
		this.speed=speed;	
	}
	
    public int getSpeed() {
		return speed;
	}
    
    public void setX(float x){
    	//Log.logd(true, TAG, "x "+x);
    	pos.setPosX(x);
    	//Log.logd(true, TAG, "x after "+pos.getPosX());
    }
    
    public void setY(float y){
    	pos.setPosY(y);
    }
    
	public Inventory getInventory() {
		return inventory;
	}
	
    public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
    
    public boolean checkPositionGold(){
    	
    	//Log.logd(true, TAG, " GOLD ::X = "+gold.getPosX()+" Y = "+gold.getPosY());
    	
    	float x = Math.abs(gold.getX()-pos.getX());
    	float y = Math.abs(gold.getY()-pos.getY());
    	
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
    
    public void detectState(int speed) {
    	if(RUN == speed) {
    		state = State.RUNNING;
    	} else if (WALK == speed) {
    		state = State.WALKING;
    	} else if (STANDBY == speed) {
    		state = State.STANDBY;
    	}
    }
}
