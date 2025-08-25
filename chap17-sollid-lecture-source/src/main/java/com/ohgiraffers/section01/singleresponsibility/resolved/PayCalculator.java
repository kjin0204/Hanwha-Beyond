package com.ohgiraffers.section01.singleresponsibility.resolved;

public class PayCalculator {
    public void applyPatRate(Employee emp){
        int pay = emp.getWorkingHours() * emp.getPayRate(); //일한 시간 x 시급
        System.out.println(emp.getName() + "의 급여를 계산합니다. " + pay + "원");
    }
}
