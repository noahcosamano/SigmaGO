package Project;

public class bossTesting {
    public static void main(String[] args) {
        Boss b1 = Boss.UNCLE_SAM;

        // Start enemy
        System.out.println("STARTING ENEMY");
        System.out.println(b1);
        System.out.println();

        // Level up enemy
        System.out.println("LEVEL UP ENEMY");
        b1.levelUp();
        System.out.println(b1);
        System.out.println();

        // Check if combo
        System.out.println("CHECKS FOR COMBO");
        for (int i = 0; i < 5; i++) {
            System.out.println(b1.doesCombo());
        }
        System.out.println();

        // Check if crit
        System.out.println("CHECKS FOR CRIT");
        for (int i = 0; i < 5; i++) {
            System.out.println(b1.doesCrit());
        }
        System.out.println();

        // Check if dodge
        System.out.println("CHECKS FOR DODGE");
        for (int i = 0; i < 5; i++) {
            System.out.println(b1.doesDodge());
        }
        System.out.println();

        // Level up enemy
        System.out.println("LEVEL UP ENEMY");
        for (int i = 0; i < 55; i++) {
            b1.levelUp();
        }
        System.out.println(b1);
        System.out.println();

        // Check if combo
        System.out.println("CHECKS FOR COMBO");
        for (int i = 0; i < 5; i++) {
            System.out.println(b1.doesCombo());
        }
        System.out.println();

        // Check if crit
        System.out.println("CHECKS FOR CRIT");
        for (int i = 0; i < 5; i++) {
            System.out.println(b1.doesCrit());
        }
        System.out.println();

        // Check if dodge
        System.out.println("CHECKS FOR DODGE");
        for (int i = 0; i < 5; i++) {
            System.out.println(b1.doesDodge());
        }
        System.out.println();

        // Damage enemy for < Defense
        System.out.println("DAMAGE CHARACTER FOR < DEFENSE");
        b1.takeDamage(30);
        System.out.println(b1);
        System.out.println();

        // Damage enemy for > Defense
        System.out.println("DAMAGE CHARACTER FOR > DEFENSE");
        b1.takeDamage(235000);
        System.out.println(b1);
        System.out.println();

        // Attack
        System.out.println("ATTACK");
        System.out.println(b1.attack());
        System.out.println();

        // Level up enemy
        System.out.println("LEVEL UP ENEMY");
        for (int i = 0; i < 195; i++) {
            b1.levelUp();
        }
        System.out.println(b1);
        System.out.println();
    }
}
