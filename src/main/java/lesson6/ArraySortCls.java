package lesson6;

import java.util.Arrays;

public class ArraySortCls {
    public static void main(String[] args) {
        //Arrays.sort();

        char[] chArr = new char[255];

        for(int i =0; i< chArr.length; i++)
        {
            chArr[i] = (char)i;
        }

        System.out.println( Arrays.toString(chArr));
    }
}
