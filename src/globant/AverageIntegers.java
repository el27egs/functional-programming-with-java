package globant;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.IntStream;

public class AverageIntegers {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        OptionalDouble avg = OptionalDouble.of(0.0);
        avg = integers.stream().mapToInt(i -> i.intValue()).average();
        System.out.println("Average is " + avg.getAsDouble());

        IntStream integers2 = IntStream.range(1,11);
        System.out.println("Average is " + integers2.average().getAsDouble());

    }
}
