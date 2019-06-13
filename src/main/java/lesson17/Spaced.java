package lesson17;

public class Spaced {

    public static void main(String[] args) {
        evenlySpaced(2, 4, 6);
    }

    public static boolean evenlySpaced(int a, int b, int c) {
        int min = 0;
        int med = 0;
        int large = 0;

        if (a < b && a < c)
            min = a;
        if (b < a && b < c)
            min = b;
        if (c < a && c < b)
            min = c;


        if ((a < b && a > c) || (a > b && a < c))
            med = a;
        if ((b < a && b > c) || (b > a && b < c))
            med = b;
        if ((c < a && c > b) || (c > a && c < b))
            med = c;


        if (a > b && a > c)
            large = a;
        if (b > a && b > c)
            large = b;
        if (c > a && c > b)
            large = c;

        return large - med == med - min;
    }

}
