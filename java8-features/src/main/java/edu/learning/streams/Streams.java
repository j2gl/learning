package edu.learning.streams;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Streams {

    private static String[] NAMES = {"John", "Doe", "Mary", "Smith", "Dave", "Smith", "Jane", "Stuart", "Tom", "Wright",
            "Robinson", "Nicole", "Jacobs", "Jane", "Wright", "Jane", "Doe", "Kurt", "Wright", "Kurt", "Jane",
            "Jenkins", "Neil", "Tom", "Patterson", "Sam", "Jenkins",
            "Maggie", "Patterson", "Maggie", "Jane", "Doe", "Patterson", "Dave", "Smith", "Sam",
            "Kurt", "Jefferson", "Sam", "Jane", "Dave", "Davis", "Sam", "Patterson",
            "Tom", "Jefferson", "Jane", "Maggie", "Jefferson", "Mary", "Neil", "Patterson",
            "Corey", "Davis", "Steve", "Jacobs", "Jane", "Jenkins", "John", "Jacobs", "Neil", "Smith", "Corey",
            "Wilks", "Corey", "Smith", "Mary", "Patterson", "Jane", "Travis", "Arnold", "John",
    };

    private static void doStream01() {
        IntStream.range(1, 10)
                .forEach(System.out::print);
        System.out.println();
    }

    private static void doStream02() {
        IntStream.range(1, 10)
                .skip(5)
                .forEach(System.out::print);
        System.out.println();
    }

    private static void doStream03() {
        System.out.println(
            IntStream.range(1, 5)
                .sum()
        );
    }

    private static void doStream04() {
        Stream.of("John", "Johnny", "Jospeph")
                .sorted()
                .findFirst()
                .ifPresent(System.out::println);
        System.out.println();
    }

    private static void doStream05() {
        Arrays.stream(NAMES)
                .filter(s -> s.startsWith("J"))
                .sorted()
                .findFirst()
                .ifPresent(System.out::println);
        System.out.println();
    }

    private static void doStream06() {
        Arrays.stream(new int[] {2, 4, 6, 8, 10})
                .map(x -> x * x)
                .forEach(System.out::println);
    }

    private static void doStream07() throws IOException, URISyntaxException {
        Stream<String> names = Files.lines(Paths.get(ClassLoader.getSystemResource("names.txt").toURI()));
        names.sorted()
                .filter(x -> x.length() > 5)
                .distinct()
                .forEach(System.out::println);
        names.close();
        System.out.println();
    }

    private static void doStream08() throws IOException, URISyntaxException {
        List<String> names = Files.lines(Paths.get(ClassLoader.getSystemResource("names.txt").toURI()))
                .filter(x -> x.contains("son"))
                .distinct()
                .map(x -> x.split(","))
                .map(x -> x[0] + " " + x[1])
                .collect(Collectors.toList());
        names.forEach(System.out::println);
        System.out.println();
    }

    private static void doStream09() throws IOException, URISyntaxException {
        Stream<String> stream = Files.lines(Paths.get(ClassLoader.getSystemResource("data.csv").toURI()));

        stream.map(x -> x.split(","))
                .filter(x -> x.length == 3)
                .filter(x -> Integer.parseInt(x[1]) > 12)
                .forEach(x -> System.out.println(x[0] + " " + x[1] + " " + x[2]));
        stream.close();
        System.out.println();
    }

    private static void doStream10() throws IOException, URISyntaxException {
        // Map
        Stream<String> stream = Files.lines(Paths.get(ClassLoader.getSystemResource("data.csv").toURI()));

        Map<String, Integer> map = stream
                .map(x -> x.split(","))
                .filter(x -> x.length == 3)
                .filter(x -> Integer.parseInt(x[1]) > 11)
                .collect(Collectors.toMap(
                        x -> x[0],
                        x -> Integer.parseInt(x[1])
                ));
        stream.close();

        for (String s : map.keySet()) {
            System.out.println(s + " -> " + map.get(s));
        }

        System.out.println();
    }

    private static void doStream11() {
        // Reduce
        double total = Stream.of(30.5, 84.9, 12.6)
                .reduce(0.0, Double::sum);
        System.out.println("Sum: " + total);
    }

    private static void doStream12() {
        // Summary Statistics
        IntSummaryStatistics summaryStatistics = IntStream.of(2, 4, 6, 8, 10, 13, 14, 7, 7, 1, 3, 6, 8)
                .summaryStatistics();
        System.out.println(summaryStatistics);

    }

    public static void main(String[] args) {
        try {
            doStream01();
            doStream02();
            doStream03();
            doStream04();
            doStream05();
            doStream06();
            doStream07();
            doStream08();
            doStream09();
            doStream10();
            doStream11();
            doStream12();
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
