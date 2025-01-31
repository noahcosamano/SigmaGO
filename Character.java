public class Character {
    private int level;
    private String name;
    private long attack;
    private long defense;
    private long health;
    private int xp;
    private int neededXP;

    private static final String DEFAULT_NAME = "Unnamed Sigma";
    private static final long DEFAULT_ATTACK = 100;
    private static final long DEFAULT_DEFENSE = 50;
    private static final long DEFAULT_HEALTH = 250;
    private static final int DEFAULT_LEVEL = 1;
    private static final int DEFAULT_XP = 0;
    private static final int MAX_LEVEL = 100;

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
        if(obj instanceof Character) {
            Character other = (Character)obj;
            if(health == other.health && attack == other.attack && defense == other.defense) {
                return true;
            } return false;
        } return false;
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
            levelUp();  // Level up
        }
    }

    public void recalculateStats() {
        // H = health + (5 * level)
        // A = attack + (3 * level)
        // D = defense + (2 * level)

        // 2 : H(260), A(106), D(53)
        // 3 : H(275), A(1), D(57.5)
        // 4 : H(295), A(130), D(63.5)
        // 5 : H(320), A(145), D(71)
        // 10 : H(530), A(250), D(95)
        // 15 : H(855), A(360), D(132.5)
        // 25: H(1,655), A(850), D(275)
        // 50 : H(6,275), A(3,825), D(575)
        // 75 : H(14,175), A(8,550),
        // 100 : H(25,000), A(15,150)
    }

    public void levelUp() {
        if(level < MAX_LEVEL) {
            level += 1;
            neededXP = neededXPCalculator();
        }
    }
}
