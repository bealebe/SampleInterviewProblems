/**
 * Created by bryanbeale on 10/19/17.
 */
public class Palindrome {
    public static boolean isPalindrome(String word) {
        String wordReversed = "";

        for(int i=word.length()-1; i>=0; i--){
            wordReversed += word.charAt(i);
        }

        return wordReversed.equalsIgnoreCase(word);

    }

    public static void main(String[] args) {
        System.out.println(Palindrome.isPalindrome("Deleveled"));
    }
}
