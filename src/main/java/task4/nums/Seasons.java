package task4.nums;

import java.util.Scanner;

public class Seasons {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter month number (e.g. 1 - January, 12 - December): ");
        int monthNumber = Integer.parseInt(scanner.nextLine());

        String seasonName;
        switch (monthNumber) {
            case 1:
            case 2:
            case 12:
                seasonName = "Winter";
                break;
            case 3:
            case 4:
            case 5:
                seasonName = "Spring";
                break;
            case 6:
            case 7:
            case 8:
                seasonName = "Summer";
                break;
            case 9:
            case 10:
            case 11:
                seasonName = "Autumn";
                break;
            default:
                System.out.println("Invalid month number.");
                return;
        }
        System.out.printf("Season: %s %n", seasonName);
    }
}
