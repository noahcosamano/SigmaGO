package Project;

public class characterTesting {
    public static void main(String[] args) {
        Character c1 = new Character("Savage Sigma"); 

        // Start character
        System.out.println("STARTING CHARACTER");
        System.out.println(c1);
        System.out.println(c1.getName() + "'s XP: " + c1.getXP() + "/" + c1.getNeededXP());
        System.out.println();

        // Level up character
        System.out.println("LEVEL UP CHARACTER");
        c1.gainXP(160); // 2 : 1080 - 100 = 980, 3 : 980 - 400 = 580
        System.out.println(c1);
        System.out.println(c1.getName() + "'s XP: " + c1.getXP() + "/" + c1.getNeededXP());
        System.out.println();

        // Check if combo
        System.out.println("CHECKS FOR COMBO");
        for (int i = 0; i < 5; i++) {
            System.out.println(c1.doesCombo());
        }
        System.out.println();

        // Check if crit
        System.out.println("CHECKS FOR CRIT");
        for (int i = 0; i < 5; i++) {
            System.out.println(c1.doesCrit());
        }
        System.out.println();

        // Check if dodge
        System.out.println("CHECKS FOR DODGE");
        for (int i = 0; i < 5; i++) {
            System.out.println(c1.doesDodge());
        }
        System.out.println();

        // Increase crit
        System.out.println("INCREASE CRIT CHANCE");
        c1.increaseCritChance(45);
        System.out.println(c1);
        System.out.println();

        // Increase combo
        System.out.println("INCREASE COMBO CHANCE");
        c1.increaseComboChance(30);
        System.out.println(c1);
        System.out.println();

        // Increase dodge
        System.out.println("INCREASE DODGE CHANCE");
        c1.increaseDodgeChance(700);
        System.out.println(c1);
        System.out.println();

        // Check if combo after increase
        System.out.println("CHECKS FOR COMBO AFTER INCREASE");
        for (int i = 0; i < 5; i++) {
            System.out.println(c1.doesCombo());
        }
        System.out.println();

        // Check if crit after increase
        System.out.println("CHECKS FOR CRIT AFTER INCREASE");
        for (int i = 0; i < 5; i++) {
            System.out.println(c1.doesCrit());
        }
        System.out.println();

        // Check if dodge after increase
        System.out.println("CHECKS FOR DODGE AFTER INCREASE");
        for (int i = 0; i < 5; i++) {
            System.out.println(c1.doesDodge());
        }
        System.out.println();

        // Damage character for < Defense
        System.out.println("DAMAGE CHARACTER FOR < DEFENSE");
        c1.takeDamage(40);
        System.out.println(c1);
        System.out.println();

        // Damage character for > Defense
        System.out.println("DAMAGE CHARACTER FOR > DEFENSE");
        c1.takeDamage(225);
        System.out.println(c1);
        System.out.println();

        // Restore health and Defense
        System.out.println("REST CHARACTER");
        c1.Rest();
        System.out.println(c1);
        System.out.println();

        // Attack
        System.out.println("ATTACK");
        System.out.println(c1.Attack());
        System.out.println();
    }
}
