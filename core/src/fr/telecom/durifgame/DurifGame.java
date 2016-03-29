package fr.telecom.durifgame;

import com.badlogic.gdx.Game;

import fr.telecom.durifgame.GameScreen;
import fr.telecom.durifgame.utils.Log;



public class DurifGame extends Game {
	
	private final static boolean DBG = true;
	private final static String TAG = DurifGame.class.getSimpleName();
	
	protected final static int START_GAME = 1;
	protected final static int START_BATTLE = 2;
	protected final static int RESTART_GAME = 3;
	
	protected enum GameState{PLAY,PAUSE};
	
	protected GameState gameState;

    MainScreen mainScreen;
    GameScreen gameScreen;
    BattleScreen BattleScreen;
    
    
	@Override
	public void create () {
	
		mainScreen = new MainScreen(this);
		setScreen(mainScreen);
		gameState = GameState.PLAY;
	}
	
    protected void changeScreen(int key){
    	switch(key){
    	case START_GAME:
    		gameScreen = new GameScreen(this);
    		setScreen(gameScreen);
    		break;
    	case START_BATTLE:
    		BattleScreen = new BattleScreen(this);
    		setScreen(BattleScreen);
    		break;
    	case RESTART_GAME:
    		setScreen(gameScreen);
    	default:
    			Log.logd(DBG, TAG, "changeScreen invalid key = "+key);
    	}
    }
}
