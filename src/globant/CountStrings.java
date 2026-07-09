package globant;

import java.util.List;

public class CountStrings {
    public static void main(String[] args) {

        String letter = "a";
        List<String> words = List.of("Ana","Abel","Jose","Jeronimo","Pedro");
        long count = words.stream()
                .filter(name -> name.toLowerCase().startsWith(letter.toLowerCase())).count();
        System.out.printf("Number of words with \"%s\" was %d", letter, count);
    }
}
