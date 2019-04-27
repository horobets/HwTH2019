package task7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CountACharsInString {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("СТРОКА: ");
        String userString = scanner.nextLine();

        System.out.print("СИМВОЛ: ");
        char userChar = scanner.nextLine().charAt(0);

        countCharsInStringAndPrint(userString, userChar);
    }

    public static void countCharsInStringAndPrint(String str, char charToCount) {
        List<Integer> charAIndexes = new ArrayList<>();

        // add every occurrence's index to the list
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == charToCount)
                charAIndexes.add(i);
        }

        // prepare list of indexes as a string (for output)
        String indexesListStr = "";
        for (int i = 0; i < charAIndexes.size(); i++) {
            indexesListStr += charAIndexes.get(i);
            if (i < charAIndexes.size() - 1)//add separator if it is not the last item
                indexesListStr += ", ";
        }

        System.out.printf("РЕЗУЛЬТАТ: Кол-во символов \"%c\" - %d, индексы символа \"%c\" в строке - [%s]; %n%n",
                charToCount, charAIndexes.size(), charToCount, indexesListStr);
    }
}
