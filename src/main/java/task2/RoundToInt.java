package task2;

import java.util.Scanner;

public class RoundToInt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter any number to round: ");

        double numberToRound = Double.parseDouble(scanner.next());
        int roundedNumber = (int) Math.round(numberToRound);

        System.out.println(String.format("Rounded %f is %d", numberToRound, roundedNumber));
    }
}