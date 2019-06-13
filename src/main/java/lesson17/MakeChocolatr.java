package lesson17;

public class MakeChocolatr {

    public static void main(String[] args) {
        makeChocolate(4, 1, 9);
    }

    public static int makeChocolateNoLoops(int small, int big, int goal) {

        int maxCoverableByBig = goal - goal % 5;
        int coveredByBig = 0;
        if (big * 5 >= maxCoverableByBig)
            coveredByBig = maxCoverableByBig;
        else
            coveredByBig = big * 5;

        return goal <= coveredByBig + small ? goal - coveredByBig : -1;
    }

    public static int makeChocolate(int small, int big, int goal) {

        int resKg = 0;

        for (int i = 0; i < big; i++) {
            if (resKg < goal && resKg + 5 <= goal)
                resKg += 5;
            else
                break;
        }

        int smallBarsUsed = 0;
        for (int i = 0; i < small; i++) {
            if (resKg < goal && resKg + 1 <= goal) {
                resKg += 1;
                smallBarsUsed++;
            } else
                break;
        }

        return resKg == goal ? smallBarsUsed : -1;
    }
}
