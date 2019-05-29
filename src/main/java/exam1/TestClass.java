package exam1;

public class TestClass {
    private String testVal;

    public TestClass(String testVal) {
        this.testVal = testVal;


        for (int i = 0; i < 100; i++) {
            if (i == 10)
                break;
        }
    }


    public int calcSum(int a, int b) {
        return a + b;
    }


    public int calcSum(int a, int b, int c) {
        return a + b + c;
    }

    public double calcSum(double a, double b) {
        return a + b;
    }
}
