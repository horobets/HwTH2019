package lesson17;

public class MakeBricks {

    public static void main(String[] args) {
        System.out.println(makeBricks(3, 1, 9));
    }

    public static boolean makeBricks(int small, int big, int goal) {

        int maxCoverableByBig = goal - goal % 5;
        int coveredByBig = 0;
        if (big * 5 >= maxCoverableByBig)
            coveredByBig = maxCoverableByBig;
        else
            coveredByBig = big * 5;

        //int smallNeeded = goal % 5;

        //int smallNeeded = goal - coveredByBig;

        return goal <= coveredByBig + small;
    }

}
