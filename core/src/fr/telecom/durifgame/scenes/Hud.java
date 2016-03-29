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

import fr.telecom.durifgame.items.Inventory;
import fr.telecom.durifgame.player.Player;

public class Hud {

	public Stage stage;
	private Viewport viewport;
	
	private int vie;
	private Inventory inventory;
	private int score;
	
	private Label vieLabel;
	private Label inventoryLabel;
	private Label scoreLabel;
	
	public Hud(SpriteBatch spriteBatch, Player player) {

		vie = player.getLife();
		inventory = player.getInventory();
		score = player.getScore();
		
		viewport = new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), new OrthographicCamera());
		stage = new Stage(viewport, spriteBatch);
		

		Table table = new Table();
		table.bottom();
		table.setFillParent(true);
		
		vieLabel = new Label(String.format("%03d", vie), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
		inventoryLabel = new Label(inventory.toString(), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
		scoreLabel = new Label(String.format("%06d", score), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
		
		table.add(vieLabel).expandX().padBottom(10);
		table.add(scoreLabel).expandX().padBottom(10);
		
		stage.addActor(table);
		
	}
	
}
