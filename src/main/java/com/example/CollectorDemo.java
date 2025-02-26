package com.example;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorDemo {
    public static void main(String[] args) {

//        1.Collecting to List
        List<String> names = Arrays.asList("Jawad", "Inam", "Awais", "Avez", "Bilal", "Salah", "Jawad", "Inam", "Awais");
        List<String> result = names
                .stream()
                .filter(x -> x.length() == 5)
                .collect(Collectors.toList());
        System.out.println(result);

//        2.Collecting to Set
        Set<String> set = result.stream().collect(Collectors.toSet());
        System.out.println(set);

//        3.Collection to specific Collection
        ArrayDeque arrayDeque = set.stream().collect(Collectors.toCollection(ArrayDeque::new));
        System.out.println(arrayDeque.getClass().getName());

//        4.Joining the String
        String s = names.stream().collect(Collectors.joining());
        System.out.println("If we are not passing anytjing in join \n" + s);
        String m = names.stream().collect(Collectors.joining("@"));
        System.out.println("After joining '@' in delimiter \n" + m);


//       5.Collection GroupingBy
        List<String> names2 = List.of("Anna", "Bob", "Alexander", "Brian", "Alice");
        Map<Integer, List<String>> collect = names2.stream().collect(Collectors.groupingBy(String::length));
        System.out.println(collect);

        Map<Integer, String> collect1 = names2.stream().collect(Collectors.groupingBy(String::length, Collectors.joining(", ")));
        System.out.println(collect1);

//        maths operation (Different Operations)
        List<Integer> list = Stream.iterate(1, x -> x + 1).limit(10).toList();
        System.out.println("Total counting " + list.stream().collect(Collectors.counting()));
        System.out.println("Average counting " + list.stream().collect(Collectors.averagingInt(x -> x)));
        System.out.println("min by using collection " + list.stream().collect(Collectors.minBy(Comparator.naturalOrder())).get());
        System.out.println("max by using collection " + list.stream().collect(Collectors.maxBy(Comparator.naturalOrder())).get());

//       If you want you to do in one maths function
        IntSummaryStatistics collect2 = list.stream().collect(Collectors.summarizingInt(x -> x));
        System.out.println("getting the max by single collection" + collect2.getMax());
        System.out.println("getting the min by single collection" + collect2.getMin());
        System.out.println("getting the average by single collection" + collect2.getAverage());
        System.out.println("getting the sum by single collection" + collect2.getSum());


//        Practice set
        String Sentences = "Hello World Hello Java World";
        Map<String, Long> collect3 = Arrays.stream(Sentences.split(" ")).collect(Collectors.groupingBy(x -> x, Collectors.counting()));
        System.out.println(collect3);

        Map<Boolean, List<Integer>> collect4 = list.stream().collect(Collectors.partitioningBy(x -> x % 2 == 0));
        System.out.println(collect4);

    }
}
