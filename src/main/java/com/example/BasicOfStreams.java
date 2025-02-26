package com.example;

import java.util.List;
import java.util.function.*;

public class BasicOfStreams {
    public static void main(String[] args) {

        // functional programming
        mathematical m = (a, b) -> a + b;
        mathematical n = (a, b) -> a - b;
        System.out.println(m.operation(1,2));
        System.out.println(n.operation(1,2));

        //Predicate use to check the boolean

        Predicate<Integer> o = x -> x % 7 == 0;
        System.out.println(o.test(49));

        Predicate<String> str1 = x -> x.toLowerCase().startsWith("i");
        Predicate<String> str2 = x -> x.toLowerCase().endsWith("l");
        Predicate<String> both = str1.and(str2);
        System.out.println(both.test("Ismail"));


        //Function work for you
        Function<Integer, Boolean> f = x -> x % 2 == 0;
        System.out.println(f.apply(1));

        Function<Integer, Integer> f1 = x -> x + 100;
        System.out.println(f1.apply(4));


        Function<Integer, Boolean> integerBooleanFunction = f1.andThen(f);
        System.out.println(integerBooleanFunction.apply(4));

        //consumer(Kuch kaam hora hai)
        Consumer<Integer> print = System.out::println;
        print.accept(5);

        List<Integer> list1 = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Consumer<List<Integer>> li = x -> {
            for (Integer i : x) System.out.println(i + " ");
        };
        li.accept(list1);

        //Suppliers
        Supplier<String> getEmployees = () -> "Jawad You have to finish it Today";
        System.out.println(getEmployees.get());

        Supplier<List<String>> getAll = () -> List.of("jawad", "Inam", "Awais", "Avez");
        System.out.println(getAll.get());

        //COMBINE EXAMPLE
        Predicate<String> str3 = x -> x.toLowerCase().startsWith("i");
        Function<String, String> str4 = String::toUpperCase;
        Consumer<String> str5 = System.out::println;
        Supplier<String> str6 = () -> "Ismail";

        if (str3.test(str6.get())) {
            str5.accept(str4.apply(str6.get()));
        }

        // UnaryOperator
        UnaryOperator<Integer> unaryOperator = x -> x * x;
        System.out.println(unaryOperator.apply(10));

        //bifunctional
        BiFunction<Integer, Integer, Integer> biFunction = (x, y) -> x * y;
        System.out.println(biFunction.apply(1, 2));

        //BinaryOperator
        BinaryOperator<String> binaryOperator = (a, b) -> a + b;
        System.out.println(binaryOperator.apply("jawad", "khan"));
    }

    interface mathematical {
        int operation(int a, int b);
    }

}