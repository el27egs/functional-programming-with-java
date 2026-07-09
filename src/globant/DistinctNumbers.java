package globant;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DistinctNumbers {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1,3,4,5,6,8,2,3,4,5,6,7,8,9,10);
        System.out.println("Distinct numbers "
                + integers.stream().distinct().collect(Collectors.toList()));

    }
}
