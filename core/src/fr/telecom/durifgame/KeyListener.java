package fr.telecom.durifgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;

import fr.telecom.durifgame.player.Player;
import fr.telecom.durifgame.player.PlayerStates.*;

public class KeyListener implements InputProcessor {
	
	private Camera cam;
	private Map map;
	private Player player;
	private Music music;
	
	//----------------------------------------------//
    //-KeyListener									//
    //-Constructeur									//
    //----------------------------------------------//
	public KeyListener(Camera camera , Map map ,Player player, Music music) {
		Gdx.input.setInputProcessor(this);
		this.cam = camera;
		this.map = map;
		this.player = player;
		this.music = music;

	}
	//-----------------------------------------------//
    //-keyDown										 //
    //-----------------------------------------------//
	@Override
	public boolean keyDown(int keycode) {
        if(keycode == Input.Keys.LEFT){
        	cam.translate(-32,0);
        	player.setDir(Direction.LEFT);
        	player.setState(State.WALKING);
        }  
        if(keycode == Input.Keys.RIGHT){
        	cam.translate(32,0);
        	player.setDir(Direction.RIGHT);
        	player.setState(State.WALKING);
        }
        if(keycode == Input.Keys.UP){
        	 cam.translate(0,32);
        	 player.setDir(Direction.UP);
        	 player.setState(State.WALKING);
        }
           
        if(keycode == Input.Keys.DOWN){
        	cam.translate(0,-32);
        	player.setDir(Direction.DOWN);
        	player.setState(State.WALKING);
        }
            
        if(keycode == Input.Keys.NUM_1)
            map.getLayers().get(0).setVisible(!map.getLayers().get(0).isVisible());
        if(keycode == Input.Keys.NUM_2)
            map.getLayers().get(1).setVisible(!map.getLayers().get(1).isVisible());
        
        if(keycode == Input.Keys.ESCAPE)
        	music.stopMusic();
        	
        if(keycode == Input.Keys.ENTER)
        	music.playMusic();
        
		return false;
	}

	//-----------------------------------------------//
    //-keyUp										 //
    //-----------------------------------------------//
	@Override
	public boolean keyUp(int keycode) {
		player.setDir(Direction.NO_DIR);
		player.setState(State.STANDBY);
        return false;
	}

	//-----------------------------------------------//
    //-keyTyped										 //
    //-----------------------------------------------//
	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}
	//-----------------------------------------------//
    //-touchDown									 //
    //-----------------------------------------------//
	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {

        return true;
	}
	//-----------------------------------------------//
    //-touchUp										 //
    //-----------------------------------------------//
	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}
	//-----------------------------------------------//
    //-touchDragged									 //
    //-----------------------------------------------//
	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}
	//-----------------------------------------------//
    //-mouseMoved									 //
    //-----------------------------------------------//
	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}
	//-----------------------------------------------//
    //-scrolled										 //
    //-----------------------------------------------//
	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
