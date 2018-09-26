package ch_01_StrategyPattern.rpg.weapons;

public class BowAndArrowBehavior implements WeaponBehavior {

	@Override
	public void useWeapon() {
		System.out.println("Use Bow and Arrow to fight");
	}

}
