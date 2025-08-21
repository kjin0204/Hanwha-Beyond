package com.ohgiraffers.section01.lambda;

public class Application {
    public static void main(String[] args) {

        /* 수업목표. 람다식에 대해 이해하고 활욜할 수 있다.(feat. Functional Interface) */
        /* 설명. 1. 인터페이스를 구현하는 클래스로 하위 구현체를 만드는 방법 */
        Calculator cal = new CalculatorImpl();
        System.out.println("10과 20의 합은? " + cal.sumToNumbers(10, 20)); // 동적 바인딩 발생
        /* 설명. 2. 익명 클래스를(Anonymous Class) 활용한 방식 */
        Calculator cal2 = new Calculator() {
            @Override
            public int sumToNumbers(int first, int second) {
                return first + second;
            }
        };

        System.out.println("2 + 3은 ? " + cal2.sumToNumbers(2, 3));
        /* 설명. 3. 람다식을 활용한 방식 */
        /* 설명.
         *  람다식은 익명함수로 함수형 인터페이스를 화용해 하위 구현체의 메소드를 오버라이딩 하는 느낌으로
         *  작성하게 된다. 이때 반드시 함수형 인터페이스여야 추상메소드가 하나만 존재하므로 익명 함수가 성립된다.
         *
         *  설명.
         *   기본 규칙
         *   1. 구현하는 메소드의 body부분에서 실행 구문이 하나일 경우 중괄호({})가 생략 가능하다.
         *   2. 실해 될 구문이 표현식일 경우(return을 유추할 수 있는 경우)에는 return이 생략 가능하다.
         *   3. 매개변수가 한개일 경우 소괄호 생략 가능
         * */

        // 두가지 표현 방식이 있음
        Calculator cal3 = (first, second) -> first + second;
        Calculator cal4 = (first, second) -> {return first + second;};

        System.out.println("5와 7의 합은? " + cal3.sumToNumbers(5, 7));
    }
}
