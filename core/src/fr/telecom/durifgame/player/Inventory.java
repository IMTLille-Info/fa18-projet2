package fr.telecom.durifgame.player;

import fr.telecom.durifgame.Log;

public class Inventory {

	private static final int SIZE = 6;
	private String[] inventory;
	
	public Inventory() {
		inventory = new String[SIZE];
	}
	
	public void debugInventory() {
		for(int i = 0; i < SIZE; i++) {
			Log.logd(true, "Inventory", String.valueOf(i) + ":" + inventory[i].toString());
		}
	}
	
}
