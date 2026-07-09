package grider;

import java.util.HashMap;

public class Anagrams {

    public static void main(String[] args) {

        System.out.println(areAnagrams("rail safety","fairy tales"));
    }


    private static boolean areAnagrams(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i), 0) + 1);
        }
        for (int i = 0; i < s2.length(); i++) {
            map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i), 0) - 1);
        }
        return map.values().stream().allMatch(v -> v == 0);
    }

}
