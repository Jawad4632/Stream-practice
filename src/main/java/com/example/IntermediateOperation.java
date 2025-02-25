package com.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IntermediateOperation {

    public static void main(String[] args) {

        //Intermediate operation transform a stream into another stream
        // They are lazy, meaning they don't execute until a terminal operation is invoked


        //1.Filter
        List<String> names = Arrays.asList("Jawad", "Inam", "Awais", "Avez", "Bilal", "Salah");
        Stream<String> filter = names.stream().filter(x -> x.toLowerCase().startsWith("a"));
        System.out.println("Name are filter with name start with 'a' : " +filter.collect(Collectors.toList()));

        //2.Map
        System.out.println("Names are Made to UpperCase using Map "+names.stream().map(String::toUpperCase).toList());

        //3. Sorted
        System.out.println("Names are sorted using sort of Stream "+names.stream().sorted().toList());
        System.out.println("Names are sorted using sort using comparator by length of Stream "+names.stream().sorted((a , b)-> a.length() - b.length()).toList());
        System.out.println("Names are sorted using sort in descending of Stream "+names.stream().sorted(Comparator.reverseOrder()).toList());

        //4. Distinct
        List<String> names1 = Arrays.asList("Jawad", "Inam", "Awais", "Avez", "Bilal", "Salah","Jawad","Inam");
        System.out.println("Remove Distinct using Stream "+names1.stream().distinct().toList());

        //5.limit  //6.Skip will skip the first 10 element
        System.out.println("Skip and limit example"+Stream.iterate(1,x -> x+1).skip(10).limit(100).toList());
    }
}
