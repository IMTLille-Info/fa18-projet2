package fr.telecom.durifgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class BattleScreen implements Screen {

	Sprite sprite;
	Sprite soldierSprite;
	Sprite monsterSprite;
	Texture soldierTexture;
	Texture monsterTexture;
	Texture texture;
	SpriteBatch spriteBatch;
	SpriteBatch batch;
	BitmapFont font;
	DurifGame game;
	//Battle battle;
	private Music sound;
	
	public BattleScreen(DurifGame game) {
		this.game = game;
		sound = new Music("resources/sound/battleSound.ogg");
		sound.playMusic();
		
	}
	
	@Override
	public void show() {
		spriteBatch = new SpriteBatch();
		texture = new Texture(Gdx.files.internal("resources/background/battle.png"));
		soldierTexture = new Texture(Gdx.files.internal("resources/battle/hero.png"));
		monsterTexture = new Texture(Gdx.files.internal("resources/battle/gobelin.png"));
		sprite = new Sprite(texture);
		monsterSprite = new Sprite(monsterTexture);
		soldierSprite = new Sprite(soldierTexture,Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2);
		sprite.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		
	}

	@Override
	public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
		spriteBatch.begin();
		sprite.draw(spriteBatch);
		monsterSprite.draw(spriteBatch);
		soldierSprite.draw(spriteBatch);
		spriteBatch.end();
		
		if(Gdx.input.isKeyPressed(Keys.ESCAPE)){
			game.changeScreen(game.RESTART_GAME);
			sound.stopMusic();
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
