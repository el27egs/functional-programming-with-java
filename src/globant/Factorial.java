package globant;

import java.math.BigInteger;
import java.util.stream.IntStream;

public class Factorial {
    public static void main(String[] args) {
        int value = 50;
        System.out.println(factorial(value));
        System.out.println(factorial2(value));
        System.out.println(factorial3(value));
    }
    private static long factorial(int n) {

        return IntStream.rangeClosed(1, n)
                .asLongStream()
                .reduce(1, (a, b) -> a * b);
    }

    private static long factorial2(int n) {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    private static BigInteger factorial3(int n) {
        BigInteger result = BigInteger.ONE;

        for (int i = 1; i <= n; i++) {
            result  = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
}
