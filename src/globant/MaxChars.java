package globant;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MaxChars {

    public static void main(String[] args) {

        String str = "This is a new string with several characters, the idea is get the char with more occurrences here";

        maxCharsOwnImpl(str);
        maxCharsIA(str);
    }

    private static void maxCharsOwnImpl(String str){

        HashMap<String, Integer> map = new HashMap<>();

        Arrays.stream(str.split("\\s+"))
                .flatMap (s -> Arrays.stream(s.split("")))
                .map(String::toLowerCase)
                .forEach( c -> map.put(c, map.getOrDefault(c,0) + 1)
                );

        System.out.println(map);

        map.entrySet().stream().max(Comparator.comparingInt(Map.Entry::getValue)).ifPresent(System.out::println);

    }
    private static void maxCharsIA(String str){

        Map<String, Long> map =
                str.toLowerCase()
                        .chars()
                        .filter(Character::isLetter)
                        .mapToObj(c -> String.valueOf((char) c))
                        .collect(Collectors.groupingBy(
                                Function.identity(),
                                Collectors.counting()
                        ));

        System.out.println(map);

        map.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .ifPresent(System.out::println);
    }

}
