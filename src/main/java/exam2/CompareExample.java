package exam2;

import java.util.ArrayList;
import java.util.List;

public class CompareExample {
    public static void main(String args[]) {
        List<TestClass> testList = new ArrayList<TestClass>();

        testList.add(new TestClass("Test1", 1));
        testList.add(new TestClass("Test2", 2));

        testList.sort(new TestClassComparator());
    }

}