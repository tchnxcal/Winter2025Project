package org.example;

public class StandardEnemy extends EnemyUnit {
    public StandardEnemy(int level) {
        super("Standard Enemy", level);
    }

    @Override
    public void takeTurn() {
        // TODO: Implement enemy turn logic
    }

    @Override
    public void performBasicAttack(AbstractUnit target) {
        // TODO: Attack logic
    }
}
