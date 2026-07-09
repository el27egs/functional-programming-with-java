package programming.drsean.streams;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Excercise {
    public static void main(String[] args) {

        /*
            (QID 2.2023)
         */
        IntStream intStream = IntStream.range(0, 5);
        System.out.print("Average range 0...5 is " + intStream.average());
        System.out.println("\n===== \n");

        /*
            (QID Q2.1762)
         */

        List<Item> itemList = new ArrayList<>(List.of(new Item(1, "Screw"), new Item(2, "Nail"), new Item(3, "Bolt")));
        itemList.stream().sorted(Comparator.comparing(Item::getName)).forEach(System.out::print);
        System.out.println("\n===== \n");

        /*
             (QID 2.1787)
         */
        Stream<List<String>> streamWithCChars = Stream.of(Arrays.asList("a", "b"), Arrays.asList("a", "c"), Arrays.asList("d", "c"));
        streamWithCChars
                .filter(l -> l.contains("c"))
                .flatMap(l -> l.stream())
                .forEach(System.out::print);
        System.out.println("\n===== \n");

         /*
             (QID 2.1738)
         */
        List<Integer> integerList = Arrays.asList(1, 2, 3);
        System.out.println("the sum is " + integerList.stream().mapToInt(n -> n).sum());
        integerList = Arrays.asList(1, 2, 3);
        System.out.println("the max is " + integerList.stream().mapToInt(n -> n).max().getAsInt());
        List<Person> personList = Arrays.asList(
                new Person("Alan", "Burke", 22),
                new Person("Zoe", "Peters", 20),
                new Person("Peter", "Castle", 29));
        Person oldestPerson = personList
                .stream()
                .max(Comparator.comparing(Person::getAge)).get();
        System.out.println("oldest person is " + oldestPerson);
        integerList = Arrays.asList(10, 47, 33, 23);
        int reduceValue1 = integerList.stream().reduce((n1, n2) -> n1 + n2).get();
        int reduceValue2 = integerList.stream().reduce(0, (n1, n2) -> n1 + n2);
        System.out.println("Reduce, val1 vs val2 = " + reduceValue1 + " vs " + reduceValue2);
        System.out.println("\n===== \n");

        /*
            (QID 2.1826)
         */

        Optional<String> grade1 = getGrade(50);
        Optional<String> grade2 = getGrade(55);
        System.out.println("grade1 has " + grade1.orElse("UNKNOWN"));
        if (grade2.isPresent()) {
            grade2.ifPresent(System.out::print);
        } else {
            System.out.println("grade2 has " + grade2.orElse("Empty"));
        }
        System.out.println("\n===== \n");

        /*
            QID 2.1809
         */

        List<Book> bookList = Arrays.asList(
                new Book("Thinking in Java", 30.0),
                new Book("Java in 24 hrs", 20.0),
                new Book("Java Recipes", 10.0));

        double avgPrice = bookList
                .stream()
                .filter(b -> b.getPrice() > 10.0)
                .mapToDouble(Book::getPrice)
                .average().orElse(0.0);
        System.out.println("average price for books is " + avgPrice);
        System.out.println("\n===== \n");

        /*
            QID 2.1846)
         */

        bookList = Arrays.asList(
                new Book("Atlas Shrugged", 10.0),
                new Book("Freedom at Midnight", 5.0),
                new Book("Gone with the wind", 5.0));

        Map<String, Double> bookMap =
                bookList.stream().collect(Collectors.toMap(Book::getTitle, Book::getPrice));

        bookMap.forEach((k, v) -> {
            if (k.startsWith("A")) {
                System.out.print("Title:" + k + ", Price: " + v);
            }
        });
        System.out.println("\n===== \n");

        /*
            QID 2.1847
         */

        bookList = Arrays.asList(
                new Book("Gone with the wind", 10.0),
                new Book("Gone with the wind", 15.0),
                new Book("Atlas Shrugged", 5.0));

        bookMap =
                bookList.stream().collect(Collectors.toMap(Book::getTitle, Book::getPrice, (v1, v2) -> v1 + v2));
        bookMap.forEach((k, v) -> {
            System.out.println("Title:" + k + ", Price: " + v);
        });
        System.out.println("\n===== \n");

        /*
            QID 2.1810
         */

        personList = Arrays.asList(
                new Person("Bol", "", 31),
                new Person("Paul", "", 32),
                new Person("John", "", 33));

        double avgAge = personList
                .stream()
                .filter(p -> p.getAge() < 30)
                .mapToInt(p -> p.getAge())
                .average().orElse(0.0);
        System.out.println("Average Age is " + avgAge);
        System.out.println("\n===== \n");

        /*
            QID 2.1849
         */

        Optional<Double> price = Optional.ofNullable(20.0);
        price.ifPresent(p -> System.out.println("ifPresent price " + p));
        System.out.println("orElse price " + price.orElse(0.0));
        System.out.println("orElseGet price " + price.orElseGet(() -> 0.0));

        Optional<Double> price2 = Optional.ofNullable(null);
        if (price2.isEmpty()) {
            System.out.println("price2 is empty");
        }
        price2.ifPresent(p -> System.out.println("price2 is " + p)); //NO OUTPUT
        Double x = price2.orElse(44.0);
        System.out.println("price2 x =  " + x);

        Optional<Double> price3 = Optional.ofNullable(null);

        //Double z = price3.orElseThrow(() -> new RuntimeException("Bad Code"));
        //System.out.println("price3 z =  " + z);

        System.out.println("\n===== \n");

        /*
            (QID 2.1858)
         */

        List<AnotherBook> anotherBookList =
                Arrays.asList(
                        new AnotherBook("Gone with the wind", "Fiction"),
                        new AnotherBook("Bourne Ultimatum", "Thriller"),
                        new AnotherBook("The Client”", "Thriller")

                );
        List<String> genreList = new ArrayList<>();

        genreList = anotherBookList
                .stream()
                .map(b -> b.getGenre())
                .collect(Collectors.toList());
        System.out.println("Genders " + genreList);
        System.out.println("\n===== \n");

        /*
            (QID 2.2024)
         */

        double sum = DoubleStream.of(0, 2, 4).filter(n -> n % 2 != 0).sum();
        System.out.println("Sum  " + sum);

        double safeAvg = Stream.of(1.0, 3.0)
                .mapToDouble(n -> n)
                .filter(n -> n % 2 != 0).average().orElse(0.0);
        System.out.println("avg  " + safeAvg);

        System.out.println("\n===== \n");

        /*
            (QID 2.1840)
         */
        List<Integer> ls = Arrays.asList(11, 11, 22, 33, 33, 55, 66);
        boolean foundEleven = ls.stream().distinct().anyMatch(n -> n == 11);
        System.out.println("foundEleven?  " + foundEleven);
        boolean AreAllMultipleOfEleven = ls.stream().noneMatch(n -> (n % 11) > 0);
        System.out.println("AreAllMultipleOfEleven?  " + AreAllMultipleOfEleven);

        System.out.println("\n===== \n");

        /*
            (QID 2.1841)
         */

        AtomicInteger ai = new AtomicInteger(); // initial value of 0
        Stream.of(11, 11, 22, 33)
                .parallel()
                .filter(n -> {
                    ai.incrementAndGet();
                    return n % 2 == 0;
                });
        System.out.println(ai); // no terminal operator was executed

        AtomicInteger ai2 = new AtomicInteger(); // initial value of 0
        Stream<Integer> stream = Stream.of(11, 11, 22, 33).parallel();
        Stream<Integer> stream2 = stream.filter(e -> {
            ai2.incrementAndGet();
            return e % 2 == 0;
        });
        stream2.forEach(System.out::println);// java.lang.IllegalStateException
        System.out.println(ai);


    }

    public static Optional<String> getGrade(int marks) {
        Optional<String> grade = Optional.empty();

        if (marks > 50) {
            grade = Optional.of("PASS");
        } else {
            grade.of("FAIL");// Optionals are immutable, it is not re-assigning it
        }
        return grade;
    }

}
