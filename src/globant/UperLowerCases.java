package globant;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UperLowerCases {
    public static void main(String[] args) {
        List<String> words = List.of("Emmanuel", "Garcia", "de Santiago");
        Function<String, String> uppercase = String::toUpperCase;
        Function<String, String> lowercase = String::toLowerCase;
        System.out.println(words.stream().map(lowercase).collect(Collectors.toList()));
    }
}
