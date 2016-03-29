package fr.telecom.durifgame.utils;

import com.badlogic.gdx.maps.MapLayers;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class Map {
	
	private TiledMapRenderer tiledMapRenderer;
	private TiledMap tiledMap;
	
	public Map(String path) {
		tiledMap = new TmxMapLoader().load(path);
		tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap);
	}
	
    public void setView(Camera camera){
    	tiledMapRenderer.setView(camera.getCamera());
    }
    
    public void render(){
    	tiledMapRenderer.render();
    }
    
    public void dispose(){
    	tiledMap.dispose();
    }
    
    public MapLayers getLayers(){
    	return tiledMap.getLayers();
    }
}
