package globant;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FizzBuzz {
    public static void main(String[] args) {

        int number = 5;

        printSteps(number);
        System.out.println("---------------");
        printStepsIA(number);

    }

    private static void printSteps(int number) {
        Stream.iterate(0, i -> i + 1)
                .limit(number+1)
                .map(
                        n -> {
                            if  (n % 3 == 0 && n % 5 == 0) {
                                return "globant.FizzBuzz";
                            }
                            else if (n % 3 == 0) {
                                return "Fizz";
                            }else  if (n % 5 == 0) {
                                return "Buzz";
                            }
                            return  String.valueOf(n);
                        })
                .forEach(System.out::println);

    }

    private static void printStepsIA(int number) {
        IntStream.rangeClosed(1, number)
                .mapToObj(n -> {
                    if (n % 15 == 0) return "globant.FizzBuzz";
                    if (n % 3 == 0) return "Fizz";
                    if (n % 5 == 0) return "Buzz";
                    return String.valueOf(n);
                })
                .forEach(System.out::println);

    }

}
