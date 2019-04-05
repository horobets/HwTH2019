package task2;

import java.util.Scanner;

public class IntToChar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter any char code: ");
        int characterCode = Integer.parseInt(scanner.next());

        char decodedChar = (char) characterCode;

        System.out.println(String.format("Char with code %d is %c", characterCode, decodedChar));
    }
}