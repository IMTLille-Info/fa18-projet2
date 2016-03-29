package fr.telecom.durifgame.player;

import fr.telecom.durifgame.Log;
import fr.telecom.durifgame.items.Item;

public class Inventory {

	private static final int SIZE = 6;
	private Item[] inventory;
	
	public Inventory() {
		inventory = new Item[SIZE];
		for(int i = 0; i < SIZE; i++) {
			inventory[i] = new Item();
		}
	}
	
	public void debugInventory() {
		for(int i = 0; i < SIZE; i++) {
			Log.logd(true, "Inventory", String.valueOf(i) + ":" + inventory[i].toString());
		}
	}
	
}
