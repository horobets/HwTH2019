package task2;

public class CastingBasics {
    public static void main(String[] args) {

        int intVal = 100;
        char charVal = (char) intVal;
        System.out.println(String.format("%d int->char: %c", intVal, charVal));

        float floatVal = 100.85f;
        charVal = (char) floatVal;
        System.out.println(String.format("%f float->char: %c", floatVal, charVal));

        intVal = (int) (char) floatVal;
        System.out.println(String.format("%f float->char->int: %d", floatVal, intVal));
    }
}