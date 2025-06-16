package com.example.interviewPractice;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Practice_4 {
    public static void main(String[] args) {
// Given a list of strings, group a list of strings by the first letter of each string using streams
        List<String> words = Arrays.asList("apple", "apricot", "banana", "blueberry", "cherry", "cantaloupe","Eggfruit");
        Map<Character, List<String>> collect = words.stream().map(String::toLowerCase)
                .collect(Collectors.groupingBy(word -> word.charAt(0)));
        System.out.println(collect);

// Given a list of strings, group a list of strings by the length of the string
        Map<Integer, List<String>> collect1 = words.stream().collect(Collectors.groupingBy(String::length));
        System.out.println(collect1);

// Given a list of strings, create a map where the key is the last letter of the string, and the value is a list of strings that start with that letter using streams
        Map<Character, List<String>> collect2 = words.stream()
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(word-> word.charAt(word.length()-1)));
        System.out.println(collect2);

// Given a list of strings, group the list of strings with vowels and no vowels into two lists
        List<String> words2 = Arrays.asList("apple", "sky", "pineapple", "myth","strawberry","try","cry","kiwi");
        Map<Boolean, List<String>> collect3 = words2.stream()
                .map(String::toLowerCase)
                .collect(Collectors.partitioningBy(str -> str.matches(".*[aeiou].*")));
        System.out.println(collect3);

// Given a list of strings print only the string elements excluding the digits using streams.
        List<String> words3 = List.of("apple", "12345", "123", "berry", "hello900", "kiwi", "44fly");
        words3.stream().
                filter(x-> !x.matches(".*[0-9].*"))
                .forEach(System.out::println);
// Given a list of strings find the first element having the length as 10 if not handle exceptions
        List<String> words4 = Arrays.asList("apple", "orange", "pineapple", "berry", "strawberry", "pappaya", "berry", "kiwi");
        words4.stream()
                .filter(word-> word.length()>=10)
                .findFirst()
                .ifPresentOrElse(System.out::println,()->System.out.println("Unknown"));
//  Given is the List of employee show first 2 digit of salary and remaining with ****
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", 25, LocalDate.of(1999, 6, 15),30000),
                new Employee("Bob", 30, LocalDate.of(1994, 3, 22),23000),
                new Employee("Charlie", 25, LocalDate.of(1999, 8, 10),80000),
                new Employee("David", 35, LocalDate.of(1989, 11, 5),780000),
                new Employee("Eve", 30, LocalDate.of(1994, 1, 30),7000),
                new Employee("Frank", 40, LocalDate.of(1984, 9, 12),400000)
        );

        employees.stream()
                .map(e-> String.valueOf(e.getSalary()).substring(0,2).concat("*****"))
                .forEach(System.out::println);
    }
}
