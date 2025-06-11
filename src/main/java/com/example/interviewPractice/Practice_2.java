package com.example.interviewPractice;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Practice_2 {
    public static void main(String[] args) {
//        1. Remove all vowels from a string
        String vowel = "HelloWorld";
        String collect1 = vowel.chars()
                .mapToObj(c -> String.valueOf(Character.toLowerCase((char) c)))
                .filter("aeiou"::contains)
                .collect(Collectors.joining());

        System.out.println(collect1);

//        2. Convert a list of strings to uppercase using Stream
        List<String> listString = List.of("JAwad", "Inanm", "lion", "tiger");
        listString.stream().map(String::toUpperCase).toList();
        System.out.println(listString);

//        to upper case each character
        String collect2 = vowel.chars().mapToObj(c -> String.valueOf(Character.toUpperCase((char) c))).collect(Collectors.joining());
        System.out.println(collect2);

//        3. Count the frequency of each word in a string
        String Str = "java python java html";
        Map<String, Long> collect = Arrays.stream(Str.split(" ")).collect(Collectors.groupingBy(str -> str, Collectors.counting()));
        System.out.println(collect);

//        4. Find the occurrence of each character in a string
        Map<String, Long> collect3 = Str.chars().mapToObj(c -> String.valueOf(Character.toUpperCase((char) c))).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect3);


// 5. Find the length of each word in a string
        String leg = "Java is good and oops are strong java Good";
        Map<String, Long> collect4 = Arrays.stream(leg.split(" "))
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
        System.out.println(collect4);
// 6. First non-repeating character in a string
        String non = "swiss";
        Optional<Character> first = non.chars()
                .mapToObj(x -> Character.toUpperCase((char) x))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst();

        System.out.println(first);
// 7. First repeating character in a string
        String repeat = "Programming";
        repeat.chars()
                .mapToObj(x -> Character.toUpperCase((char) x))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() != 1)
                .map(Map.Entry::getKey)
                .forEach(System.out::println);

// 8. Find the second highest element in an array
        int[] arr = {23, 45, 67, 23, 21, 56, 10};

        Arrays.stream(arr)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .limit(1)
                .forEach(System.out::println);

// 9. Longest string in an array
        String[] str = {"jawad", "mustakim", "ziya", "IzharAhmed", "wasaf"};
        Map.Entry<String, Integer> max = Arrays.stream(str)
                .collect(Collectors.toMap(Function.identity(), String::length))
                .entrySet()
                .stream()
                .max(Comparator.comparingInt(Map.Entry::getValue))
                .orElseThrow(() -> new RuntimeException("No Sting found"));

        System.out.println(max);
// 10. Sum of digits from a number: int number = 1234563
        int number = 1234563;
        int sum = String.valueOf(number)
                .chars()
                .map(Character::getNumericValue)
                .sum();

        System.out.println(sum);

// 11. Count total occurrences of a specific word from a list
        List<String> words = Arrays.asList(
                "apple", "banana", "apple", "orange", "banana", "apple",
                "grape", "apple", "orange", "banana", "grape", "apple",
                "apple", "banana", "orange"
        );

        Map<String, Long> collect5 = words.stream()
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
        System.out.println(collect5);

    }

}
