package fr.telecom.durifgame;

import com.badlogic.gdx.maps.MapLayers;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class Map {
	
	private TiledMapRenderer tiledMapRenderer;
	private TiledMap tiledMap;
	
	//----------------------------------------------//
    //-Map											//
    //-Constructeur									//
    //----------------------------------------------//
	public Map(String path) {
		tiledMap = new TmxMapLoader().load(path);
		tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap);
	}
	//-----------------------------------------------//
    //-setView										 //
    //-----------------------------------------------//
    protected void setView(Camera camera){
    	tiledMapRenderer.setView(camera.getCamera());
    }
	//-----------------------------------------------//
    //-render										 //
    //-----------------------------------------------//
    protected void render(){
    	tiledMapRenderer.render();
    }
	//-----------------------------------------------//
    //-dispose										 //
    //-----------------------------------------------//
    protected void dispose(){
    	tiledMap.dispose();
    }
	//-----------------------------------------------//
    //-getLayers									 //
    //-----------------------------------------------//
    protected MapLayers getLayers(){
    	return tiledMap.getLayers();
    }
}
