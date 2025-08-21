package com.ohgiraffers.section02.functionalInterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Application3 {
    public static void main(String[] args) {

        /* 수업목표. 표준 함수적 인터페이스 중 하나인 Function에 대해 이해하고 사용할 수 있다. */
        Function<String, Integer> function = str -> Integer.valueOf(str);
        System.out.println(function.apply("10"));
        System.out.println(function.apply("10") instanceof Integer);

        BiFunction<String, String, Integer> biFunction =
                (str1, str2) -> Integer.valueOf(str1) + Integer.parseInt(str2);
        System.out.println(biFunction.apply("10", "110"));
    }
}
