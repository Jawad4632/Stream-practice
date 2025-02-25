package com.example;

import java.util.List;
import java.util.stream.Stream;

public class ParallelStreamDemo {
    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();
        List<Integer> list = Stream.iterate(1, x -> x + 1).limit(20000).toList();
//        List<Long> factorial = list.stream().map(ParallelStreamDemo::Factorial).toList();
        long endTime = System.currentTimeMillis();
        System.out.println("Total time taken: " + (endTime - startTime) + "ms");

        System.out.println("Now using parallel stream");

//        startTime = System.currentTimeMillis();
//        factorial=list.stream().map(ParallelStreamDemo::Factorial).sorted().toList();
//        endTime = System.currentTimeMillis();
//        System.out.println("Total time taken: " + (endTime - startTime) + "ms");
    }

    private static long Factorial(int m) {
        long factorial = 1;
        for (int i = 2; i <= m; i++) {
            factorial *= i;
        }
        return factorial;
    }
}
