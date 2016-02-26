package fr.telecom.durifgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector3;



public class KeyListener implements InputProcessor {
	
	private Camera cam;
	private Map map;
	private Sprite sprite;
	

    
    
	public KeyListener(Camera camera , Map map ,Sprite sprite) {
		Gdx.input.setInputProcessor(this);
		this.cam = camera;
		this.map = map;
		this.sprite = sprite;

	}

	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
        if(keycode == Input.Keys.LEFT)
            cam.translate(-32,0);
        if(keycode == Input.Keys.RIGHT)
            cam.translate(32,0);
        if(keycode == Input.Keys.UP)
            cam.translate(0,-32);
        if(keycode == Input.Keys.DOWN)
            cam.translate(0,32);
        if(keycode == Input.Keys.NUM_1)
            map.getLayers().get(0).setVisible(!map.getLayers().get(0).isVisible());
        if(keycode == Input.Keys.NUM_2)
            map.getLayers().get(1).setVisible(!map.getLayers().get(1).isVisible());
        if(keycode == Input.Keys.ESCAPE)
        	map.dispose();
        return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		
        Vector3 clickCoordinates = new Vector3(screenX,screenY,0);
        Vector3 position = cam.getCamera().unproject(clickCoordinates);
        sprite.setPosition(position.x, position.y);
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

}
