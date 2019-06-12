package lesson17;

public class Lesson17recr {
    public String parenBit(String str) {

        if(str.length()<2){
            return str;
        }
        else
        {
            if(str.charAt(str.length()-1)!=')')
                return str.substring(0, str.length()-2);
            else {
                if (str.charAt(0) == '(')
                    return str;
                else
                    return str.charAt(0) + parenBit(str.substring(1));
            }
        }

    }

}
