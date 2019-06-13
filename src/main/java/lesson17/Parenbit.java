package lesson17;

public class Parenbit {

    public String parenBit(String str) {


        if (str.charAt(0) == ')') {
            return str.substring(0, 1);
        } else {

            String rightSideReturned = parenBit(str.substring(1));
            if (rightSideReturned.charAt(0) == '(')
                return rightSideReturned;
            else
                return str.substring(0, 1) + rightSideReturned;
        }


    }
}
