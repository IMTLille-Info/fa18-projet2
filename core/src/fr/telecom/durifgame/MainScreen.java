package fr.telecom.durifgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MainScreen  implements Screen{
	
	DurifGame durifGame;

	Sprite sprite;
	Texture texture;
	SpriteBatch spriteBatch;
	SpriteBatch batch;
	BitmapFont font;
	
	
	
	public MainScreen(DurifGame game) {
		this.durifGame = game;
	}

	@Override
	public void show() {
		font = new BitmapFont();
		font.setColor(Color.RED);
		spriteBatch = new SpriteBatch();
		texture = new Texture("durifMain.jpg");
		sprite = new Sprite(texture);
		sprite.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		
	}

	@Override
	public void render(float delta) {
		
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
		spriteBatch.begin();
		
		sprite.draw(spriteBatch);
		font.draw(spriteBatch, "Press ENTER to start game", Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2);
		spriteBatch.end();
		
		
		if(Gdx.input.isKeyPressed(Keys.ENTER)){
			durifGame.changeScreen(DurifGame.START_GAME);
		}
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
