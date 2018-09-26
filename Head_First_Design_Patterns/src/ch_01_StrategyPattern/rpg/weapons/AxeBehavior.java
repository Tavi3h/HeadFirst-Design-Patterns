package ch_01_StrategyPattern.rpg.weapons;

public class AxeBehavior implements WeaponBehavior {

	@Override
	public void useWeapon() {
		System.out.println("Axe!!!");
	}

}
