package lesson17;

public class StrDist {

    public static void main(String[] args) {
        strDist("cccatcowcatxx", "cat");
    }

    public static int strDist(String str, String sub) {
        if (str.length() >= sub.length()) {

            if (!str.substring(0, sub.length()).equals(sub)) {
                return strDist(str.substring(1), sub);
            } else {//beginning found!

                if (!str.substring(str.length() - sub.length()).equals(sub)) {
                    return strDist(str.substring(0, str.length() - 1), sub);
                } else//end found
                    return str.length();
            }
        } else
            return 0;
    }
}
