package com.ohgiraffers.section01.section02.openclosed.problem;

/* 설명.
 *  개방-폐쇄 원칙(Open-Closed Priciple) - "확장할 때 기존 코드를 수정하며 확장되면 안돼!"
 *  - 소프트웨어의 엔티티(클래스, 모듈, 함수 등)는 확장에 대해서는 열려 있어야 하지만,
 *    변경에 대해서는 닫혀 있어야 한다.
* */

public class Application {
    public static void main(String[] args) {
        BadPaymentProcessor badPaymentProcessor = new BadPaymentProcessor();
        badPaymentProcessor.porcessPayment("credit");   //신용카드 결재
        badPaymentProcessor.porcessPayment("kakao");    //카카오 페이 결재

    }
}
