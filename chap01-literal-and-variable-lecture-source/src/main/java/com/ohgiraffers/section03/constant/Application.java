package com.ohgiraffers.section03.constant;

public class Application {
    public static void main(String[] args) {
        /* 수업목표. 상수에 대해 이해하고 사용할 수 있다. */
        /* 필기. 상수는 예약어로 final을 사용. */
        int age;
        final int AGE; //상수는 관례상 대문자로 사용. 

        age = 2;
        age = 3;

        AGE = 2;
//        AGE = 3; 한번 초기화 후에는 값을 변경 할 수 없음.
    }
}
