package com.example.interviewPractice;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Practice_1 {

    public static boolean isPrime(int no){
        if(no <= 1){
            return false;
        }
        if(no == 2){
            return true;
        }
        for (int i = 2; i <= no; i++) {
            if(no % i == 0){
                return false;
            }
            return true;
        }
        return true;
    }
    public static void main(String[] args) {
        // write the java program to find the length and count of String in a List
        List<String> og = Arrays.asList("apple", "bat", "cat", "banana", "dog");
        Map<Integer, Long> collect = og.stream().collect(Collectors.groupingBy(String::length, Collectors.counting()));
        System.out.println(collect);

        // suppose you have the string you want to find the  unique type and print
        String str = "Java is powerful and java is versatile";
        Set<String> collect1 = Arrays.stream(str.split(" ")).
                map(String::toLowerCase)
                .collect(Collectors.toSet());
        System.out.println(collect1);

        // find all the number starting with 1 using stream
        List<Integer> l1 = Arrays.asList(10, 21, 13, 41, 15, 2, 1, 100, 23);
        List<Integer> list = l1.stream().filter(x -> String.valueOf(x).startsWith("1")).toList();
        System.out.println("List of number starting with 1 " + list);

        // find all the number not starting with 1 using stream
        List<Integer> list1 = l1.stream().filter(x -> !String.valueOf(x).startsWith("1")).toList();
        System.out.println("List of number not starting with 1 " + list1);

        //combine two stream
        List<Integer> list2 = Arrays.asList(10, 1, 100, 23);
        List<Integer> list3 = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println("Concat stream is ");
        Stream.concat(list2.stream(), list3.stream()).forEach(System.out::println);


//      concat and reverse order in descending order
        List<Integer> list4 = Stream.concat(list2.stream(), list3.stream())
                .sorted(Collections.reverseOrder())
                .toList();
        System.out.println(list4);

//        To get the prime no;
        System.out.println("Prime no are ");
        Stream.iterate(0, x -> x + 1).limit(10)
                .filter(Practice_1::isPrime)
                .forEach(System.out::println);

    }

}
