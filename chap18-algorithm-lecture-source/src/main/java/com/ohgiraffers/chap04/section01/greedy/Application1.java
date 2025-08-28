package com.ohgiraffers.chap04.section01.greedy;

public class Application1 {
    public static Integer solution(Integer input) {
        int count = 0;

        /* 설명. 5키로 봉지(이득을 많이 가져다 줄)로 나누어 담아 보고, 3키로 봉지를 최소한으로 사용 */
        while (true) {
            if(input % 5 == 0){
                return input / 5 + count;
            } else {
                input -= 3;
                count++;

                if(input == 0) break;
                if(input < 0) return -1;
            }
        }

        return count;
    }
}
