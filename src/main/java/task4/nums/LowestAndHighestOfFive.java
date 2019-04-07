package task4.nums;

public class LowestAndHighestOfFive {
    public static void main(String[] args) {

        int numOne = 2;
        int numTwo = 45;
        int numThree = 5;
        int numFour = 4;
        int numFive = 18;

        //find min value:
        int lowestNum = numOne;

        if (numTwo < lowestNum)
            lowestNum = numTwo;
        if (numThree < lowestNum)
            lowestNum = numThree;
        if (numFour < lowestNum)
            lowestNum = numFour;
        if (numFive < lowestNum)
            lowestNum = numFive;


        //find max value:
        int highestNum = numOne;

        if (numTwo > highestNum)
            highestNum = numTwo;
        if (numThree > highestNum)
            highestNum = numThree;
        if (numFour > highestNum)
            highestNum = numFour;
        if (numFive > highestNum)
            highestNum = numFive;


        System.out.printf("Nums: %d, %d, %d, %d, %d %n", numOne, numTwo, numThree, numFour, numFive);
        System.out.printf("Lowest: %d, highest: %d", lowestNum, highestNum);
    }
}
