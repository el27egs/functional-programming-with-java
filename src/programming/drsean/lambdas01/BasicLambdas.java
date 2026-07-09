package programming.drsean.lambdas01;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;


public class BasicLambdas {
    public static void main(String[] args) {
        consumer();
        supplier();
        predicate();
        function();
        List<Person> listPeople = getPeople();
        sortAge(listPeople);
        sortName(listPeople);
        sortHeight(listPeople);

    }

    private static void sortHeight(List<Person> listPeople) {
        listPeople.sort(Comparator.comparing(Person::getHeight));
        System.out.println("Order by height ascending");
        listPeople.forEach(p -> System.out.println(p));
    }

    private static void sortName(List<Person> listPeople) {
        listPeople.sort(Comparator.comparing(Person::getName));
        System.out.println("Order by name ascending");
        listPeople.forEach(p -> System.out.println(p));
    }

    private static void sortAge(List<Person> listPeople) {
        listPeople.sort(Comparator.comparing(Person::getAge));
        System.out.println("Order by age ascending");
        listPeople.forEach(p -> System.out.println(p));
    }

    private static List<Person> getPeople() {
        List<Person> result = new ArrayList<>();
        result.add(new Person("Mike", 33, 1.8));
        result.add(new Person("Mary", 25, 1.4));
        result.add(new Person("Alan", 34, 1.7));
        result.add(new Person("Zoe", 30, 1.5));
        return result;
    }

    private static void function() {
        Functionable<Integer, String> functionable = (i) -> "Number is: " + i;
        System.out.println(functionable.applyThis(25));
        Function<Integer, String> function = (i) -> "Number is: " + i;
        System.out.println(function.apply(25));
    }

    private static void predicate() {
        Evaluate<Integer> evaluate = (i) -> i < 0;
        System.out.println("-1 evaluate to " + evaluate.isNEgative(-1));
        System.out.println("+1 evaluate to " + evaluate.isNEgative(1));

        Predicate<Integer> predicate = (i) -> i < 0;
        System.out.println("-1 evaluate to " + predicate.test(-1));
        System.out.println("+1 evaluate to " + predicate.test(1));

        Predicate<Integer> isEven = (i) -> (i % 2) == 0;
        System.out.println("4 is even ? " + check(4, isEven));
        System.out.println("7 is even ? " + check(7, isEven));

        Predicate<String> startWithMr = (s) -> s.startsWith("Mr");
        System.out.println("Mr. Joe Bloggs starts with Mr ? " + check("Mr. Joe Bloggs", startWithMr));
        System.out.println("Ms. Ann Bloggs starts with Mr ? " + check("Mr. Joe Bloggs", startWithMr));

        Person mike = new Person("Mike", 33, 1.8);
        Person ann = new Person("Ann", 13, 1.4);
        Predicate<Person> isAdult = (p) -> p.getAge() >= 18;
        System.out.println("is Mike adult ? " + check(mike, isAdult));
        System.out.println("is Ann adult ? " + check(ann, isAdult));


    }

    private static <T> boolean check(T t, Predicate<T> predicate) {
        return predicate.test(t);
    }

    private static void supplier() {
        Retrievable<Integer> retrievable = () -> 77;
        System.out.println(retrievable.retrieve());
        Supplier<Integer> supplier = () -> 77;
        System.out.println(supplier.get());
    }

    private static void consumer() {
        Printable<String> printable = System.out::println;
        printable.print("Printable lambda");
        Consumer<String> consumer1 = (s) -> System.out.println(s);
        consumer1.accept("Printable lambda");
        Consumer<String> consumer2 = System.out::println;
        consumer2.accept("Printable lambda");
    }

}
