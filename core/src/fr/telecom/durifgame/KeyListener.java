package fr.telecom.durifgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Input.Keys;

import fr.telecom.durifgame.player.Player;
import fr.telecom.durifgame.player.PlayerStates.*;

public class KeyListener implements InputProcessor {

	private final static boolean DBG = false;
	private final static String TAG = KeyListener.class.getSimpleName();

	private Camera cam;
	private Map map;
	private Player player;
	private Music music;

	// ----------------------------------------------//
	// -KeyListener //
	// -Constructeur //
	// ----------------------------------------------//
	public KeyListener(Camera camera, Map map, Player player, Music music) {
		Gdx.input.setInputProcessor(this);
		this.cam = camera;
		this.map = map;
		this.player = player;
		this.music = music;

	}

	// -----------------------------------------------//
	// -keyDown //
	// -----------------------------------------------//
	@Override
	public boolean keyDown(int keycode) {

		if (keycode == Input.Keys.R) {
			player.setSpeed(Player.RUN);
			//Log.logd(DBG, TAG, "keyDown : RUNNING");
		}
		if (keycode == Input.Keys.W) {
			player.setSpeed(Player.WALK);
			//Log.logd(DBG, TAG, "keyDown : WALKING");
		}
		if (keycode == Input.Keys.NUM_1)
			map.getLayers().get(0).setVisible(!map.getLayers().get(0).isVisible());
		if (keycode == Input.Keys.NUM_2)
			map.getLayers().get(1).setVisible(!map.getLayers().get(1).isVisible());

		if (keycode == Input.Keys.ESCAPE)
			music.stopMusic();

		if (keycode == Input.Keys.ENTER)
			music.playMusic();

		return false;
	}

	// -----------------------------------------------//
	// -keyUp //
	// -----------------------------------------------//
	@Override
	public boolean keyUp(int keycode) {

		Log.logd(DBG, TAG, "keyUp");
		
		if (player.getDir() == Direction.DOWN && keycode == Input.Keys.DOWN ) {
			player.setDir(Direction.NO_DIR_DOWN);
			player.setState(State.STANDBY);

		} else if (player.getDir() == Direction.UP && keycode == Input.Keys.UP) {
			player.setDir(Direction.NO_DIR_UP);
			player.setState(State.STANDBY);

		} else if (player.getDir() == Direction.RIGHT && keycode == Input.Keys.RIGHT) {
			player.setDir(Direction.NO_DIR_RIGHT);
			player.setState(State.STANDBY);

		} else if (player.getDir() == Direction.LEFT && keycode == Input.Keys.LEFT) {
			player.setDir(Direction.NO_DIR_LEFT);
			player.setState(State.STANDBY);
		}
		return false;
	}

	// -----------------------------------------------//
	// -keyTyped //
	// -----------------------------------------------//
	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	// -----------------------------------------------//
	// -touchDown //
	// -----------------------------------------------//
	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {

		return true;
	}

	// -----------------------------------------------//
	// -touchUp //
	// -----------------------------------------------//
	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	// -----------------------------------------------//
	// -touchDragged //
	// -----------------------------------------------//
	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	// -----------------------------------------------//
	// -mouseMoved //
	// -----------------------------------------------//
	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	// -----------------------------------------------//
	// -scrolled //
	// -----------------------------------------------//
	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

	// -----------------------------------------------//
	// -keyPressed //
	// -----------------------------------------------//
	public void keyPressed() {

		int speed = player.getSpeed();
		
		if (Gdx.input.isKeyPressed(Keys.LEFT)) {
			player.setX((player.getPos().x() - Gdx.graphics.getDeltaTime() * (float) 1));
			cam.translate(-speed, 0);
			player.setDir(Direction.LEFT);	
			if(speed == Player.RUN){
				player.setState(State.RUNNING);
			}else if(speed == Player.WALK){
				player.setState(State.WALKING);
			}
		} else if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
			player.setX((player.getPos().x() + Gdx.graphics.getDeltaTime() * (float) 1));
			cam.translate(speed, 0);
			player.setDir(Direction.RIGHT);
			if(speed == Player.RUN){
				player.setState(State.RUNNING);
			}else if(speed == Player.WALK){
				player.setState(State.WALKING);
			}
		} else if (Gdx.input.isKeyPressed(Keys.UP)) {
			player.setY((player.getPos().y() + Gdx.graphics.getDeltaTime() * (float) 1));
			//Log.logd(true, TAG, "Gdx.graphics.getDeltaTime() * (float) 1)" + player.getPos().getPosX() + Gdx.graphics.getDeltaTime() * (float) 1);
			cam.translate(0, speed);
			player.setDir(Direction.UP);
			if(speed == Player.RUN){
				player.setState(State.RUNNING);
			}else if(speed == Player.WALK){
				player.setState(State.WALKING);
			}
		} else if (Gdx.input.isKeyPressed(Keys.DOWN)) {
			player.setY((player.getPos().y() - Gdx.graphics.getDeltaTime() * (float) 1));
			cam.translate(0, -speed);
			player.setDir(Direction.DOWN);
			if(speed == Player.RUN){
				player.setState(State.RUNNING);
			}else if(speed == Player.WALK){
				player.setState(State.WALKING);
			}
		}
	}


}
