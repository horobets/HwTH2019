package lesson7;

public class PalindrCheck {
    public static void main(String[] args) {
        String text = "Teshkjhgttset";

        text = text.replace(" ", "");

        String reversedText = "";

        for (int i = text.length() - 1; i >= 0; i--)
            reversedText += text.charAt(i);

        if (0 == text.compareToIgnoreCase(reversedText))
            System.out.printf("The following text IS a palindrome: %s ", text);
        else
            System.out.printf("The following text is NOT a palindrome: %s ", text);

    }
}
