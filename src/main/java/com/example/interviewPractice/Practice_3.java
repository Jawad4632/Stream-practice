package com.example.interviewPractice;

import java.util.*;

public class Practice_3 {
    public static void main(String[] args){
//➡️ Java 8 Program to Remove Duplicate Elements from a List and maintain the order
        List<String> inputList = Arrays.asList(
                "apple", "banana", "apple", "orange", "banana", "grape", "apple"
        );

        Collection<String> collect = new LinkedHashSet<>(inputList);
        System.out.println(collect);


//➡️ Reverse Each Word of String using Java 8 Stream
//➡️ Java 8 Program to Find the Second Largest Number in the List of Integers
        List<Integer> numbers = Arrays.asList(12, 45, 1, 33, 45, 7, 99, 102, 99);
        Integer i = numbers.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .limit(1)
                .findFirst()
                .orElse(null);
        System.out.println(i);
//➡️ Java 8 Program to Find the Maximum Number and Minimum Number in a List
//➡️ Sort Employee Objects by Salary using Lambda
//➡️ Java 8 Program to Find the Sum of All Digits of a Number
//➡️ Java 8 Program to Find the Frequency of Each Character in a Given String
//➡️ Java 8 Program to Find the Maximum Number and Minimum Number in a List
//➡️ Java 8 Program to Print Even Numbers from a List
        List<Integer> even = Arrays.asList(3, 12, 7, 18, 5, 20, 15, 8, 6);
        even.stream()
                .filter(x -> x % 2 == 0)
                .forEach(System.out::println);

//➡️ Find the Square of the First Three Even Numbers using Java     8 Stream
//➡️ Find the Average of a Given List of Numbers using Java 8 Stream
//➡️ Convert a List of Strings to Uppercase and Lowercase using Java 8 Stream
//➡️ Collectors groupingBy - Group Employees By Age
//➡️ Java 8 Program to Find the Age of a Person if the Birthday Date has Given
//➡️ Sort the List of Strings in Ascending and Descending Order using Java 8 Stream
    }
}
