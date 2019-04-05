package task2;

import java.util.Scanner;

public class DigitsSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter any number to calculate the sum: ");
        int userNumber = Integer.parseInt(scanner.next());

        int sumOfDigits = getSumOfDigits(userNumber);
        System.out.println(String.format("Number provided: %d. Sum of its digits is %d", userNumber, sumOfDigits));
    }

    public static int getSumOfDigits(int number) {
        int sumOfDigits = 0;
        while (number > 0) {
            sumOfDigits += number % 10;
            number /= 10;
        }
        return sumOfDigits;
    }
}