package lesson6;

public class Task3bblSort {
    public static void main(String[] args) {


        int ar[] = {2, 3, -1, 6, 6, 6, 7, 8, 9, 0, 1};


        for (int a : ar)
            System.out.printf("%d ", a);


        for (int j = 1; j < ar.length; j++) {

            for(int i = 1; i< ar.length-j; i++) {

                if (ar[i] < ar[i - 1]) {
                    int tmp = ar[i];
                    ar[i] = ar[i - 1];
                    ar[i - 1] = tmp;
                }
            }
        }


        System.out.println();
        for (int a : ar)
            System.out.printf("%d ", a);
    }
}
