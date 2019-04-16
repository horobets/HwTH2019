package lesson6;

public class BubbleSort {
    public static void main(String[] args) {
        boolean swapFlag = true;
        int tempInt;
        int[] intArray = {3, 8, 11, 6, 10, 2};
        while (swapFlag) {
            swapFlag = false;
            for (int i = 0; i < intArray.length - 1; i++) {
                if (intArray[i] < intArray[i + 1]) {
                    tempInt = intArray[i];
                    intArray[i] = intArray[i + 1];
                    intArray[i + 1] = tempInt;
                    swapFlag = true;
                }
            }
        }
        for (int item : intArray)
            System.out.printf("%d ", item);
    }
}