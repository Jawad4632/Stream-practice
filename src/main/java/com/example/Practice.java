package com.example;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Practice {
    public static void main(String[] args) {
//       1. Filter Even Numbers
        List<Integer> number = Stream.iterate(1, i -> i + 1).limit(10).toList();
        System.out.println("Even no are " + number.stream().filter(e -> e % 2 == 0).toList());

//       2. Convert Strings to Uppercase
        List<String> alpha = List.of("alpha", "b", "c", "d", "e", "f", "g", "h", "alpha", "alpha");
        System.out.println("Converting through the stream " + alpha.stream().map(String::toUpperCase).toList());

//       3. Sort alpha List of Numbers in descending
        System.out.println("Descending integer are " + number.stream().sorted((o1, o2) -> o2 - o1).toList());

//       4. Count Strings Starting with 'A'
        System.out.println("Count String start with 'A' " + alpha.stream().filter(e -> e.toUpperCase().startsWith("A")).count());

//       5. Find Maximum and Minimum Numbers
        System.out.println("Max in the List is " + number.stream().max(Integer::compareTo).isPresent());
        System.out.println("Min in this List is " + number.stream().min(Integer::compareTo).isPresent());

//       6. Sum of Squares of Odd Numbers
        System.out.println("Sum of Squares of Odd Numbers " + number.stream().filter(x -> x % 2 != 0).map(x -> x * x).reduce(Integer::sum).isPresent());

//       7. Remove Duplicates from a List
        System.out.println("Remove Duplicates from a List " + alpha.stream().distinct().toList());

//       8. Find Second-Highest Number
        System.out.println("Find Second Highest Number " + number.stream().sorted(Comparator.naturalOrder()).skip(1).limit(1).findFirst().isPresent());

//       9. Average of all numbers
        System.out.println("Average calculate using Collector " + number.stream().collect(Collectors.averagingInt(x -> x)));
        System.out.println("Average is calculate using " + number.stream().mapToInt(x -> x).average().isPresent());

//       10. first find the square the  no should be greater than 100 then remove the average;
        List<Integer> integers = List.of(1, 10, 20, 30, 15);
        System.out.println("Number Square Average " + integers.stream().map(x -> x * x).filter(x -> x > 100).mapToInt(x -> x).average().isPresent());

//       11. Print Duplicate Numbers using Streams
        List<Integer> duplicate = List.of(1, 3, 10, 20, 30, 15, 1, 13, 1, 2, 2, 10, 30, 19, 3);
        System.out.println("Print Duplicate Numbers using Streams " + duplicate.stream().filter(e -> Collections.frequency(duplicate, e) > 1).collect(Collectors.toSet()));

    }
}
