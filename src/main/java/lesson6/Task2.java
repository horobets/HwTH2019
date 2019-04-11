package lesson6;

public class Task2 {
    public static void main(String[] args) {


        int ar[] = {2,3,-1,6,6,6,7,8,9,0,1111};


        for(int a : ar)
            System.out.printf("%d ", a);

        for(int i = 0; i<ar.length; i++)
        {
            for (int j = i; j< ar.length; i++)
            {
                if(j>i)
                {
                    int tmp = j;
                    j = i;
                    i= tmp;
                }
            }
        }

        System.out.println();
        for(int a : ar)
            System.out.printf("%d ", a);
    }
}
