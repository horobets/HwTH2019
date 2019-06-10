package task14.collectionstasks;

/* Минимальное из n чисел
1. Ввести с клавиатуры число n.
2. Считать n целых чисел и заполнить ими список - метод getIntegerList.
3. Найти минимальное число среди элементов списка - метод getMinimum.
*/

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CollectionsTask3 {
    public static void main(String[] args) throws Exception {
        List<Integer> integerList = getIntegerList();
        System.out.println(getMinimum(integerList));
    }

    public static int getMinimum(List<Integer> list) {
        //Ваш код

        int min = list.get(0);

        for (int n : list) {
            if (n < min)
                min = n;
        }
        return min;
    }

    public static List<Integer> getIntegerList() throws IOException {
        //Ваш код

        Scanner scanner = new Scanner(System.in);

        System.out.print("Numbers count: ");
        int numbersCount = Integer.parseInt(scanner.next());

        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < numbersCount; i++)
            nums.add(Integer.parseInt(scanner.next()));

        return nums;
    }
}