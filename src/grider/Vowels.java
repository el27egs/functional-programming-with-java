package grider;

import java.util.HashSet;
import java.util.Set;

public class Vowels {

    public static void main(String[] args) {

        String s = "hola mundo";

        System.out.printf("%d vowels in '%s'",findVowels(s),s);
    }
    private static int findVowels(String word) {
        int count = 0;
        Set<String> vowels = new HashSet<String>();
        vowels.add("a");
        vowels.add("e");
        vowels.add("i");
        vowels.add("o");
        vowels.add("u");

        for (int i = 0; i < word.length(); i++) {
            String letter =  word.substring(i, i + 1);
            if (vowels.contains(letter)){
                count++;
            }
        }
        return count;
    }

}
