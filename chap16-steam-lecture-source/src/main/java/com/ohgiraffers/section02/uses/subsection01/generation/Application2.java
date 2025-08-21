package com.ohgiraffers.section02.uses.subsection01.generation;

/* 설명.
 *  기본 타입 스트림(primitive Stream) 생성
 *  - IntStream: int 타입 전용
 *  - LongStream: long 타입 전용
 *  - DoubleStream: double 타입 전용
 *
 * 설명.
 *   사용 목적
 *  - 박싱/언박싱
 *  - 숫자 관련 연산 메소드 제공
 * */

import java.util.List;
import java.util.stream.*;

public class Application2 {
    public static void main(String[] args) {

        /* 설명. 1. IntStream */
        IntStream.range(5, 10) // 10 미만(5 ~ 9)
                .forEach(num -> System.out.print(num + " "));
        System.out.println();
        IntStream.rangeClosed(5, 10) // 10 이하(5 ~ 10)
                .forEach(num -> System.out.print(num + " "));

        /* 설명. LongStream */
        System.out.println("1부터 10만까지의 짝수의 합");
        long result = LongStream.range(0, 1000000)
                .filter(num -> num % 2 == 0)
                .sum();

        System.out.println("합계 : " + result);

        /* 설명. 3. DoubleStream */
        /* 설명. 0.0에서 1.0전까지 5개의 난수 생성 */
        DoubleStream.generate(Math::random)     // 무한 스트림 생성(제한 limit을 필수로 걸어 줄 것)
                .limit(5)               // 5개로 제한
                .forEach(num -> System.out.printf("%.3f ", num));

        /* 설명. 4. 박싱(Boxing): 기본 타입을 래퍼 클래스로 반환(Stream에서는 제네릭이 걸린 Stream 또는 컬렉션 활용 시 박싱 유의) */
        Stream<Integer> boxedStream = IntStream.range(1, 6)
                .boxed();

        /* 설명. 추후 배울 내용(최종 연산)이지만  컬렉션으로 변환할 때 boxing해 보기 */
        List<Integer> list = IntStream.range(1, 6)
                .boxed()
                .collect(Collectors.toList());
        System.out.println("\nlist : " + list);

    }
}
