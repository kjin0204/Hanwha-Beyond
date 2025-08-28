package com.ohgiraffers.chap04.section01.greedy;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Application3_2 {

    public static BufferedReader toBufferedReader(String str) {
        InputStream is = new ByteArrayInputStream(str.getBytes());
        return new BufferedReader(new InputStreamReader(is));
    }

    /* 설명. 2차원 배열 및 람다식 활용(feat. 익명 클래스) */
    public static Integer solution(String input) throws IOException {
        int max_count = 0;

        BufferedReader br = toBufferedReader(input);
        int N = Integer.parseInt(br.readLine());

        int[][] time = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            time[i][0] = start;
            time[i][1] = end;
        }

//        Arrays.sort(time, new Comparator<int[]>(){
//
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return 0;
//            }
//        });

        // 정렬
        Arrays.sort(time, (o1, o2) ->{
            if(o1[1] == o2[1]) return o1[0] - o2[0];
            return o1[1] - o2[1];}
        );

        for(int[] arr : time){
            System.out.println(Arrays.toString(arr));
        }

        int lastEndTime = 0;
        for (int i = 0; i < N; i++) {
            if(time[i][0] >= lastEndTime){
                max_count++;
                lastEndTime = time[i][1];
            }

        }

        return max_count;
    }
}
