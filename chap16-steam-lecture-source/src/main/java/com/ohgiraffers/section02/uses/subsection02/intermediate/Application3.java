package com.ohgiraffers.section02.uses.subsection02.intermediate;

/* 설명.
 *  sorted()란?
 *  - 기본(오름차순) 및 반대(내림차순) 적용
 *  - comparator 활용 포함
 * */

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Application3 {
    public static void main(String[] args) {

        /* 수업목표. sorted() 중계 연산자를 활용 할 수 있다. */
        List<Integer> numbers = Arrays.asList(5, 10, 99, 2, 1, 35, 67, 23);

        /* 설명. 기본 정렬 (오름차순) */
        List<Integer> ascList = numbers.stream()
                .sorted() //오름차순 정렬(들어있는 데이터의 기준대로)
                .collect(Collectors.toList()); //원하는 컬렉션으로 변경
        System.out.println("ascList = " + ascList);


        /* 설명. 추가 정렬 (내림차순) */
        List<Integer> descList = numbers.stream()
                .sorted(new DescInteger()) // Comparetor 재정의한 객체를 넘겨 내림차순 정렬
                .collect(Collectors.toList()); //원하는 컬렉션으로 변경
        System.out.println("ascList2 = " + descList);

        /* 설명. Comparator.reverseOrder() 기준을  */
        List<Integer> descList2 = numbers.stream()
                .sorted(Comparator.reverseOrder()) // 정렬을 뒤짚음
                .collect(Collectors.toList()); //원하는 컬렉션으로 변경
        System.out.println("ascList2 = " + descList2);

    }
}
