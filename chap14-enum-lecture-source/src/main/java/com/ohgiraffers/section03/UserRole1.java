package com.ohgiraffers.section03;

public enum UserRole1 {
    GUEST,
    CONSUMER,
    PRODUCER,
    ADMIN;

    public String getNameToLowerCase(){
        return this.name().toLowerCase();
    }

}
