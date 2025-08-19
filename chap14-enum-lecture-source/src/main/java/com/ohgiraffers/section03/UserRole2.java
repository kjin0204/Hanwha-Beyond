package com.ohgiraffers.section03;

public enum UserRole2 {
    GUEST("게스트"),
    CONSUMER("구매자"),
    PRODUCER("판매자"),
    ADMIN("관리자");

    private final String DESCRIPTION;

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    UserRole2(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }
}
