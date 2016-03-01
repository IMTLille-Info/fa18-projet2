package fr.telecom.durifgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Input.Keys;

import fr.telecom.durifgame.player.Player;
import fr.telecom.durifgame.player.PlayerStates.*;

public class KeyListener implements InputProcessor {
	
	private Camera cam;
	private Map map;
	private Player player;
	private Music music;
	int test = 0;
	
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
		if(player.getState()==State.WALKING){
			if(player.getDir()==Direction.DOWN){		
				player.setDir(Direction.NO_DIR_DOWN);
				player.setState(State.STANDBY);
				
			}else if(player.getDir()==Direction.UP){		
				player.setDir(Direction.NO_DIR_UP);
				player.setState(State.STANDBY);
				
			}else if(player.getDir()==Direction.RIGHT){		
				player.setDir(Direction.NO_DIR_RIGHT);
				player.setState(State.STANDBY);
				
			}else if(player.getDir()==Direction.LEFT){		
				player.setDir(Direction.NO_DIR_LEFT);
				player.setState(State.STANDBY);	
			}
		}		
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
	
	//-----------------------------------------------//
    //-scrolled										 //
    //-----------------------------------------------//
	public void keyPressed(){
        if(Gdx.input.isKeyPressed(Keys.LEFT)) {
        	player.getPos().setPosX(player.getPos().getPosX()-Gdx.graphics.getDeltaTime()*(float)0);
        	cam.translate(-32,0);
         	player.setDir(Direction.LEFT);
         	player.setState(State.WALKING);
        	 }
        if(Gdx.input.isKeyPressed(Keys.RIGHT)) {
        	player.getPos().setPosX(player.getPos().getPosX()+Gdx.graphics.getDeltaTime()*(float)0);
        	cam.translate(32,0);
         	player.setDir(Direction.RIGHT);
         	player.setState(State.WALKING);
        	 }
        if(Gdx.input.isKeyPressed(Keys.UP)) {

        	player.getPos().setPosY(player.getPos().getPosY()-Gdx.graphics.getDeltaTime()*(float)0);
        	cam.translate(0,32);
         	player.setDir(Direction.UP);
         	player.setState(State.WALKING);
        	 }
        if(Gdx.input.isKeyPressed(Keys.DOWN)) {
        	player.getPos().setPosY(player.getPos().getPosY()-Gdx.graphics.getDeltaTime()*(float)0);
        	cam.translate(0,-32);
         	player.setDir(Direction.DOWN);
         	player.setState(State.WALKING);
        	 }
	}
	

}
