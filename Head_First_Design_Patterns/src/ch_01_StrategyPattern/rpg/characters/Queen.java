package ch_01_StrategyPattern.rpg.characters;

import ch_01_StrategyPattern.rpg.weapons.WeaponBehavior;

public class Queen extends Characters {

	
	public Queen(WeaponBehavior weapon) {
		super(weapon);
	}

	@Override
	public void fight() {
		weapon.useWeapon();
	}

}
