package ch_01_StrategyPattern.rpg.weapons;

public class KnifeBehavior implements WeaponBehavior {

	@Override
	public void useWeapon() {
		System.out.println("fight with a knife");
	}

}
