package org.example;

public interface CombatInterface {
    void performBasicAttack(AbstractUnit target);
    void takeTurn();
    void receiveDamage(int amount);
    boolean isAlive();
}
