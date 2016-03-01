package fr.telecom.durifgame.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import fr.telecom.durifgame.Log;


public class PlayerAnimation implements PlayerStates {
	
	private final static boolean DBG = true;
	private final static String TAG = PlayerAnimation.class.getSimpleName();
	
	private TextureRegion[]	walkUpAnim;
	private TextureRegion[]	walkDownAnim;
	private TextureRegion[] walkLeftAnim;
	private TextureRegion[] walkRightAnim;
	private TextureRegion[] standbyUpAnim;
	private TextureRegion[] standbyDownAnim;
	private TextureRegion[] standbyLeftAnim;
	private TextureRegion[] standbyRightAnim;
	
	private Animation walkUp;
	private Animation walkDown;
	private Animation walkLeft;
	private Animation walkRight;
	
	private Animation standByUp;
	private Animation standByDown;
	private Animation standByLeft;
	private Animation standByRight;

    private static final int COL = 9;
    private static final int ROWS = 4; 
    
    private static final float FRAME_RUN = (float) 0.03;
    private static final float FRAME_WALK = (float) 0.06;
    
    
    private Texture walkSheet;
    
	//----------------------------------------------//
    //-PlayerAnimation								//
    //-Constructeur									//
    //----------------------------------------------//
	public PlayerAnimation(State state, Direction direction,String path) {
		
		walkSheet = new Texture(Gdx.files.internal(path));
		
		TextureRegion[][] tmp = TextureRegion.split(walkSheet, walkSheet.getWidth()/COL, walkSheet.getHeight()/ROWS);
		
		setAnimationArray();
        setAnimation(tmp);
	}
	
	//-----------------------------------------------//
    //-Animation									 //
    //-----------------------------------------------//
	public Animation getAnimation(Direction dir,State state){
		
		//Log.logd(DBG, TAG, "dir = "+dir.name()+" state = "+state.name());
		switch(state){
		case WALKING:
			switch (dir) {
			case DOWN:
				walkDown.setFrameDuration(FRAME_WALK);
				return walkDown;
			case UP:
				walkUp.setFrameDuration(FRAME_WALK);
				return walkUp;
			case LEFT:
				walkLeft.setFrameDuration(FRAME_WALK);
				return walkLeft;
			case RIGHT:
				walkRight.setFrameDuration(FRAME_WALK);
				return walkRight;
			default:
				break;
			}
			break;
		case RUNNING:
			switch (dir) {
			case DOWN:
				walkDown.setFrameDuration(FRAME_RUN);
				return walkDown;
			case UP:
				walkUp.setFrameDuration(FRAME_RUN);
				return walkUp;
			case LEFT:
				walkLeft.setFrameDuration(FRAME_RUN);
				return walkLeft;
			case RIGHT:
				walkRight.setFrameDuration(FRAME_RUN);
				return walkRight;
			default:
				break;
			}
			break;
		case STANDBY:
			switch (dir) {
			case NO_DIR_DOWN:
				return standByDown;
			case NO_DIR_LEFT:
				return standByLeft;
			case NO_DIR_RIGHT:
				return standByRight;
			case NO_DIR_UP:
				return standByUp;
			default:
				break;
			}		
			break;
		}
		return null;
	}
	
	//-----------------------------------------------//
    //-setAnimation									 //
    //-----------------------------------------------//
	private void setAnimation(TextureRegion[][] tmp){
		
		standbyUpAnim[0] = tmp[0][0];
		standbyDownAnim[0]  = tmp[2][0];
		standbyLeftAnim[0] = tmp[1][0];
		standbyRightAnim[0] = tmp[3][0];
		
        for(int i=0;i<COL;i++){
        	walkUpAnim[i]=tmp[0][i];
        	walkDownAnim[i]=tmp[2][i];
        	walkLeftAnim[i]=tmp[1][i];
        	walkRightAnim[i]=tmp[3][i];
        }
        
        walkUp = new Animation(0.06f, walkUpAnim);
        walkDown = new Animation(0.06f, walkDownAnim); 
        walkRight = new Animation(0.06f, walkRightAnim); 
        walkLeft = new Animation(0.06f, walkLeftAnim);
        
        standByUp = new Animation(0.06f, standbyUpAnim); 
        standByDown = new Animation(0.06f,standbyDownAnim);
        standByRight = new Animation(0.06f,standbyRightAnim);
        standByLeft = new Animation(0.06f,standbyLeftAnim);
	}
	
	//-----------------------------------------------//
    //-setAnimationArray							 //
    //-----------------------------------------------//
	private void setAnimationArray(){
        walkUpAnim = new TextureRegion[COL];
        walkDownAnim = new TextureRegion[COL];
        walkRightAnim = new TextureRegion[COL];
        walkLeftAnim = new TextureRegion[COL];
        
        standbyUpAnim = new TextureRegion[1];
        standbyDownAnim= new TextureRegion[1];
        standbyLeftAnim = new TextureRegion[1];
        standbyRightAnim= new TextureRegion[1];
		
	}
}
