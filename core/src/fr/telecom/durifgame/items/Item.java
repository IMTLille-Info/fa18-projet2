package fr.telecom.durifgame.items;

import fr.telecom.durifgame.items.itemDefinition.Arme;
import fr.telecom.durifgame.items.itemDefinition.Armure;
import fr.telecom.durifgame.items.itemDefinition.ItemType;
import fr.telecom.durifgame.items.itemDefinition.Loot;
import fr.telecom.durifgame.items.itemDefinition.Potion;

public class Item {
	
	private ItemType type;
	private Potion potion;
	private Arme arme;
	private Armure armure;
	private Loot loot;

	public Item() {
		
	}
	
	public String toString() {
		String chaine = "";
		
		switch(type) {
		
		case POTION:
			switch(potion) {
			case VIE: chaine = "potion de vie"; break;
			case MANA: chaine = "potion de mana"; break;
			case ENDURANCE: chaine = "potion d'endurance"; break;
			}
			
		case ARME:
			switch(arme) {
			case EPEE: chaine = "épée"; break;
			case BATON: chaine = "baton"; break;
			}
		
		case ARMURE:
			switch(armure) {
			case CASQUE: chaine = "casque"; break;
			case PLASTRON: chaine = "plastron"; break;
			case JAMBIERES: chaine = "jambieres"; break;
			case BOTTES: chaine = "bottes"; break;
			}
		
		case LOOT:
			switch(loot) {
			case POMME: chaine = "pomme"; break;
			case POIRE: chaine = "poire"; break;
			}
		}
		
		return chaine;
	}
	
}
