package fr.telecom.durifgame.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;

import fr.telecom.durifgame.player.Player;
import fr.telecom.durifgame.player.PlayerStates.Direction;
import fr.telecom.durifgame.player.PlayerStates.State;

public class KeyListener implements InputProcessor {

	private final static boolean DBG = false;
	private final static String TAG = KeyListener.class.getSimpleName();

	private Camera cam;
	private Map map;
	private Player player;
	private Music music;

	
	public KeyListener(Camera camera, Map map, Player player, Music music) {
		Gdx.input.setInputProcessor(this);
		this.cam = camera;
		this.map = map;
		this.player = player;
		this.music = music;

	}

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
		if (keycode == Input.Keys.B)
			map.getLayers().get(0).setVisible(!map.getLayers().get(0).isVisible());
		if (keycode == Input.Keys.N)
			map.getLayers().get(1).setVisible(!map.getLayers().get(1).isVisible());

		if (keycode == Input.Keys.ESCAPE)
			music.stopMusic();

		if (keycode == Input.Keys.ENTER)
			music.playMusic();

		return false;
	}

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
			//player.setSpeed(Player.STANDBY);
		} else if (player.getDir() == Direction.LEFT && keycode == Input.Keys.LEFT) {
			player.setDir(Direction.NO_DIR_LEFT);
			player.setState(State.STANDBY);
		}
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {

		return true;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

	public void keyPressed() {

		int speed = player.getSpeed();
		
		if (Gdx.input.isKeyPressed(Keys.LEFT)) {

			if((isCellBlocked(player.getPos().getX() - Gdx.graphics.getDeltaTime() * (float) 1,
					player.getPos().getY()))){
				player.setX((player.getPos().getX() - Gdx.graphics.getDeltaTime() * (float) 1));
				cam.translate(-speed, 0);
				player.setDir(Direction.LEFT);	
				player.detectState(speed);
			}else{
				player.setDir(Direction.LEFT);
				player.detectState(speed);
			}


		} else if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
			if((isCellBlocked(player.getPos().getX() + Gdx.graphics.getDeltaTime() * (float) 1
					, player.getPos().getY()))){
				player.setX((player.getPos().getX() + Gdx.graphics.getDeltaTime() * (float) 1));
				cam.translate(speed, 0);
				player.setDir(Direction.RIGHT);
				player.detectState(speed);
			}else{
				//Log.logd(true, TAG, "false");
				player.setDir(Direction.RIGHT);
				player.detectState(speed);
			}

		} else if (Gdx.input.isKeyPressed(Keys.UP)) {
			if((isCellBlocked(player.getPos().getX(),
					player.getPos().getY() + Gdx.graphics.getDeltaTime() * (float) 1))){
				player.setY((player.getPos().getY() + Gdx.graphics.getDeltaTime() * (float) 1));
				cam.translate(0, speed);
				player.setDir(Direction.UP);
				player.detectState(speed);
			}else{
				player.setDir(Direction.UP);
				player.detectState(speed);
			}

		} else if (Gdx.input.isKeyPressed(Keys.DOWN)) {
			if((isCellBlocked(player.getPos().getX(),
					player.getPos().getY() - Gdx.graphics.getDeltaTime() * (float) 1))){
				player.setY((player.getPos().getY() - Gdx.graphics.getDeltaTime() * (float) 1));
				cam.translate(0, -speed);
				player.setDir(Direction.DOWN);
				player.detectState(speed);
			}else{
				player.setDir(Direction.DOWN);
				player.detectState(speed);
			}

		}
		

	}
	
	private boolean isCellBlocked(float x, float y){
		
		Cell cell = null;
		TiledMapTileLayer collisionLayer = (TiledMapTileLayer) map.getLayers().get(5);
		try{
			cell = collisionLayer.getCell((int)(x / collisionLayer.getTileWidth()),
					(int)(y / collisionLayer.getTileHeight()));
		}catch(Exception e ){
			e.printStackTrace();
		}
		if(cell != null && cell.getTile() != null){
			//Log.logd(true, TAG, "properties "+cell.getTile().getProperties().getKeys().next());
			//Log.logd(true, TAG, "containsKey "+cell.getTile().getProperties().containsKey("blocked"));
			if(cell.getTile().getProperties().containsKey("blocked")){
				//Log.logd(true, TAG, "rentré dans if");
				return true;
			}
		}
		return false;
	}


}
