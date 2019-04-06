package task4.nums;

import java.util.Scanner;

public class CompareNames {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter the first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Please enter the second name: ");
        String secondName = scanner.nextLine();

        if (firstName.equals(secondName)) {
            System.out.print("Люди являются тезками.");
        } else {
            System.out.println("Provided names are not equal.");
        }
    }
}
