package com.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TerminalOperations {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
//      1. collect
        System.out.println("Display using the collect " + numbers.stream().collect(Collectors.toList()));

//      2. For Each
        System.out.print("Display using foreach of stream ");
        numbers.stream().forEach(x -> System.out.println(x + " "));

//      3. reduce : Combines Element to produce a single result it is also known as Accumulator
        System.out.println("Removing the average using reduce " + numbers.stream().reduce((a, b) -> a + b / 2));
//      4. Count
        System.out.println("Count Using Stream " + numbers.stream().count());

//      5.AnyMatch,allMatch,noneMatch
        List<String> names1 = Arrays.asList("Jawad", "Inam", "Awais", "Avez", "Bilal", "Salah", "Jawad", "Inam");
        System.out.println(names1.stream().anyMatch(x -> x.length() == 5));


//      6.findFirst,FindAny
        System.out.println(names1.stream().findFirst().get());
        System.out.println(names1.stream().findAny().get());

//      Examples
        List<Integer> example = Arrays.asList(5, 2, 9, 1, 6);
        System.out.println("Squaring and Sorting " + example.stream().map(x -> x * x).sorted().toList());
        System.out.println("Summing the values " + example.stream().reduce(Integer::sum).get());

        String sentence = "Hello World";
        System.out.println("No of occurrence of 'l' in sentence " + sentence.chars().filter(x -> x == 'l').count());

        System.out.println("Second highest is number " + numbers.stream().sorted((a, b) -> b - a).skip(1).limit(1).toList());

//      7.max ,min
        System.out.println("max is " + numbers.stream().max(Comparator.naturalOrder()).get());
        System.out.println("min is " + numbers.stream().min(Comparator.naturalOrder()).get());
        System.out.println("Modification in min is " + numbers.stream().min((a, b) -> b - a).get());

//      8. peek     (perform the action on each element as it is consumed)
        System.out.println("Printing using peak");
        Stream.iterate(1, x -> x + 1).limit(5).peek(System.out::println).count();

//      9.toArray
        Object[] array = Stream.iterate(1, x -> x + 1).limit(30).toArray();
        System.out.println("Converting Stream to Array " + Arrays.toString(array));

//      10.forEachOrder    (This is when the sequence is not ordered for eg in parallelStream the sequence is not maintain)
        List<Integer> Jawad = Stream.iterate(1, x -> x + 1).limit(20).toList();
        System.out.println("Using forEach method on parallel stream");
        Jawad.parallelStream().forEach(x -> System.out.print(x + " "));
        System.out.println("\nPrinting using forEachOrder stream");
        Jawad.parallelStream().forEachOrdered(x -> System.out.print(x + " "));

//      11.flatmap
        List<Integer> list = example.stream().flatMap(
                x -> Stream.of(x * 2)
        ).toList();
        System.out.println("\nprinting the orignal list before flatmap " + example);
        System.out.println("Printing using flatMap " + list);
    }
}