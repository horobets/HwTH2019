package exam1;

public class TestSubClass extends TestClass {
    public TestSubClass() {
        super("test");
    }

    @Override
    public int calcSum(int a, int b) {
        return a - b;
    }
}
