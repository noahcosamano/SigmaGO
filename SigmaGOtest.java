public class SigmaGOtest {
    public static void main(String[] args) {
        Character sigma1 = new Character("Savage Sigma");
        Character sigma2 = new Character();

        System.out.println(sigma1);
        System.out.println(sigma2);
        System.out.println(sigma1.getName() + "'s XP: " + sigma1.getXP() + "/" + sigma1.getNeededXP());
        System.out.println(sigma2.getName() + "'s XP: " + sigma2.getXP() + "/" + sigma2.getNeededXP());
        System.out.println(sigma1.getName() + " == " + sigma2.getName() + ": " + sigma1.equals(sigma2)); // false
        System.out.println();

        sigma1.gainXP(6);
        sigma2.gainXP(10978);
        System.out.println(sigma1);
        System.out.println(sigma2);
        System.out.println(sigma1.getName() + "'s XP: " + sigma1.getXP() + "/" + sigma1.getNeededXP());
        System.out.println(sigma2.getName() + "'s XP: " + sigma2.getXP() + "/" + sigma2.getNeededXP());
        System.out.println(sigma1.getName() + " == " + sigma2.getName() + ": " + sigma1.equals(sigma2)); // false
    }
}
