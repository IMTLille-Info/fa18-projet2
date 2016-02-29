package fr.telecom.durifgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class Camera {
	float h;
	float w;
	private OrthographicCamera camera;
	
	public Camera(){
		
        w = Gdx.graphics.getWidth();
        h = Gdx.graphics.getHeight();
        
        camera = new OrthographicCamera();
        camera.setToOrtho(false,w,h);
        camera.update();
        
       
        
	}
	
	protected void update(){
		this.camera.update();
	}
	
	public OrthographicCamera getCamera(){
		return this.camera;
	}
	
	protected void translate(int x, int y){
		camera.translate(x,y);
	}
	public float getWidth(){
		return w;
	}
	public float getHeight(){
		return h;
	}
	
}
