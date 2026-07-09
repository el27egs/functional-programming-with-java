package globant;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SecondMaxMinNumbers {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1,3,4,5,6,8,2,3,4,5,6,7,8,9,10);
        int min = integers.stream().distinct().sorted().skip(1).findFirst().get();
        System.out.println("Min " +  min);
        int max = integers.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
        System.out.println("Max " +  max);

    }
}
