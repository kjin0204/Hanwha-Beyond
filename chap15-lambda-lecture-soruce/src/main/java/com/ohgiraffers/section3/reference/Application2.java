package com.ohgiraffers.section3.reference;

import java.util.function.Function;
import java.util.function.Supplier;

public class Application2 {
    public static void main(String[] args) {

        /* 수업목표. 기존에 존재하는 생성자를 참조한 람다식을 작성할 수 있다. */
        Function<String,Member> member =
//                (String x) -> { return new Member(x); };
                x -> new Member(x);
        System.out.println(member.apply("m01"));

        Function<String,Member> member2 =
                Member::new;
        System.out.println(member2.apply("m02"));

        Supplier<Member> member3 =
                Member::new;
        System.out.println(member3.get());
        
    }
}
