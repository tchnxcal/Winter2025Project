package org.example;

public abstract class EnemyUnit extends AbstractUnit {
    public EnemyUnit(String name, int hp, int def, int spd, int level, int maxEnergy) {
        super(name, hp, def, spd, level, maxEnergy);
    }

    @Override
    public void performBasicAttack(AbstractUnit target) {
        int damage = (int)(equippedWeapon.getDamage() * 0.9); // 90% of ATK
        target.receiveDamage(damage);
        System.out.println(name + " uses Basic Attack for " + damage + " damage.");
    }

    @Override
    public abstract void takeTurn();
}

