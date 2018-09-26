package ch_01_StrategyPattern.rpg.weapons;

public class SwordBehavior implements WeaponBehavior {

	@Override
	public void useWeapon() {
		System.out.println("Sword in my hand");
	}

}
