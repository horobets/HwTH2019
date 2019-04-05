package task2;

public class DevideNatural {
    public static void main(String[] args) {
        int q = 21, w = 8;

        int divResult = q / w;
        int remainder = q % w;

        System.out.println(String.format("%d / %d = %d и %d в остатке", q, w, divResult, remainder));
    }
}