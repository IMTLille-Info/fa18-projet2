package fr.telecom.durifgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import fr.telecom.durifgame.DurifGame.GameState;
import fr.telecom.durifgame.player.Player;
import fr.telecom.durifgame.scenes.Hud;
import fr.telecom.durifgame.utils.Camera;
import fr.telecom.durifgame.utils.KeyListener;
import fr.telecom.durifgame.utils.Log;
import fr.telecom.durifgame.utils.Map;
import fr.telecom.durifgame.utils.Music;

public class GameScreen implements Screen{

	private final static boolean DBG = false;
	private final static String TAG = GameScreen.class.getSimpleName();
	
	private Map map ;
    private Camera cam;
    private KeyListener kListener;
    private Player player;
    private Music music;
    private Hud hud;
    private Battle battle;
    private DurifGame game;
    
    
	public GameScreen(DurifGame game) {
	  this.game = game;
	  cam = new Camera();
      map = new Map("resources/map/durifmap.tmx");
      player = new Player("resources/sprites/soldier.png",cam);
      music = new Music("resources/sound/musicGame.ogg");
      kListener = new KeyListener(cam, map, player,music);
      hud = new Hud(player);
      battle = newBattle();
	}
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta) {
		if(game.gameState == GameState.PLAY){
			Gdx.gl.glClearColor(1, 0, 0, 1);
	        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
	        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	        
	        kListener.keyPressed();
	        if(player.checkPositionGold())
	        	player.newGold();
	        if(battle.startBattle(player.getPos())){
	        	music.stopMusic();
	        	game.changeScreen(DurifGame.START_BATTLE);
	        	battle = newBattle();
	        }
	        	
	        cam.update();
	        map.setView(cam);
	        map.render();
	        player.displayPlayer();
	        hud.displayHud();
		}
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		Log.logd(DBG, "gamesreen", "pause");
		music.stopMusic();
		game.gameState = GameState.PAUSE;
		
	}

	@Override
	public void resume() {
		Log.logd(true, TAG, "resume");
		music.playMusic();
		game.gameState = GameState.PLAY;
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub	
	}

	@Override
	public void dispose() {
    	if(map != null)
    		map.dispose();
    	if(music != null)
    		music.dispose();	
	}
	
	private Battle newBattle(){
		return new Battle((float)(Math.random()*10), (float)(Math.random()*10));
	}
}
