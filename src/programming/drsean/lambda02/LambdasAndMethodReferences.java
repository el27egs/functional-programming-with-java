package programming.lambda02;

import java.util.*;
import java.util.function.*;

public class LambdasAndMethodReferences {
    public static void main(String[] args) {
        staticMR();
        boundMR();
        unboundedMR();
        constructorMR();
    }

    private static void constructorMR() {
        Supplier<List<String>> supplier = () -> new ArrayList<>();
        List<String> listOfStrings = supplier.get();
        listOfStrings.add("Lambda");
        System.out.println(listOfStrings);

        Supplier<List<String>> supplierMR = ArrayList::new;
        listOfStrings = supplier.get();
        listOfStrings.add("Method Reference");
        System.out.println(listOfStrings);

        Function<Integer, List<String>> supplier2 = (i) -> new ArrayList<>(i);
        listOfStrings = supplier2.apply(10);
        listOfStrings.add("Lambda");
        System.out.println(listOfStrings);

        Function<Integer, List<String>> supplier2MR = ArrayList::new;
        listOfStrings = supplier2MR.apply(10);
        listOfStrings.add("Method Reference");
        System.out.println(listOfStrings);

    }

    private static void unboundedMR() {
        Predicate<String> isEmpty = (s) -> s.isEmpty();
        System.out.println("\"\" is Empty ? " + isEmpty.test(""));
        System.out.println("\"xyz\" is Empty ? " + isEmpty.test("xyz"));

        Predicate<String> isEmptyMR = String::isEmpty;
        System.out.println("\"\" is Empty ? " + isEmpty.test(""));
        System.out.println("\"xyz\" is Empty ? " + isEmpty.test("xyz"));

        BiPredicate<String,String> biPredicate = (s1,s2)-> s1.startsWith(s2);
        System.out.println("\"Mr. Joe Bloggs\" starts with \"Mr.\"? " + biPredicate.test("Mr. Joe Bloggs","Mr."));
        System.out.println("\"Mr. Joe Bloggs\" starts with \"Ms.\"? " + biPredicate.test("Mr. Joe Bloggs","Ms."));

        BiPredicate<String,String> biPredicateMR = String::startsWith;
        System.out.println("\"Mr. Joe Bloggs\" starts with \"Mr.\"? " + biPredicateMR.test("Mr. Joe Bloggs","Mr."));
        System.out.println("\"Mr. Joe Bloggs\" starts with \"Ms.\"? " + biPredicateMR.test("Mr. Joe Bloggs","Ms."));

    }

    private static void boundMR() {
        String name = "Mr. Joe Bloggs";
        Predicate<String> predicate = (s) -> name.startsWith(s);
        System.out.println(name + " starts with Mr ? " + predicate.test("Mr"));
        System.out.println(name + " starts with Ms ? " + predicate.test("Ms"));

        Predicate<String> predicateMR = name::startsWith;
        System.out.println(name + " starts with Mr ? " + predicateMR.test("Mr"));
        System.out.println(name + " starts with Ms ? " + predicateMR.test("Ms"));


    }

    private static void staticMR() {
        List<Integer> listOfInteger = new ArrayList<>(Arrays.asList(1, 2, 7, 4, 5));
        Consumer<List<Integer>> consumer = (l) -> Collections.sort(l);
        System.out.println("BEFORE list : " + listOfInteger);
        consumer.accept(listOfInteger);
        System.out.println("AFTER list : " + listOfInteger);

        listOfInteger = new ArrayList<>(Arrays.asList(1, 2, 7, 4, 5));
        Consumer<List<Integer>> consumerMR = Collections::sort;
        System.out.println("BEFORE list : " + listOfInteger);
        consumerMR.accept(listOfInteger);
        System.out.println("AFTER list : " + listOfInteger);

        listOfInteger = new ArrayList<>(Arrays.asList(1, 2, 7, 4, 5));
        Comparator<Integer> comparator = Integer::compareTo;

        BiConsumer<List<Integer>,Comparator<Integer>> biConsumerMR = Collections::sort;
        System.out.println("BEFORE list : " + listOfInteger);
        biConsumerMR.accept(listOfInteger, comparator.reversed());
        System.out.println("AFTER list : " + listOfInteger);

    }
}
