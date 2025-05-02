package org.example;

public class PlayerUnit extends AbstractUnit {
    public PlayerUnit(String name, int hp, int def, int spd, int level, int maxEnergy) {
        super(name, hp, def, spd, level, maxEnergy);
    }

    @Override
    public void performBasicAttack(AbstractUnit target) {
        int damage = equippedWeapon.getDamage();
        target.receiveDamage(damage);
        sp = Math.min(4, sp + 1); // Max 4 SP
        energy = Math.min(maxEnergy, energy + 10);
        System.out.println(name + " performs Basic Attack for " + damage + " damage!");
    }

    @Override
    public void takeTurn() {
        // TODO: Add menu input logic for skill/ultimate
        System.out.println(name + " is taking their turn...");
    }
}
