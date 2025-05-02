import java.util.Comparator;
import java.util.Objects;

public abstract class Weapon implements Comparable<Weapon> {
    protected String name;
    protected int baseDamage;
    protected int level;
    protected int experience;
    public static final int XP_PER_LEVEL = 100;

    public Weapon(String name, int baseDamage) {
        this.name = name;
        this.baseDamage = baseDamage;
        this.level = 1;
        this.experience = 0;
    }

    public String getName() { return name; }
    public int getBaseDamage() { return baseDamage; }
    public int getLevel() { return level; }
    public int getExperience() { return experience; }
    public int getDamage() { return baseDamage + (level - 1) * 2; }

    public void setName(String name) { this.name = name; }
    public void setBaseDamage(int baseDamage) { this.baseDamage = baseDamage; }
    public void setLevel(int level) { this.level = level; }
    public void setExperience(int experience) { this.experience = experience; }

    public void gainExperience(int xp) {
        experience += xp;
        while (experience >= XP_PER_LEVEL) {
            experience -= XP_PER_LEVEL;
            level++;
        }
    }

    public void levelUp() {
        level++;
    }

    public void onEquip(AbstractUnit unit) { }

    @Override
    public int compareTo(Weapon other) {
        return Integer.compare(getDamage(), other.getDamage());
    }

    @Override
    public String toString() {
        return String.format("%s (DMG: %d, LVL: %d, XP: %d/%d)",
                name, getDamage(), level, experience, XP_PER_LEVEL);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Weapon)) return false;
        Weapon that = (Weapon) o;
        return level == that.level && name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, level);
    }

    public class WeaponNameComparator implements Comparator<Weapon> {
        @Override
        public int compare(Weapon a, Weapon b) {
            return a.getName().compareToIgnoreCase(b.getName());
        }
    }
}
