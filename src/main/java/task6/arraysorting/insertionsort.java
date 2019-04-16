package task6.arraysorting;

public class insertionsort {
    public static void main(String[] args) {
        int[] intArray = {3, 8, 11, 6, 10, 2};

        for (int i = 1; i < intArray.length;i++) {
            for (int k = i; k > 0 && intArray[k] < intArray[k - 1]; k--) {

                int tempInt = intArray[k - 1];
                intArray[k - 1] = intArray[k];
                intArray[k] = tempInt;
            }
        }

        for (int item : intArray)
            System.out.printf("%d ", item);
    }
}