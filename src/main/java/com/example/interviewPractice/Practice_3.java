package com.example.interviewPractice;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Practice_3 {
    public static void main(String[] args){
//➡️ Java 8 Program to Remove Duplicate Elements from a List and maintain the order
        List<String> inputList = Arrays.asList(
                "apple", "banana", "apple", "orange", "banana", "grape", "apple"
        );

        Collection<String> collect = new LinkedHashSet<>(inputList);
        System.out.println(collect);


//➡️ Reverse Each Word of String using Java 8 Stream
        String str = "java is a good programming language";
        List<String> list3 = Arrays.stream(str.split(" "))
                .map(x -> new StringBuilder(x).reverse().toString())
                .toList();

        System.out.println("String in reverse order "+list3);

//➡️ Java 8 Program to Find the Second Largest Number in the List of Integers
        List<Integer> numbers = Arrays.asList(12, 45, 1, 33, 45, 7, 99, 102, 99);
        Integer i = numbers.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .limit(1)
                .findFirst()
                .orElse(null);
        System.out.println("Second Largest value "+i);
//➡️ Java 8 Program to Find the Maximum Number and Minimum Number in a List
        List<Integer> minmax = Arrays.asList(25, 47, 12, 99, 3, 56, 78, 1, 89, 34);
        Optional<Integer> max = minmax.stream()
                .distinct()
                .max(Comparator.comparingInt(Integer::intValue));
        System.out.println("Max value is "+max.orElse(null));

        Optional<Integer> min = minmax.stream()
                .distinct()
                .min(Comparator.comparingInt(Integer::intValue));
        System.out.println("Min value is "+min.orElse(null));

//➡️ Java 8 Program to Find the Sum of All Digits of a Number
      int number = 820848662;
        int sum = String.valueOf(number)
                .chars()
                .map(Character::getNumericValue)
                .sum();
        System.out.println("Sum is "+sum);

//➡️ Java 8 Program to Find the Frequency of Each Character in a Given String
        String freq="Java programming is fun";
        Map<Character, Long> collect1 = freq.chars()
                .mapToObj(c -> Character.toUpperCase((char) c))
                .filter(c->!Character.isWhitespace(c))
                .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new, Collectors.counting()));
        System.out.println("Frequency of each character in String "+collect1);

//➡️ Java 8 Program to Find the Maximum Number and Minimum Number in a List
        List<Integer> mm = Arrays.asList(15, 42, 7, 89, 23, 56, 91, 3, 68, 34);
        IntSummaryStatistics statistics = mm.stream()
                .collect(Collectors.summarizingInt(Integer::intValue));

        System.out.println("Max value is "+statistics.getMax());
        System.out.println("Min value is "+statistics.getMin());

//➡️ Find the Average of a Given List of Numbers using Java 8 Stream
        System.out.println("Avg value is "+statistics.getAverage());

//➡️ Java 8 Program to Print Even Numbers from a List
        List<Integer> even = Arrays.asList(3, 12, 7, 18, 5, 20, 15, 8, 6);
        List<Integer> list = even.stream()
                .sorted(Comparator.naturalOrder())
                .filter(x -> x % 2 == 0)
                .toList();
        System.out.println("Even list is "+list);

//➡️ Find the Square of the First Three Even Numbers using Java  8 Stream
        List<Integer> first = Arrays.asList(4, 7, 10, 15, 2, 8, 12, 5, 18, 20);
        List<Integer> collect2 = first.stream()
                .filter(x -> x % 2 == 0)
                .limit(3)
                .map(x -> x * x)
                .toList();
        System.out.println("First 3 even no square is  "+collect2);

//➡️ Convert a List of Strings to Uppercase and Lowercase using Java 8 Stream
        List<String> words = Arrays.asList("hello", "world", "java", "stream", "coding");
        words.stream()
                .map(word -> word.toLowerCase() + " | " + word.toUpperCase())
                .forEach(System.out::println);

//➡️ Collectors groupingBy - Group Employees By Age
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", 25, LocalDate.of(1999, 6, 15),30000),
                new Employee("Bob", 30, LocalDate.of(1994, 3, 22),23000),
                new Employee("Charlie", 25, LocalDate.of(1999, 8, 10),80000),
                new Employee("David", 35, LocalDate.of(1989, 11, 5),780000),
                new Employee("Eve", 30, LocalDate.of(1994, 1, 30),7000),
                new Employee("Frank", 40, LocalDate.of(1984, 9, 12),400000)
        );

        Map<Integer, List<Employee>> collect3 = employees.stream()
                .collect(Collectors.groupingBy(Employee::getAge));

        System.out.println("Group By Age"+collect3);
//➡️ Java 8 Program to Find the Age of a Person if the Birthday Date has Given
        String birthDate = "1994-01-30";
              employees.stream()
                .filter(x -> x.getBirthDate().equals(LocalDate.parse(birthDate)))
                .findFirst()
                .ifPresentOrElse(e->System.out.println(e.getName()+" "+e.getAge()),
                        ()->System.out.println("No employee found with this birth date.")
                );
//➡️ Sort the List of Strings in Ascending and Descending Order using Java 8 Stream
        List<String> sort = Arrays.asList("banana", "apple", "cherry", "mango", "blueberry", "grape");
        List<String> list1 = sort.stream()
                .sorted(Comparator.reverseOrder())
                .toList();
        System.out.println("Descending order is "+list1);

        List<String> list2 = sort.stream()
                .sorted(Comparator.naturalOrder())
                .toList();
        System.out.println("Ascending order is "+list2);

//➡️ Sort Employee Objects by Salary using Lambda
        List<Employee> list4 = employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary))
                .toList();
        System.out.println("In sorted order order is "+list4);


    }
}
