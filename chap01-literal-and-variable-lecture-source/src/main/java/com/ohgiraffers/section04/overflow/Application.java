package com.ohgiraffers.section04.overflow;

public class Application {
    public static void main(String[] args) {

        /* 수업목표. 오버플로우에 대해 이해할 수 있다. */
        /* 설명.
         *  자료형 별 값의 최대 범위를 벗어나는 경우
         *  발생한 carry를 버림처리하고 부호 비트를 반전시켜 순환한다.
         *  carry : 올림수.
         */

        byte num1 = 127;
        num1++;
        System.out.println("오버플로우 발생 : " + num1);

        byte nmu2 = -128;
        nmu2--;
        System.out.println("언더플로우 발생 : " + nmu2);
    }
}
