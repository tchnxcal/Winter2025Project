public abstract class Weapon implements Comparable<Weapon> {
    protected String name;
    protected int baseDamage;
    protected int level;

    public Weapon(String name, int baseDamage) {
        this.name = name;
        this.baseDamage = baseDamage;
        this.level = 1;
    }

    public int getDamage() {
        return baseDamage + (level - 1) * 2;
    }

    public void levelUp() {
        level++;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Weapon other) {
        return Integer.compare(this.getDamage(), other.getDamage());
    }

    @Override
    public String toString() {
        return name + " (DMG: " + getDamage() + ", Level: " + level + ")";
    }
}
