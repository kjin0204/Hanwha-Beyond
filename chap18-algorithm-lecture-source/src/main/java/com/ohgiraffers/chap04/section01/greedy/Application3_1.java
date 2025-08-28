package com.ohgiraffers.chap04.section01.greedy;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/* 설명. 추가 클래스를 활용한 정렬 방법 */
public class Application3_1 {

    public static BufferedReader toBufferedReader(String str) {
        InputStream is = new ByteArrayInputStream(str.getBytes());
        return new BufferedReader(new InputStreamReader(is));
    }

    public static Integer solution(String input) throws IOException {
        int max_count = 0;
        BufferedReader br = toBufferedReader(input);
        int N = Integer.parseInt(br.readLine());

        ArrayList<Time> timeList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            timeList.add(new Time(start, end));
        }

        /* 설명. 컬렉션을 활용한 정렬 */
        Collections.sort(timeList);
//        timeList.sort(null);

//        timeList.stream()
//                .forEach(System.out::println);

        int lastEndTime = 0;
        for (int i = 0; i < timeList.size(); i++) {
            if(timeList.get(i).start  >= lastEndTime){
                max_count++;
                lastEndTime = timeList.get(i).end;
            }
        }


        return max_count;
    }
}

/* 설명. 각 회의 객체를 만들 수 있느 클래스(end 시간 오름차순 정의) */
class Time implements Comparable<Time> {
    public int start;
    public int end;

    public Time(int start, int end) {
        this.start = start;
        this.end = end;
    }


    @Override
    public int compareTo(Time o) {
//        if(this.end == o.end) return o.start - this.start;// start시간이 늦은걸로 정렬한다면
        return this.end - o.end;
    }

//    @Override
//    public String toString() {
//        return "Time{" +
//                "start=" + start +
//                ", end=" + end +
//                '}';
//    }
}