package lesson17;

public class CloseFar {
    public static void main(String[] args) {
        closeFar(1, 2, 3);
    }

    public static boolean closeFar(int a, int b, int c) {

        return (Math.abs(b - a) <= 1 && Math.abs(c - a) >= 2 && Math.abs(c - b) >= 2)
                || (Math.abs(c - a) <= 1 && Math.abs(b - a) >= 2 && Math.abs(b - c) >= 2);
    }
}
