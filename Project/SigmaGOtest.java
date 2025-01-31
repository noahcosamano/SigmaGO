package Project;

public class SigmaGOtest {
    public static void main(String[] args) {
        Character sigma1 = new Character("Savage Sigma"); 
        Day day = new Day();

        System.out.println(sigma1);
        System.out.println(sigma1.getName() + "'s XP: " + sigma1.getXP() + "/" + sigma1.getNeededXP());
        System.out.println();

        sigma1.gainXP(1080); // 2 : 1080 - 100 = 980, 3 : 980 - 400 = 580
        System.out.println(sigma1);
        System.out.println(sigma1.getName() + "'s XP: " + sigma1.getXP() + "/" + sigma1.getNeededXP());
        System.out.println();

        day.nextDay();
        day.nextDay();
        day.nextDay();
        day.nextDay();
        day.nextDay();
    }
}
