package fr.telecom.durifgame.items;

import fr.telecom.durifgame.utils.Log;

public class Inventory {

	private static final int SIZE = 6;
	private Item[] inventory;
	
	public Inventory() {
		inventory = new Item[SIZE];
		for(int i = 0; i < SIZE; i++) {
			inventory[i] = new Item();
		}
	}
	
	public Item getItem(int i) {
		return inventory[i];
	}
	
	public void setItem(int i, Item item) {
		inventory[i] = item;
	}
	
	public String toString() {
		String strInventory = "";
		for(int i = 0; i < SIZE; i++) {
			Log.logd(false, "Inventory", String.valueOf(i) + ":" + inventory[i].toString());
			strInventory = ". " + inventory[i].toString() + " .";
		}
		return strInventory;
	}
	
}
