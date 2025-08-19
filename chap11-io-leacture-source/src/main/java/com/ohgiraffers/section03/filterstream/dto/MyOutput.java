package com.ohgiraffers.section03.filterstream.dto;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/* 설명. 우리만의 헤더 추가만 안되는 ObjectOutputStream 생성 */
public class MyOutput extends ObjectOutputStream {

    public MyOutput(OutputStream out) throws IOException {
        super(out);
    }

    @Override
    protected void writeStreamHeader() throws IOException {
//        super.writeStreamHeader(); // 객체를 파일로 출력할 때 헤더가 생성되는 로직을 삭제함.
    }
}
