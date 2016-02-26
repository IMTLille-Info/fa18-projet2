package fr.telecom.durifgame;

import com.badlogic.gdx.graphics.OrthographicCamera;
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
	
    protected void setView(OrthographicCamera camera){
    	tiledMapRenderer.setView(camera);
    }
    
    protected void render(){
    	tiledMapRenderer.render();
    }
    
    protected void dispose(){
    	tiledMap.dispose();
    }
    
    protected MapLayers getLayers(){
    	return tiledMap.getLayers();
    }
}
