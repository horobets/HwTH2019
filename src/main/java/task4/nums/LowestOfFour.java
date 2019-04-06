package task4.nums;

public class LowestOfFour {
    public static void main(String[] args) {

        int numOne = 3;
        int numTwo = 21;
        int numThree = 3;
        int numFour = 7;

        int lowestNum = numOne;

        if (numTwo < lowestNum)
            lowestNum = numTwo;
        if (numThree < lowestNum)
            lowestNum = numThree;
        if (numFour < lowestNum)
            lowestNum = numFour;

        System.out.printf("The lowest of %d, %d, %d, %d is %d", numOne, numTwo, numThree, numFour, lowestNum);
    }
}