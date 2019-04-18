package lesson7;

public class Lesson7Class {
    public static void main(String[] args) {

        String str = "123";

        int i = 5;
        str = String.valueOf(i);
        i = Integer.valueOf(str);

        double d = 5.4;
        str = String.valueOf(d);
        d = Double.valueOf(str);

        long l = 4433423;
        str = String.valueOf(l);
        l = Long.valueOf(str);

        boolean b = true;
        str = String.valueOf(b);
        b = Boolean.valueOf(str);

    }
}
