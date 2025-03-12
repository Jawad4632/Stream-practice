package com.example;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class QuestionGropingBy {
    public static void main(String[] args) {
//      Find the Most Frequent Word in a List
        List<String> words = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");
        Map<String, Long> collect = words.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        String key = Collections.max(collect.entrySet(), Map.Entry.comparingByValue()).getKey();
        System.out.println(key);

//      Grouping Names by First Letter
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "Anna", "David", "Daniel");
        Map<Character, Long> collect1 = names.stream().collect(Collectors.groupingBy(x -> x.charAt(0), Collectors.counting()));
        System.out.println(collect1);

//      Counting Word Frequency
        System.out.println(words.stream().sorted(Collections.reverseOrder()).collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));

//      Grouping Numbers as Even & Odd
        Stream<Integer> limit = Stream.iterate(100, x -> (x - 1)).limit(100);
        System.out.println(limit.collect(Collectors.groupingBy(x -> x % 2 == 0 ? "even" : "odd")));

    }
}
