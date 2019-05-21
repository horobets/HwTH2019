package task8;

public class task8 {
    public static void main(String[] args) {

        System.out.printf("%n%d%n", powerN(3, 2));
    }

    public static int powerN(int base, int n) {
        if (n > 0) {
            return base * powerN(base, n - 1);
        } else
            return 0;
    }

}
