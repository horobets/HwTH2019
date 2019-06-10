package task14.collectionstasks;

/* Задача по алгоритмам
Задача: Пользователь вводит с клавиатуры список слов (и чисел). Слова вывести в возрастающем порядке, числа - в убывающем.
Пример ввода:
Вишня
1
Боб
3
Яблоко
2
0
Арбуз
Пример вывода:
Арбуз
3
Боб
2
Вишня
1
0
Яблоко
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CollectionsTask5 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        String[] array = list.toArray(new String[list.size()]);
        sort(array);

        for (String x : array) {
            System.out.println(x);
        }
    }

    public static void sort(String[] array) {
        //напишите тут ваш код
        List<Integer> stringsLocations = new ArrayList<>();
        List<Integer> numbersLocations = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            if (isNumber(array[i]))
                numbersLocations.add(i);
            else
                stringsLocations.add(i);
        }


        //sort strings
        String temp;
        for (int i = 0; i < stringsLocations.size() - 1; i++) {
            for (int j = i + 1; j < stringsLocations.size(); j++) {
                if (array[stringsLocations.get(i)].compareToIgnoreCase(array[stringsLocations.get(j)]) > 0) {                                             // ascending sort
                    temp = array[stringsLocations.get(i)];
                    array[stringsLocations.get(i)] = array[stringsLocations.get(j)];// swapping
                    array[stringsLocations.get(j)] = temp;
                }
            }
        }

        //sort ints
        for (int i = 0; i < numbersLocations.size() - 1; i++) {
            for (int j = i + 1; j < numbersLocations.size(); j++) {
                if (Integer.valueOf(array[numbersLocations.get(i)]) > Integer.valueOf(array[numbersLocations.get(j)])) {                                             // ascending sort
                    temp = array[numbersLocations.get(i)];
                    array[numbersLocations.get(i)] = array[numbersLocations.get(j)];// swapping
                    array[numbersLocations.get(j)] = temp;
                }
            }
        }


    }

    //Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }


    //строка - это на самом деле число?
    public static boolean isNumber(String s) {
        if (s.length() == 0) return false;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((i != 0 && c == '-') //есть '-' внутри строки
                    || (!Character.isDigit(c) && c != '-')) // не цифра и не начинается с '-'
            {
                return false;
            }
        }
        return true;
    }
}
