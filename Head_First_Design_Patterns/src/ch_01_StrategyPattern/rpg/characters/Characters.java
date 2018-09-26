package ch_01_StrategyPattern.rpg.characters;

import ch_01_StrategyPattern.rpg.weapons.WeaponBehavior;

public abstract class Characters {
	
	protected WeaponBehavior weapon;
	
	public Characters(WeaponBehavior weapon) {
		this.weapon = weapon;
	}
	
	public void setWeapon(WeaponBehavior weapon) {
		this.weapon = weapon;
	}
	
	public abstract void fight();

}
