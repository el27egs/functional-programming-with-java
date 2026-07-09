package globant;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestMonjinCountChars {

    public static void main(String[] args) {

        List<String> strings = List.of("data","hello","world", "data","hello");
        Stream<String> stringStream = Stream.of("This ia long string for testing purposes");
        // data = 2
        // world = 1
        // hello = 2
        System.out.println(
                strings
                .stream()
                        .map(str -> str.split("\\s+"))
                        .flatMap(Arrays::stream)
                        .filter(s -> !s.isBlank())
                        .collect(Collectors.groupingBy(Function.identity(),Collectors.counting())));

        System.out.println(stringStream);
        System.out.println(
                stringStream.map(str -> str.split(""))
                .flatMap(Arrays::stream).
                collect(Collectors.groupingBy(Function.identity(),Collectors.counting())));

        "Spring".split("");

        List<String> courses = List.of("Spring", "Spring Boot", "API" , "Microservices","AWS", "PCF","Azure", "Docker", "Kubernetes");

        System.out.println(courses.stream().map(course -> course.split("")).flatMap(Arrays::stream).collect(Collectors.toList()));



        List<String> courses2 = List.of("Spring", "Spring Boot", "API" , "Microservices"," AWS", "PCF","Azure", "Docker", "Kubernetes");

        System.out.println(courses.stream().flatMap(course -> courses2.stream().map(course2 -> List.of(course,course2))).collect(Collectors.toList()));

    }
}
