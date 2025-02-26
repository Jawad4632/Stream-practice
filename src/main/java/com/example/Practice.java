package com.example;

import java.util.Comparator;
import java.util.List;
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
        System.out.println("Max in the List is " + number.stream().max(Integer::compareTo).get());
        System.out.println("Min in this List is " + number.stream().min(Integer::compareTo).get());

//       6.Sum of Squares of Odd Numbers
        System.out.println("Sum of Squares of Odd Numbers " + number.stream().filter(x -> x % 2 != 0).map(x -> x * x).reduce(Integer::sum).get());

//       7.Remove Duplicates from a List
        System.out.println("Remove Duplicates from a List" + alpha.stream().distinct().toList());

//        8.Find Second-Highest Number
        System.out.println("Find Second Highest Number " + number.stream().sorted(Comparator.naturalOrder()).skip(1).limit(1).findFirst().get());

    }
}
