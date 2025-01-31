package Project;

public enum dayTypes {
    SMALL_WIN(new int[]{1,10}),
    BIG_WIN(new int[]{11,15}),
    LOSS(new int[]{16,25}),
    BATTLE(new int[]{26,35}),
    REST(new int[]{36,42}),
    BOSS_BATTLE(new int[]{43,50}),
    CHANCE(new int[]{50,60}),
    NO_EVENT;

    private int[] odds;

    private dayTypes(int[] odds) {
        this.odds = odds;
    }

    // overloaded constructor
    private dayTypes() {

    }

    public int[] getOdds() {return this.odds;}

    @Override
    public String toString() {
        return name();
    }
}
