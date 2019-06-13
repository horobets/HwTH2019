package lesson17;

public class LuckySum {

    public int luckySum(int a, int b, int c) {
        int sum = 0;
        if (a != 13) {
            sum += a;
            if (b != 13) {
                if (c != 13) {
                    sum += c;
                }
                sum += b;
            }
        }
        return sum;
    }
}