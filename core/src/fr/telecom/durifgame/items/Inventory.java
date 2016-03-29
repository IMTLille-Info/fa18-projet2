package fr.telecom.durifgame.items;

import fr.telecom.durifgame.items.itemDefinition.ItemType;
import fr.telecom.durifgame.player.Player;
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
		return inventory[i-1];
	}
	
	public void addItem(Item item) {
		int i = 0;
		boolean itemAdded = false;
		while(!itemAdded && i < SIZE) {
			if(inventory[i].getType() == ItemType.VIDE) {
				inventory[i] = item;
				itemAdded = true;
			}
			i++;
		}
	}
	
	public void removeItem(int i) {
		inventory[i-1] = new Item();
	}
	
	public void useItem(Player player, int i) {
		switch(inventory[i-1].getType()) {
		case POTION:
			switch(inventory[i-1].getPotion()) {
			case VIE: player.addLife(25);break;
			case MANA: break;
			case ENDURANCE: break;
			}
			removeItem(i);
			break;
			
		case LOOT:
			switch(inventory[i-1].getLoot()) {
			case POMME: player.addLife(10);break;
			case POIRE: break;
			}
			removeItem(i);
			break;
		}
	}
	
	public String toString() {
		String strInventory = "";
		for(int i = 0; i < SIZE; i++) {
			Log.logd(false, "Inventory", String.valueOf(i) + ":" + inventory[i].toString());
			strInventory += ". " + inventory[i].toString() + " .";
		}
		return strInventory;
	}
	
}
