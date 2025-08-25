package com.ohgiraffers.section01.section02.openclosed.resolved;

public class CreditCardPayment implements Payment {

    @Override
    public void process() {
        System.out.println("크래딧 카드로 결재 처리");
    }
}
