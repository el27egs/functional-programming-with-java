package globant;

public class Palindrome {
    public static void main(String[] args) {

        String s = "radar";

        boolean isPalindromeLoop = true;

        char[] arr = s.toCharArray();
        int left = 0;
        int right = arr.length-1;

        while (left < right) {
            if (arr[left] != arr[right]) {
                isPalindromeLoop = false;
            }
            left++;
            right--;
        }

        boolean isPalindromeStreams = true;

        StringBuilder stringBuilder = new StringBuilder(s);
        isPalindromeStreams = s.equalsIgnoreCase(stringBuilder.reverse().toString());

        System.out.printf(s + " is palindrome ? " +  isPalindromeLoop + "\n");
        System.out.printf(s + " is palindrome ? " +  isPalindromeStreams + "\n");
    }
}
