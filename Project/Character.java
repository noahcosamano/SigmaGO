package Project;

import java.util.Random;

public class Character {
    private int level, xp, neededXP;
    private String name;
    private long attack, maxDefense, currentDefense, maxHealth, currentHealth;
    private float critChance, comboChance, dodgeChance;

    private static final String DEFAULT_NAME = "Unnamed Sigma";
    private static final long DEFAULT_ATTACK = 100, DEFAULT_MAX_HEALTH = 250, DEFAULT_MAX_DEFENSE = 50, 
                            CURRENT_HEALTH = DEFAULT_MAX_HEALTH, CURRENT_DEFENSE = DEFAULT_MAX_DEFENSE;
    private static final int DEFAULT_LEVEL = 1, DEFAULT_XP = 0, MAX_LEVEL = 100;
    private static final float CRIT_CHANCE = 0.1f, COMBO_CHANCE = 0.1f, DODGE_CHANCE = 0.1f;

    private Random random = new Random();

    public Character(String name) {
        this.name = name;
        this.attack = DEFAULT_ATTACK;
        this.maxDefense = DEFAULT_MAX_DEFENSE;
        this.currentDefense = CURRENT_DEFENSE;
        this.maxHealth = DEFAULT_MAX_HEALTH;
        this.currentHealth = CURRENT_HEALTH;
        this.level = DEFAULT_LEVEL;
        this.xp = DEFAULT_XP;
        this.neededXP = neededXPCalculator();
        this.critChance = CRIT_CHANCE;
        this.comboChance = COMBO_CHANCE;
        this.dodgeChance = DODGE_CHANCE;
    }

    // overloaded constructor
    public Character() {
        this.name = DEFAULT_NAME;
        this.attack = DEFAULT_ATTACK;
        this.maxDefense = DEFAULT_MAX_DEFENSE;
        this.currentDefense = CURRENT_DEFENSE;
        this.maxHealth = DEFAULT_MAX_HEALTH;
        this.currentHealth = CURRENT_HEALTH;
        this.level = DEFAULT_LEVEL;
        this.xp = DEFAULT_XP;
        this.neededXP = neededXPCalculator();
        this.critChance = CRIT_CHANCE;
        this.comboChance = COMBO_CHANCE;
        this.dodgeChance = DODGE_CHANCE;
    }

    public String getName() {return name;}
    public long getAttack() {return attack;}
    public long getMaxDefense() {return maxDefense;}
    public long getCurrentDefense() {return currentDefense;}
    public long getMaxHealth() {return maxHealth;}
    public long getCurrentHealth() {return currentHealth;}
    public int getLevel() {return level;}
    public int getXP() {return xp;}
    public int getNeededXP() {return neededXP;}
    public float getCritChance() {return critChance;}
    public float getComboChance() {return comboChance;}
    public float getDodgeChance() {return dodgeChance;}

    @Override
    public String toString() {
        return name + ", Lvl: " + level + ", HP: " + currentHealth + "/" + maxHealth +", Att: " + attack + ", Def: " + currentDefense +
         "/" + maxDefense + ", Crit: " + critChance * 100 + "%, Combo: " + comboChance * 100 + "%, Dodge: " + dodgeChance * 100 + "%";
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
        long maxHealthAfter = DEFAULT_MAX_HEALTH + 5 * growth;
        long difference = maxHealthAfter - maxHealth;
        maxHealth = maxHealthAfter;
        currentHealth = currentHealth + difference;
    }

    public void recalculateDefense(int level) {
        long growth = (level * (level + 1)) / 2;
        long maxDefenseAfter = DEFAULT_MAX_DEFENSE + 2 * growth;
        long difference = maxDefenseAfter - maxDefense;
        maxDefense = maxDefenseAfter;
        currentDefense = currentDefense + difference;
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

    public void takeDamage(int damage) {
        if(doesDodge()) {
            System.out.println("DODGED"); // Testing
            return;
        } else {
            long damageTaken = damage - currentDefense;
            if(damageTaken > 0) {
                if(currentHealth - damageTaken <= 0) {
                    currentHealth = 0;
                } else {
                    currentHealth -= damageTaken;
                }
            }
            float defenseDamage = damage * 0.25f;
            if(currentDefense - defenseDamage < 0) {
                currentDefense = 0;
            } else {
                currentDefense -= defenseDamage;
            }
        }
    } 

    public void Rest() {
        currentDefense = maxDefense;
        float restoredHealth = maxHealth * 0.5f;
        if(currentHealth + restoredHealth > maxHealth) {
            currentHealth = maxHealth;
        } else {
            currentHealth += restoredHealth;
        }
    }

    public void increaseCritChance(int percent) {
        float multiplier = 1 + (percent * 0.01f);
        critChance *= multiplier;
        critChance = Math.min(critChance, 1.0f);
    }

    public void increaseComboChance(int percent) {
        float multiplier = 1 + (percent * 0.01f);
        comboChance *= multiplier;
        comboChance = Math.min(comboChance, 1.0f);
    }

    public void increaseDodgeChance(int percent) {
        float multiplier = 1 + (percent * 0.01f);
        dodgeChance *= multiplier;
        dodgeChance = Math.min(dodgeChance, 1.0f);
    }

    public boolean doesCombo() {
        return random.nextFloat() < comboChance;
    }

    public boolean doesCrit() {
        return random.nextFloat() < critChance;
    }

    public boolean doesDodge() {
        return random.nextFloat() < dodgeChance;
    }

    public long Attack() {
        long finalAttack = attack;

        if(doesCrit()) {
            finalAttack = attack * 5;
            System.out.println("DID CRIT"); // Testing
        }
        if(doesCombo()) {
            long comboAttack = attack;
            System.out.println("DID COMBO"); // Testing
            if(doesCrit()) {
                System.out.println("DID COMBO CRIT"); // Testing
                comboAttack = attack * 5;
            }
            finalAttack += comboAttack;
        }
        return finalAttack;
    }
}
