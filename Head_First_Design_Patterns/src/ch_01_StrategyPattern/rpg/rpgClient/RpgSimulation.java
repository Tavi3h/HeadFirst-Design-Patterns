package ch_01_StrategyPattern.rpg.rpgClient;

import ch_01_StrategyPattern.rpg.characters.Characters;
import ch_01_StrategyPattern.rpg.characters.King;
import ch_01_StrategyPattern.rpg.weapons.AxeBehavior;
import ch_01_StrategyPattern.rpg.weapons.SwordBehavior;

public class RpgSimulation {
	
	public static void main(String[] args) {
		Characters king = new King(new SwordBehavior());
		king.fight();
		king.setWeapon(new AxeBehavior());
		king.fight();
		
	}

}
// output:
/*
Sword in my hand
Axe!!!
*/