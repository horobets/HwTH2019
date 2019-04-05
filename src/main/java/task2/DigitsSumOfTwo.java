package task2;

import java.util.Scanner;

public class DigitsSumOfTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter 2-digit number to calculate the sum: ");
        int twoDigitNumber = Integer.parseInt(scanner.next());

        //abort if number contains more than 2 digits
        if (twoDigitNumber > 99)
            return;

        int secondDigit = twoDigitNumber % 10;
        int firstDigit = (twoDigitNumber / 10) % 10;

        int sumOfDigits = firstDigit + secondDigit;

        System.out.println(String.format("Number provided: %d. Sum of its digits is %d", twoDigitNumber, sumOfDigits));
    }
}