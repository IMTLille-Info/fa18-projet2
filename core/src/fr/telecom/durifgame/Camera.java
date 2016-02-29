package fr.telecom.durifgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class Camera {
	float h;
	float w;
	
	private OrthographicCamera camera;
	
	//----------------------------------------------//
    //-Camera										//
    //-Constructeur									//
    //----------------------------------------------//
	public Camera(){
        w = Gdx.graphics.getWidth();
        h = Gdx.graphics.getHeight();
        
        camera = new OrthographicCamera();
        camera.setToOrtho(false,w,h);
        camera.update();
	}
	//-----------------------------------------------//
    //-update										 //
    //-----------------------------------------------//
	protected void update(){
		this.camera.update();
	}
	//-----------------------------------------------//
    //-getCamera									 //
    //-----------------------------------------------//
	public OrthographicCamera getCamera(){
		return this.camera;
	}
	//-----------------------------------------------//
    //-translate									 //
    //-----------------------------------------------//
	protected void translate(int x, int y){
		camera.translate(x,y);
	}	
	//-----------------------------------------------//
    //-getWidth										 //
    //-----------------------------------------------//
	public float getWidth(){
		return w;
	}
	//-----------------------------------------------//
    //-getHeight									 //
    //-----------------------------------------------//
	public float getHeight(){
		return h;
	}
	
}
