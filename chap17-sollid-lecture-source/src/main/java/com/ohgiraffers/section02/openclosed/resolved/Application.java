package com.ohgiraffers.section01.section02.openclosed.resolved;

/* 설명.
 *  Payment 인터페이스를 통해 새로운 결제 수단을 기존 코드의 수정없이 쉽게 추가할 수 있다.
 *  PaymentProcessor 클래스는 구체적인 결제 방식을 알 필요 없이 Payment 인터페이스만 의존한다.
* */

public class Application {
    public static void main(String[] args) {
        PaymentProcessor process = new PaymentProcessor() ;
        process.processPayment(new CreditCardPayment());
        process.processPayment(new KakaoPayPayment());
        process.processPayment(new NaverPayPayment());
    }
}
