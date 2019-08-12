package exam2;

import java.util.Comparator;

public class TestClassComparator implements Comparator<TestClass> {
    @Override
    public int compare(TestClass o1, TestClass o2) {
        return o1.i.compareTo(o2.i);
    }
}
