package task2;

import java.util.Scanner;

public class CharToInt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter any character: ");
        char character = scanner.next().charAt(0);

        int codeOfCharacter = (int) character;

        System.out.println(String.format("Int code of char %c is %d", character, codeOfCharacter));
    }
}