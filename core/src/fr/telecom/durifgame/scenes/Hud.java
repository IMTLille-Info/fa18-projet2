package fr.telecom.durifgame.scenes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

import fr.telecom.durifgame.items.Inventory;
import fr.telecom.durifgame.player.Player;

public class Hud {

	private Stage stage;
	private Player player;
	
	private int vie;
	private Inventory inventory;
	private int score;
	
	private Label vieLabel;
	private Label inventoryLabel;
	private Label scoreLabel;
	
	public Hud(Player player) {
		this.player = player;
	}
	
	public void displayHud() {
		
		vie = player.getLife();
		inventory = player.getInventory();
		score = player.getScore();		

		Table table = new Table();
		table.bottom();
		table.setFillParent(true);
		
		vieLabel = new Label(String.format("%03d", vie), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
		inventoryLabel = new Label(inventory.toString(), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
		scoreLabel = new Label(String.format("%06d", score), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
		
		table.add(vieLabel).expandX().padBottom(10);
		table.add(inventoryLabel).expandX().padBottom(10);
		table.add(scoreLabel).expandX().padBottom(10);
		
		stage = new Stage();
		stage.addActor(table);	
		
	}
	
}
