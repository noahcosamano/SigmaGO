package Project;

public class Character {
    private int level, xp, neededXP;
    private String name;
    private long attack, defense, health;

    private static final String DEFAULT_NAME = "Unnamed Sigma";
    private static final long DEFAULT_ATTACK = 100, DEFAULT_HEALTH = 250, DEFAULT_DEFENSE = 50;
    private static final int DEFAULT_LEVEL = 1, DEFAULT_XP = 0, MAX_LEVEL = 100;

    public Character(String name) {
        this.name = name;
        this.attack = DEFAULT_ATTACK;
        this.defense = DEFAULT_DEFENSE;
        this.health = DEFAULT_HEALTH;
        this.level = DEFAULT_LEVEL;
        this.xp = DEFAULT_XP;
        this.neededXP = neededXPCalculator();
    }

    // overloaded constructor
    public Character() {
        this.name = DEFAULT_NAME;
        this.attack = DEFAULT_ATTACK;
        this.defense = DEFAULT_DEFENSE;
        this.health = DEFAULT_HEALTH;
        this.level = DEFAULT_LEVEL;
        this.xp = DEFAULT_XP;
        this.neededXP = neededXPCalculator();
    }

    public String getName() {return name;}
    public long getAttack() {return attack;}
    public long getDefense() {return defense;}
    public long getHealth() {return health;}
    public int getLevel() {return level;}
    public int getXP() {return xp;}
    public int getNeededXP() {return neededXP;}

    @Override
    public String toString() {
        return "Name: " + name + ", Level: " + level + ", Health: " + health + ", Attack: " + attack + ", Defense: " + defense; 
    }

    public boolean equals(Object obj) {
        if (obj instanceof Character) {
            Character other = (Character) obj;
            return health == other.health && attack == other.attack && defense == other.defense;
        }
        return false;
    }

    public int neededXPCalculator() {
        if(level <= MAX_LEVEL) {
            neededXP = (level * level) * 100;
            return neededXP;
        } else {
            return (MAX_LEVEL * MAX_LEVEL) * 100;
        }
    }

    public void gainXP(int tempXP) {
        xp += tempXP;
    
        while (xp >= neededXP) {
            xp -= neededXP;
            levelUp(); 
        }
    }

    public void recalculateAttack(int level) {
        long growth = (level * (level + 1)) / 2;
        attack = DEFAULT_ATTACK + 3 * growth;
    }

    public void recalculateHealth(int level) {
        long growth = (level * (level + 1)) / 2;
        health = DEFAULT_HEALTH + 5 * growth;
    }

    public void recalculateDefense(int level) {
        long growth = (level * (level + 1)) / 2;
        defense = DEFAULT_DEFENSE + 2 * growth;
    }

    public void recalculateStats(int level) {
        recalculateHealth(level);
        recalculateAttack(level);
        recalculateDefense(level);
    }

    public void levelUp() {
        if(level < MAX_LEVEL) {
            level += 1;
            neededXP = neededXPCalculator();
            recalculateStats(level);
        }
    }
}
