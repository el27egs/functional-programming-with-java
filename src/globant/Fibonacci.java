package globant;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

public class Fibonacci {

    private static HashMap<Integer, BigInteger> computes = new HashMap<>();
    public static void main(String[] args) {

        int number = 8;
        System.out.println(fibonacciRecursive(number));
        System.out.println(fibonacciLoop(number));
        System.out.println(fibonacciStreams(number));

    }

    private static BigInteger fibonacciRecursive(int number) {
        if (number <= 1) {
            return BigInteger.valueOf(number);
        }

        if (computes.containsKey(number)) {
            return computes.get(number);
        }

        BigInteger result = fibonacciRecursive(number - 1).add(fibonacciRecursive(number - 2));

        computes.put(number, result);

        return result;
    }

    private static BigInteger fibonacciLoop (int number) {

        if (number <= 1) {
            return BigInteger.valueOf(number);
        }

        BigInteger previous = BigInteger.valueOf(0);
        BigInteger current = BigInteger.valueOf(1);

        System.out.print(previous+ " ");
        System.out.print(current+ " ");

        for(int i=2; i<=number; i++) {

            BigInteger next = previous.add(current);
            previous = current;
            current = next;
            System.out.print(current + " ");
        }

        return current;
    }

    public static int fibonacciStreams(int n) {

        List<Integer> list = Stream.iterate(new int[]{0,1}, a -> new int[]{a[1], a[0]+a[1]} )
                .limit(n+1)
                .map(a -> a[0])
                .peek(a -> System.out.print(a + " "))
                .toList();

        return list.get(list.size()-1);
    }

}
