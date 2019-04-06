package task4.nums;

public class CountMaxNums {
    public static void main(String[] args) {

        int numOne = 3;
        int numTwo = 21;
        int numThree = 21;
        int numFour = 7;

        //find max value:
        int maxNum = numOne;

        if (numTwo > maxNum)
            maxNum = numTwo;
        if (numThree > maxNum)
            maxNum = numThree;
        if (numFour > maxNum)
            maxNum = numFour;

        System.out.printf("Max val %d, %d, %d, %d is %d %n", numOne, numTwo, numThree, numFour, maxNum);

        //calc amount of max nums
        int maxNumsCount = 0;

        if(maxNum == numOne)
            maxNumsCount++;
        if(maxNum == numTwo)
            maxNumsCount++;
        if(maxNum == numThree)
            maxNumsCount++;
        if(maxNum == numFour)
            maxNumsCount++;

        System.out.printf("Max vals count: %d", maxNumsCount);
    }
}