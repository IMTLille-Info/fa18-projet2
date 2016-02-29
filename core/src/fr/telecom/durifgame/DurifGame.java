package fr.telecom.durifgame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import fr.telecom.durifgame.player.Player;

public class DurifGame extends ApplicationAdapter {
	
	SpriteBatch batch;
	Texture img;
	
    private Map map ;
    private Camera cam;
    private KeyListener kListener;
    private BitmapFont font;
    private Player player;
    private Music music;
    
	public Music getMusic() {
		return music;
	}

	@Override
	public void create () {

		cam = new Camera();
        map = new Map("exemple.tmx");
        player = new Player("soldier.png",cam);
        music = new Music("lost-in-the-meadows.ogg");
        kListener = new KeyListener(cam, map, player,music);
        
	}

	@Override
	public void render () {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        cam.update();
        map.setView(cam.getCamera());
        map.render();
        player.displayPlayer();
	}
	
    
    @Override
    public void dispose() {
    	if(batch != null)
    		batch.dispose();
    	if(font != null)
    		font.dispose();
    	if(map != null)
    		map.dispose();
    	if(music != null)
    		music.dispose();
    	
    }
}
