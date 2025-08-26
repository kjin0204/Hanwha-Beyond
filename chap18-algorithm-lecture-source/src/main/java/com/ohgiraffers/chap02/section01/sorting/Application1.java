package com.ohgiraffers.chap02.section01.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

/* 설명. 버블 정렬 */
/* 설명.
 *  버블 정렬(Bubble Sort)
 *   두 인접한 데이터의 크기를 비교해 정렬하는 방법이다.
 *   버블의 모든 요소에 대해 반복하면서, 각 반복마다 가장 큰(작은) 요소가 배열의 끝으로
 *   "버블링(이동)" 된다
 *   시간복잡도는 o(n^2)이라 효율적이지는 않다.(feat.데이터의 크기가 10000이면 위험)
* */

public class Application1 {
    /* 설명.
     *  문제 내용
     *   : N개의 정수가 주어졌을 때, 버블 정렬 알고리즘을 사용하여 오름차순으로 정렬하는 프로그램을 작성하시오.
     *  입력
     *   - 첫 번째 줄에 자연수 N(1 <= N <= 100)이 주어진다.
     *   - 두 번째 줄에 N개의 정수가 공백으로 구분되어 입력된다. 각 정수는 -10^9 이상, 10^9 이하이다.
     *  출력
     *   - 오름차순으로 정렬된 수열을 공백으로 구분하여 출력한다.
     *
     *  설명.
     *   예시 입력 1
     *     - 7
     *       34 23 5 24 1 9 12
     *   예시 출력 1
     *     - 1 5 9 12 23 24 34
     *
     *  설명.
     *   예시 입력 2
     *     - 6
     *       40 47 38 8 33 35
     *   예시 출력 2
     *     - 8 33 35 38 40 47
     * */

    public static void main(String[] args) {
        /* 설명. 입력 데이터 받기 */
//        Scanner sc = new Scanner(System.in);
//        int length = sc.nextInt();
//        int[] arr = new int[length];
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = sc.nextInt();
//        }
//
//        System.out.println(Arrays.toString(arr));


        /* 설명. BufferdReader를 활용하는 방법 */
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int length = Integer.parseInt(br.readLine()); //가급적 한줄을 문자열로 읽어 숫자로 바꿀때는
            // Integer.valueOf 대신 Integer.parseInt 사용
            /* 설명. 한줄 문자열 파싱하기 */
            /* 설명. 1. split 활용(정규 표현식 해석으로 인해 StringTokenizer 보다 시간이 약간 더 걸림) */
//            String[] strArr = br.readLine().split(" ");
//            int[] arr = new int[length];
//            for (int i = 0; i < strArr.length; i++) {
//                arr[i] = Integer.parseInt(strArr[i]);
//            }

            /* 설명. 2. StringTokenizer */
//            int[] arr = new int[length];
//            int index =0;
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            while(st.hasMoreTokens()){
//                arr[index++] = Integer.parseInt(st.nextToken());
//            }

            /* 설명. 3. Stream 활용(속도는 3가지중 가장 느림,스트림의 오버헤드 발생) */
            IntStream intStream = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt);

            int[] arr = intStream.toArray();

            solution(length, arr);

            System.out.println(length);
            System.out.println(Arrays.toString(arr));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    /* 설명. 넘어온 데이터를 가지고 버블 정렬 알고리즘 작성 시작 */
    public static void solution(int length, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {    //오름차순
//                if (arr[j] < arr[j + 1]) {      //내림차순
                    /* 설명. 두 요소( j, j+1)의 위치를 swap 해야 한다. */
                    int swap = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = swap;
                }
            }

            System.out.println((i + 1) + "번째 순회 :  " + Arrays.toString(arr));
        }
    }
}
