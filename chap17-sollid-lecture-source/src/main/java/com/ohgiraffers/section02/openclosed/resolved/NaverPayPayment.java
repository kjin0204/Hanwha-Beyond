package com.ohgiraffers.section01.section02.openclosed.resolved;

public class NaverPayPayment implements Payment {
    @Override
    public void process(){
        System.out.println("네이버 페이로 결제 처리");
    }
}
