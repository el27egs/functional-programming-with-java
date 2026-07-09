package globant;

import java.util.Arrays;
import java.util.stream.Collectors;

public class CapitalizeStrings {
    public static void main(String[] args) {
        String string = "This is a string which should be capitalize";

        string = Arrays.stream(string.split("\\s+"))
                .map(s -> s.substring(0,1).toUpperCase() + s.substring(1).toLowerCase())
                        .collect(Collectors.joining(" "));

        System.out.printf(string);
    }
}
