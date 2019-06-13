package lesson17;

public class nestParen {

    public static void main(String[] args) {
        nestParen("(())");
    }

    public static boolean nestParen(String str) {

        if (str.length() == 0)
            return true;
        if (str.length() == 1)
            return false;

        if ( /*(str.charAt(0)==str.charAt(str.length()-1)) */
                (str.charAt(0) == str.charAt(str.length() - 1) && str.charAt(0) == '"')
                        || ((str.charAt(0) == '(' && str.charAt(str.length() - 1) == ')')))
            return nestParen(str.substring(1, str.length() - 1));
        else
            return false;
    }

}
