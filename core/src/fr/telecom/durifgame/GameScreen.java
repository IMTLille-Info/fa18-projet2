package fr.telecom.durifgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;

import fr.telecom.durifgame.Camera;
import fr.telecom.durifgame.KeyListener;
import fr.telecom.durifgame.Map;
import fr.telecom.durifgame.Music;
import fr.telecom.durifgame.player.Player;
import fr.telecom.durifgame.scenes.Hud;

public class GameScreen implements Screen{

	private Map map ;
    private Camera cam;
    private KeyListener kListener;
    private Player player;
    private Music music;
    private Hud hud;
    
    
	public GameScreen() {
	  cam = new Camera();
      map = new Map("exemple.tmx");
      player = new Player("soldier.png",cam);
      music = new Music("lost-in-the-meadows.ogg");
      kListener = new KeyListener(cam, map, player,music);
      hud = new Hud();
	}
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        kListener.keyPressed();
        if(player.checkPosition()){
        	player.newGold();
        }
        cam.update();
        map.setView(cam);
        map.render();
        player.displayPlayer();
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
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
		
}
