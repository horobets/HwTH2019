package exam2;

public class TestComparator {
    public static void main(String[] args) {

    }

    public void calc(int a, int b) {
        if (b == 0) {
            return;
        }
        double res = a / b;
        System.out.println(res);
    }

    public double calc(int a, int b, int c) {
        return a / b * c;
    }


    public static void TryCatchFinallyTest(Integer a, Integer b) {
        try {
            double div = a / b;
        } catch (ArithmeticException e) {
            System.out.printf("ArithmeticException! %n%s", e);
        } catch (NullPointerException e) {
            System.out.printf("NullPointerException! %n%s", e);
        } catch (Exception e) {
            System.out.printf("Unknown Exception! %n%s", e);
        } finally {
            System.out.println("Thank you for using our software!");
        }
    }
}
