package fr.telecom.durifgame;

import com.badlogic.gdx.Game;

import fr.telecom.durifgame.GameScreen;



public class DurifGame extends Game {
	
	private final static boolean DBG = true;
	private final static String TAG = DurifGame.class.getSimpleName();
	
	protected final static int START_GAME = 1;

    MainScreen mainScreen;
    GameScreen gameScreen;
    
    
	//----------------------------------------------//
    //-create										//
    //-Constructeur									//
    //----------------------------------------------//
	@Override
	public void create () {
	
		mainScreen = new MainScreen(this);
		gameScreen = new GameScreen();
		setScreen(mainScreen);
	} 

	//-----------------------------------------------//
    //-render										 //
    //-----------------------------------------------//
	@Override
	public void render() {
		super.render();    
	}
	
	//-----------------------------------------------//
    //-dispose										 //
    //-----------------------------------------------//
    @Override
    public void dispose() {
    	super.dispose();
    }
    
    protected void changeScreen(int key){
    	switch(key){
    	case START_GAME:
    		setScreen(gameScreen);
    		break;
    	default:
    			Log.logd(DBG, TAG, "changeScreen invalid key = "+key);
    	}
    }
}
