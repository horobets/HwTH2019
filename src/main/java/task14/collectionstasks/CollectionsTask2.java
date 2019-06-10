package task14.collectionstasks;

/*
Задача: Вводить с клавиатуры строки до тех пор пока не будет введена пустая строка, после чего вывести строки в отсортированном порядке (алфавитном)
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CollectionsTask2 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> list = new ArrayList<>();

        //заполните список строками при помощи reader.readLine();

        String line;
        while (!(line = reader.readLine()).equals("")) {
            list.add(line);
        }
        sort(list); //метод для сортировки списка

        //вывести список в отсортированном порядке

        System.out.println("Sorted lines:");
        for (String lineFromList : list)
            System.out.println(lineFromList);
    }

    public static void sort(List<String> list) {
        //реализуйте свой алгоритм сортировки списка при помощи  метода isGreaterThan(String a, String b)

        String temp;
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).compareToIgnoreCase(list.get(j)) > 0) {                                             // ascending sort
                    temp = list.get(i);
                    list.set(i, list.get(j));    // swapping
                    list.set(j, temp);
                }
            }
        }
    }

    //Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }
}