import java.util.Scanner;

/**
 * Created by bryanbeale on 10/12/17.
 */
public class MainAnagram {

    private static final int NUMBER_LETTERS = 26;

    /**
     * Given two strings (a->z), how many characters do we need to remove (from either)
     * to make anagrams?
     *
     * Example: hello, billion --> ANSWER = 6 (he from hello and biin from billion).
     *
     */

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a String : ");
        String first = input.nextLine();
        System.out.print("Enter another String : ");
        String second = input.nextLine();
        System.out.println(numberNeeded(first, second));

    }

    private static int numberNeeded(String first, String second) {
        int[] charCount1 = getCharCounts(first.toLowerCase());
        int[] charCount2 = getCharCounts(second.toLowerCase());
        return getDelta(charCount1, charCount2);

    }

    private static int[] getCharCounts(String s) {
        int [] charCounts = new int[NUMBER_LETTERS];
        for(int i = 0; i<s.length(); i++){
            char c= s.charAt(i);
            int offset = (int) 'a';
            int  code = c -offset;
            charCounts[code]++;
        }
        return charCounts;
    }

    public static int getDelta(int[] array1, int[] array2){
        if (array1.length != array2.length){
            return -1; //handle error;
        }

        int delta = 0;
        for (int i =0; i < array1.length; i++){
            int difference = Math.abs(array1[i] - array2[i]);
            delta += difference;
        }
        return delta;
    }

}
