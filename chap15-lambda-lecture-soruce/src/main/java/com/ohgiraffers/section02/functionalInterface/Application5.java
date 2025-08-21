package com.ohgiraffers.section02.functionalInterface;

import java.util.function.Predicate;

public class Application5 {
    public static void main(String[] args) {

        /* 수업목표. 표준 함수적 인터페이스인 Predicate에 대해 이해하고 사용할 수 있다. */
        Predicate<Object> predicate = value -> value instanceof String;
        System.out.println("문자열인가? " + predicate.test("123"));
        System.out.println("문자열인가? " + predicate.test(123));

        /* 설명.
         *  1. Consumer: 매개변수 : 0, 반환: x
         *  2. Supplier: 매개변수 : x , 반환 : O
         *  3. Function: 매개변수 : O , 반환 : O
         *  4. Operator: 매개변수 : O , 반환 : O 매개변수와 반환형 타입 일치
         *  5. Predicate 매개변수 : O , 반환 : O, 반환형이 boolean형
        * */

    }
}
