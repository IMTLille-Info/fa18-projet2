package fr.telecom.durifgame.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class PlayerAnimation implements PlayerStates {
	
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
	private Animation standBy;

    private static final int FRAME_COLS = 9;
    private static final int FRAME_ROWS = 4; 
    
    private Texture walkSheet;
    
	//----------------------------------------------//
    //-PlayerAnimation								//
    //-Constructeur									//
    //----------------------------------------------//
	public PlayerAnimation(State state, Direction direction,String path) {
		
		walkSheet = new Texture(Gdx.files.internal(path));
		
		TextureRegion[][] tmp = TextureRegion.split(walkSheet, walkSheet.getWidth()/FRAME_COLS, walkSheet.getHeight()/FRAME_ROWS);
		
		setAnimationArray();
        setAnimation(tmp);
	}
	
	//-----------------------------------------------//
    //-Animation									 //
    //-----------------------------------------------//
	public Animation getAnimation(Direction dir){
		
		switch (dir) {
		case DOWN:
			return walkDown;
		case UP:
			return walkUp;
		case LEFT:
			return walkLeft;
		case RIGHT:
			return walkRight;
		case NO_DIR:
			return standBy;
		default:
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
		
		
        for(int i=0;i<FRAME_COLS;i++){
        	walkUpAnim[i]=tmp[0][i];
        	walkDownAnim[i]=tmp[2][i];
        	walkLeftAnim[i]=tmp[1][i];
        	walkRightAnim[i]=tmp[3][i];
        }
        
        walkUp = new Animation(0.06f, walkUpAnim);
        walkDown = new Animation(0.06f, walkDownAnim); 
        walkRight = new Animation(0.06f, walkRightAnim); 
        walkLeft = new Animation(0.06f, walkLeftAnim); 
        standBy = new Animation(0.06f, standbyUpAnim); 	
	}
	
	//-----------------------------------------------//
    //-setAnimationArray							 //
    //-----------------------------------------------//
	private void setAnimationArray(){
        walkUpAnim = new TextureRegion[FRAME_COLS];
        walkDownAnim = new TextureRegion[FRAME_COLS];
        walkRightAnim = new TextureRegion[FRAME_COLS];
        walkLeftAnim = new TextureRegion[FRAME_COLS];
        
        standbyUpAnim = new TextureRegion[1];
        standbyDownAnim= new TextureRegion[1];
        standbyLeftAnim = new TextureRegion[1];
        standbyRightAnim= new TextureRegion[1];
		
	}
}
