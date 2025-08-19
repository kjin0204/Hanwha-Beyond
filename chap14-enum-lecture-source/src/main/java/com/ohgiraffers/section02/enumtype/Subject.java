package com.ohgiraffers.section02.enumtype;

public enum Subject {
    JAVA,
    MARIADB,
    JDBC,
    HTML,
    CSS,
    JAVASCRIPT;

    Subject(){
        System.out.println("기본 생성자 호출됨....");
    }

    @Override
    public String toString(){
        return "@@@" + this.name() + "@@@";
    }
}
