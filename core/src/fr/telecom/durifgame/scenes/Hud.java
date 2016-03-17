package fr.telecom.durifgame.scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class Hud {

	private Viewport viewport;
	private SpriteBatch spriteBatch;
	public Stage stage;
	
	private Integer score;
	private Label scoreLabel;
	
	public Hud() {

		score = 200;
		
		viewport = new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), new OrthographicCamera());
		spriteBatch = new SpriteBatch();
		stage = new Stage(viewport, spriteBatch);
		
		scoreLabel = new Label(String.format("%06d", score), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
		
		Table table = new Table();
		table.top();
		table.setFillParent(true);
		
		table.add(scoreLabel).expandX();
		
		stage.addActor(table);
		
	}
	
	public void update() {
		spriteBatch.begin();
		spriteBatch.end();
	}
	
}
