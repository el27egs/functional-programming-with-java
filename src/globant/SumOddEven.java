package globant;

import java.util.stream.IntStream;

public class SumOddEven {
    public static void main(String[] args) {
        IntStream numbers = IntStream.range(1,6);
        int sumOddNumbers = numbers.filter(n -> n%2 != 0).sum();
        System.out.printf("OddNumbers sum %d\n",sumOddNumbers);

        numbers = IntStream.range(1,6);
        int sumEvenNumbers = numbers.filter(n -> n%2 == 0).sum();
        System.out.printf("OddNumbers sum %d\n",sumEvenNumbers);
    }


}
