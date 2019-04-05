package task2;

import java.util.Scanner;

public class DigitsSumOfThree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter 3-digit number to calculate the sum: ");
        int threeDigitsNumber = Integer.parseInt(scanner.next());

        //abort if number contains more than 3 digits
        if (threeDigitsNumber > 999)
            return;

        int thirdDigit = threeDigitsNumber % 10;
        int secondDigit = (threeDigitsNumber / 10) % 10;
        int firstDigit = (threeDigitsNumber / 100) % 10;

        int sumOfDigits = firstDigit + secondDigit + thirdDigit;

        System.out.println(String.format("Number provided: %d. Sum of its digits is %d", threeDigitsNumber, sumOfDigits));
    }
}