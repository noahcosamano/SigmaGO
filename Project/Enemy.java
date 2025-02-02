package Project;

public enum Enemy {
    ZOMBIE(75,100,250,0.05f,0.2f,0),
    RABID_SQUIRREL(100,50,200,0.1f,0.3f,0.2f),
    BAT(75,75,150,0.1f,0.2f,0.3f),
    SWARM_OF_HORSEFLIES(30,150,250,0,0.5f,0.5f),
    ANGRY_CHIMP(100,150,150,0.3f,0.3f,0.05f),
    INVISIBLE_PENGUIN(50,100,150,0.1f,0.2f,0.75f),
    DRUNK(100,50,300,0.1f,0.1f,0.2f),
    OVERGROWN_BABY(100,50,250,0.1f,0.1f,0);

    private long defaultAttack;
    private long currentAttack;
    private long maxDefense;
    private long currentDefense;
    private long maxHealth;
    private long currentHealth;
    private float critChance;
    private float comboChance;
    private float dodgeChance;
    private int level;

    public long getDefaultAttack() {return defaultAttack;}
    public long getCurrentAttack() {return currentAttack;}
    public long getMaxDefense() {return maxDefense;}
    public long getCurrentDefense() {return currentDefense;}
    public long getMaxHealth() {return maxHealth;}
    public long getCurrentHealth() {return currentHealth;}
    public float getCritChance() {return critChance;}
    public float getComboChance() {return comboChance;}
    public float getDodgeChance() {return dodgeChance;}
    public float getLevel() {return level;}

    Enemy(long defaultAttack, long maxDefense, long maxHealth, float critChance, float comboChance, float dodgeChance) {
        this.defaultAttack = defaultAttack;
        this.currentAttack = defaultAttack;
        this.maxDefense = maxDefense;
        this.currentDefense = maxDefense;
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        this.critChance = critChance;
        this.comboChance = comboChance;
        this.dodgeChance = dodgeChance;
        this.level = 1;
    }

    @Override
    public String toString() {
        return name() + ", Level: " + level + ", HP: " + currentHealth + "/" + maxHealth +", Att: " + currentAttack + 
        ", Def: " + currentDefense + "/" + maxDefense + ", Crit: " + critChance * 100 + 
        "%, Combo: " + comboChance * 100 + "%, Dodge: " + dodgeChance * 100 + "%";
    }

    public void recalculateAttack(int level) {
        long growth = (level * (level + 1)) / 2;
        this.currentAttack = this.defaultAttack + 3 * growth;
    }

    public void recalculateHealth(int level) {
        long growth = (level * (level + 1)) / 2;
        long maxHealthAfter = this.maxHealth + 5 * growth;
        long difference = maxHealthAfter - this.maxHealth;
        this.maxHealth = maxHealthAfter;
        this.currentHealth += difference;
    }

    public void recalculateDefense(int level) {
        long growth = (level * (level + 1)) / 2;
        long maxDefenseAfter = this.maxDefense + 2 * growth;
        long difference = maxDefenseAfter - this.maxDefense;
        this.maxDefense = maxDefenseAfter;
        this.currentDefense += difference;
    }

    public void recalculateStats(int level) {
        recalculateHealth(level);
        recalculateAttack(level);
        recalculateDefense(level);
    }

    public void levelUp() {
        this.level += 1;
        recalculateStats(level);
    }

    public void takeDamage(int damage) {
        if (doesDodge()) {
            System.out.println("DODGE"); // Testing
            return;
        } else {
            long damageTaken = damage - this.currentDefense;
            if (damageTaken > 0) {
                this.currentHealth -= damageTaken;
                if (this.currentHealth < 0) {
                    this.currentHealth = 0;
                }
            }
            float defenseDamage = damage * 0.25f;
            if (this.currentDefense - defenseDamage < 0) {
                this.currentDefense = 0;
            } else {
                this.currentDefense -= defenseDamage;
            }
        }
    }

    public boolean doesDodge() {
        return Math.random() < this.dodgeChance;
    }

    public boolean doesCrit() {
        return Math.random() < this.critChance;
    }

    public boolean doesCombo() {
        return Math.random() < this.comboChance;
    }

    public long attack() {
        long finalAttack = this.currentAttack;

        if (doesCrit()) {
            finalAttack = this.currentAttack * 5;
            System.out.println("CRIT"); // Testing
        }
        if (doesCombo()) {
            long comboAttack = this.currentAttack;
            System.out.println("COMBO"); // Testing
            if (doesCrit()) {
                System.out.println("COMBO CRIT"); // Testing
                comboAttack = this.currentAttack * 5;
            }
            finalAttack += comboAttack;
        }

        return finalAttack;
    }
}