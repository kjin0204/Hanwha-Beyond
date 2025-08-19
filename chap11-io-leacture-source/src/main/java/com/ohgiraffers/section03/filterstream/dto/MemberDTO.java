package com.ohgiraffers.section03.filterstream.dto;

import java.io.Serializable;

public class MemberDTO implements Serializable {

    /* 필기. serializable을 적용 하면 명시 하지 않더라도 자동으로 생성 되며 클래스별로 유일 한 값이어야 함.
    *       객체 입출력의 대상이 되는 클래스는 Serializable 인터페이스를 구현해야 한다.*/
    private static final long serialVersionUID = 1L;

    private String id;
    /* 설명. transient 키워드가 달린 필드는 객체 입출력의 직렬화에서 제외됨(보안성) */
    private transient String pwd;
    private String name;
    private String email;
    private int age;
    private char gender;

    @Override
    public String toString() {
        return "MemberDTO{" +
                "id='" + id + '\'' +
                ", pwd='" + pwd + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public MemberDTO(String id, String pwd, String name, String email, int age, char gender) {
        this.id = id;
        this.pwd = pwd;
        this.name = name;
        this.email = email;
        this.age = age;
        this.gender = gender;
    }

    public MemberDTO() {

    }
}
