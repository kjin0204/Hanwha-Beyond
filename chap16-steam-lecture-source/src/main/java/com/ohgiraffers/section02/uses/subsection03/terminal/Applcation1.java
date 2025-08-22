package com.ohgiraffers.section02.uses.subsection03.terminal;

/* 설명.
 *  최종 연산이란?
 *  - 스트림의 파이프라인 마지막에 위치하며 결과를 생성하는 연산
 *  - 지연평가: 최종 연산이 실행되기 전에는 중간 연산을 하지 않음
 *  - 최종 연산 후에는 스트림을 재사용할 수 없음
 *
 * 설명.
 *   - count(), sum(), max(), min(), average() ....
 * */

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Applcation1 {
    public static void main(String[] args) {

        /* 수업목표. calculation 관련 최종 연산자를 활용할 수 있다. */
        long count = IntStream.range(1, 10).count();
        System.out.println("count = " + count);

        int sum = IntStream.rangeClosed(1, 10).sum();
        System.out.println("sum = " + sum);

        OptionalInt max = IntStream.range(1, 10).max();
        System.out.println("max = " + max);

        /* 설명. Optional 관련 타입을 반환하며 존재하는 않는 값에 대한 구체적인 처리를 할 수 있음 */
        OptionalInt maxNot = IntStream.range(1, 1).max();
        System.out.println("maxNot = " + maxNot);
        System.out.println("maxNot.orElse = " + maxNot.orElse(0));

        OptionalInt min = IntStream.range(1, 10).min();
        System.out.println("min.get() = " + min.getAsInt()); //숫자만 추출할 수도 있지만 가급적 get메소드는 안 쓰는게 좋음
        //존재하지 않을 경우를 감안해서 만들어진 메소드 활용이 목적에 부합

        OptionalDouble average = IntStream.range(1, 10).average();
        System.out.println("average = " + average.orElse(0.0));

        /* 설명. 홀수/짝수 분석 */
        /* 설명. 1. 홀수 분석 */
        long oddCount = IntStream.rangeClosed(1, 100)
                .filter(n -> n % 2 != 0)
                .count();
        System.out.println("oddCount = " + oddCount);

        /* 설명. 2. 짝수 분석 */
        long evenCount = IntStream.rangeClosed(1, 100)
                .filter(n -> n % 2 == 0)
                .count();
        System.out.println("evenCount = " + evenCount);

        OptionalDouble avg = IntStream.rangeClosed(1, 100)
                .filter(n -> n % 2 == 0)
                .average();

        System.out.println("짝수 합의 평균은: " + avg.orElse(0.0));

    }
}
