package fr.telecom.durifgame.items;

public interface itemDefinition {
	
	public enum ItemType {
		POTION,
		ARME,
		ARMURE,
		LOOT
	}
	
	public enum Potion {
		VIE,
		MANA,
		ENDURANCE
	}
	
	public enum Arme {
		EPEE,
		BATON
	}
	
	public enum Armure {
		CASQUE,
		PLASTRON,
		JAMBIERES,
		BOTTES
	}
	
	public enum Loot {
		POMME,
		POIRE
	}

}
