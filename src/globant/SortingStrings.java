package globant;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortingStrings {
    public static void main(String[] args) {

        List<String> words = List.of("Susana", "Zaira", "Ana","Abel","Jose","Jeronimo","Pedro");
        List<String> asc = words.stream().sorted().collect(Collectors.toList());
        System.out.printf("Asc order %s\n", asc);
        words = List.of("Susana", "Zaira", "Ana","Abel","Jose","Jeronimo","Pedro");
        List<String> des = words.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.printf("Des order %s\n", des);

    }
}
