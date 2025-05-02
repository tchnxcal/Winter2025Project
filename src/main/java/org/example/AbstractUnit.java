public abstract class AbstractUnit implements CombatInterface {
    protected String name;
    protected int hp;
    protected int def;
    protected int spd;
    protected int level;
    protected int energy;
    protected int maxEnergy;
    protected int sp;
    protected double critRate; // e.g., 5.0 for 5%
    protected double critDmg; // e.g., 50.0 for 50%
    protected Weapon equippedWeapon;

    public AbstractUnit() {
        this.name = "Unnamed";
        this.hp = 100;
        this.def = 10;
        this.spd = 10;
        this.level = 1;
        this.critRate = 5.0;
        this.critDmg = 50.0;
        this.sp = 0;
        this.energy = 0;
        this.maxEnergy = 100;
        this.equippedWeapon = new BasicDagger();
    }

    public AbstractUnit(String name, int hp, int def, int spd, int level, int maxEnergy) {
        this.name = name;
        this.hp = hp;
        this.def = def;
        this.spd = spd;
        this.level = level;
        this.critRate = 5.0 + 2 * (level - 1);  // +2% CR per level
        this.critDmg = 50.0 + 4 * (level - 1);  // +4% CD per level
        this.sp = 0;
        this.energy = 0;
        this.maxEnergy = maxEnergy;
        this.equippedWeapon = new BasicDagger();
    }

    @Override
    public void receiveDamage(int amount) {
        int reducedDmg = Math.max(0, amount - def);
        hp = Math.max(0, hp - reducedDmg);
        System.out.println(name + " takes " + reducedDmg + " damage (HP: " + hp + ")");
    }

    @Override
    public boolean isAlive() {
        return hp > 0;
    }

    public void equipWeapon(Weapon weapon) {
        this.equippedWeapon = weapon;
    }

    public Weapon getEquippedWeapon() {
        return equippedWeapon;
    }

    public String getName() { return name; }
    public int getHp() { return hp; }
    public int getDef() { return def; }
    public int getSpd() { return spd; }
    public int getLevel() { return level; }
    public int getEnergy() { return energy; }
    public int getMaxEnergy() { return maxEnergy; }
    public int getSp() { return sp; }
    public double getCritRate() { return critRate; }
    public double getCritDmg() { return critDmg; }

    public void setHp(int hp) { this.hp = hp; }
    public void setDef(int def) { this.def = def; }
    public void setSpd(int spd) { this.spd = spd; }
    public void setLevel(int level) { this.level = level; }
    public void setEnergy(int energy) { this.energy = energy; }
    public void setMaxEnergy(int maxEnergy) { this.maxEnergy = maxEnergy; }
    public void setSp(int sp) { this.sp = sp; }
    public void setCritRate(double critRate) { this.critRate = critRate; }
    public void setCritDmg(double critDmg) { this.critDmg = critDmg; }

    @Override
    public String toString() {
        return name + " [Level " + level + "] HP: " + hp + " | DEF: " + def + " | SPD: " + spd +
                " | CR: " + critRate + "% | CD: " + critDmg + "% | Weapon: " + equippedWeapon;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof AbstractUnit)) return false;
        AbstractUnit other = (AbstractUnit) obj;
        return name.equals(other.name) && level == other.level;
    }

    @Override
    public int hashCode() {
        return name.hashCode() + level;
    }

    public abstract void takeTurn();
}
