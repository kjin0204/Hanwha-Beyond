package com.ohgiraffers.section01.literal;

public class Application2 {
    public static void main(String[] args) {

        /* 수업목표. */
        System.out.println("===== 정수와 정수의 연산 ======");
        System.out.println(123 + 456); // ctrl + d 한줄 복사 해서 밑에줄에 채워짐
        System.out.println(123 - 456);
        System.out.println(123 * 456);
        System.out.println(123 / 456);
        System.out.println(123 % 456);



        System.out.println("===== 실수와 실수의 연산 ======");
        System.out.println(1.23 + 1.23);
        System.out.println(1.23 - 0.23);
        System.out.println(1.23 * 10.0);
        System.out.println(1.23 / 10.0);
        System.out.println(1.23 % 1.0); // 결과값 : 0.22999999999999998 실수 끼리 연산은 정확하지 않을 수 있음.
                                        // 실수는 정확하지 않고 근사한 값이다.

        System.out.println("===== 정수와 실수의 연산 ====="); //실수와 정수의 연산은 실수값을 출력 함.
        System.out.println(123 / 5.0);  //실수의 결과값을 얻으려면 연산하는 변수의 타입중 1개 이상의 실수가 포함되야 함.


        System.out.println("===== 문자와 정수의 연산 ====="); //문자와 정수 연산을 하면 정수값이 나옴.
        System.out.println('a' + 1);        // 결과값은 a의 아스키코드값 97 + 1 = 98
        System.out.println((char)('a' + 1)); //형변환
        System.out.println('a' % 2);

        System.out.println("===== 문자열과 문자열의 연산 ====="); //문자열을 더하면 문자열을 이어 붙임.
        System.out.println("안녕하세요" + " 반값습니다");
        System.out.println("Hello" + " World!~");


        System.out.println("===== 문자열과 다른 형태의 값 연산 ====="); // 문자열과 숫자 or 논리값의 연산은 문자열로 이어 붙임.
                                                                    // 숫자 or 논리값을 문자열로 자동 형변환 하여 문자열 연산.
        System.out.println("hello " + 123);
        System.out.println("hello " + true);
        System.out.println(123 + 1 + " hello " + 123.0 + 2);
        System.out.println(123 + 1 + " hello " + (123.0 + 2));



    }
}
