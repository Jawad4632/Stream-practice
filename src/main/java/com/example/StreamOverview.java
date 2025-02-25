package com.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamOverview {
    public static void main(String[] args) {
//        feature introduce in java 8
//        process collections of data in a functional and declarative method
//        Simplify the data Processing

//        what is Stream?
//        a sequence of element supporting functional interface & declarative programming
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        System.out.println(list.stream().filter(x -> x % 2 != 0).count());


        //create Stream
//        1.Collections
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6, 7);
        System.out.println("Stream made from Collection " + integers.stream().count());
//        2.From Arrays
        String[] array = {"a", "b", "c", "d", "e"};
        System.out.println("Made from array " + Arrays.stream(array).count());

//        3.Using Stream.of()
        System.out.println("Stream is made from Stream.of " + Stream.of("a", "b", "c").count());

//        4. Infinite Streams
        System.out.println(Stream.generate(() -> 1).limit(34));
        System.out.println(Stream.iterate(1, x -> x + 1).limit(40).collect(Collectors.toList()));
    }
}
