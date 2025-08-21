package com.ohgiraffers.section02.uses.subsection02.intermediate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;


/* 설명.
 *  filter()란?
 *  - 스트림의 요소 중에 조건을 만족하는 요소들만 걸러내는 중간 연산
 *  - 중간 연산들은 최종 연산 전에는 실행되지 않음
 * */

public class Application1 {
    public static void main(String[] args) {

        /* 설명. filter() 중계 연산자를 활용할 수 있다. */
        IntStream.range(0, 10)
                .peek(n -> System.out.print(n + " "))
                .filter(n -> n > 5)
                .peek(n -> System.out.print("필터링 이후 : " + n + " "))
                .forEach(System.out::println);

        /* 설명.
         *  Arrays.stream()은 배열(int[])만 인자로 받으며, 배열의 각 요소로 스트림을 만듦
         *  반면, IntStream.of()는 InterStream.of(1, 2, 3)처럼 숫자를 직접 나열 할 수도 있다.
         * */

        int[] scores = {45, 78, 92, 67, 88, 59, 95, 73, 84, 52};
        IntStream sStream = Arrays.stream(scores);
        System.out.println();
        sStream.filter(n -> n >= 70)
                .forEach(s -> System.out.println(s + "점"));

        System.out.println();
        IntStream.of(scores)
                .filter(n -> n >= 70)
                .forEach(s -> System.out.println(s + "점"));

        System.out.println();
        IntStream.of(45, 78, 92, 67, 88, 59, 95, 73, 84, 52)
                .filter(n -> n >= 70)
                .forEach(s -> System.out.println(s + "점"));
        /* 설명. 문자열 스트림 관련 */
        List<String> planguage = Arrays.asList(
                "Java", " Python", "JavaScript", "C++", "Go", "Rust", "Kotlin"
        );
        System.out.println("\n===========  \"J\"로 시작하는 단어만 출력 =========== ");
        planguage.stream()
                .filter(s -> s.startsWith("J"))
                .forEach(System.out::println);

        System.out.println("\n=========== 4글자 이하인 단어만 출력 =========== ");
        planguage.stream()
                .filter(s -> s.length() <= 4)
                .forEach(System.out::println);

        System.out.println("\n=========== 복합 조건 필터링 =========== ");
        /* 설명. 복합 조건 필터링 */
        IntStream.rangeClosed(1, 50)
                .filter(n -> n > 10)
                .filter(n -> n % 3 == 0)
                .forEach(num -> System.out.print(num + " "));
    }
}
