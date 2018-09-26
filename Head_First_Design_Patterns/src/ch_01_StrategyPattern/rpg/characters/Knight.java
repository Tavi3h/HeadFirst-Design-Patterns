package ch_01_StrategyPattern.rpg.characters;

import ch_01_StrategyPattern.rpg.weapons.WeaponBehavior;

public class Knight extends Characters {
	
	public Knight(WeaponBehavior weapon) {
		super(weapon);		
	}

	@Override
	public void fight() {
		weapon.useWeapon();		
	}

}
