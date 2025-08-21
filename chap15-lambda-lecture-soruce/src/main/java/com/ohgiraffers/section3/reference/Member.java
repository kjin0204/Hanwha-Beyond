package com.ohgiraffers.section3.reference;

public class Member {
    private String memId;

    public Member() {
        System.out.println("기본생성자");
    }

    public Member(String memId) {
        this.memId = memId;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memId='" + memId + '\'' +
                '}';
    }
}
