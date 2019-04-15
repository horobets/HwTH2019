package lesson6;

public class Lesson6Test1 {
    public static void main(String[] args) {
            //System.err.println("dddddd");


        int ar[] = {2,3,-1,6,6,6,7,8,9,0,1111};
        int maxVal = ar[0];
        int minVal = ar[0];

        for(int v : ar)
        {
            if(v>maxVal)
                maxVal=v;
            if(v<minVal)
                minVal=v;
        }

        System.out.printf("Min: %d, max: %d", minVal, maxVal);
    }
}
