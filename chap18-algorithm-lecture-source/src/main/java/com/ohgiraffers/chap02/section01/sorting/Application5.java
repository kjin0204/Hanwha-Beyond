package com.ohgiraffers.chap02.section01.sorting;

/* 설명.
 *  병합 정렬(Merge Sort)
 * */

public class Application5 {
    public static void solution(int low, int high, int[] arr) {
        if(high - low == 0) return; //최종 한개까지 쪼개 졌을 때

        // low + (high - low) / 2 = (high + low) /2 동일 하지만 앞에께 좋음
        // 2번째 방식은 int 값을 벗어나는 오버 플로우가 발생 할 수도 있음.
        int midian = low + (high - low) / 2;

        //분할
        solution(low, midian, arr);
        solution(midian + 1, high, arr);

        int[] temp;
        temp = arr.clone();

        /* 설명. 분할 정복 방식 시작 */
        int k = low;
        int index1 = low;
        int index2 = midian + 1;

        while(index1 <= midian && index2 <= high) {
            if(temp[index1] > temp[index2]) { //내림차순
                arr[k++] = temp[index1++];
            } else {
                arr[k++] = temp[index2++];
            }

        }

        /* 설명. 좌측이 많이 남아있을 경우  */
        while(index1 <= midian) {
            arr[k++] = temp[index1++];
        }
        /* 설명. 우측이 많이 남아있을 경우 */
        while(index2 <= high) {
            arr[k++] = temp[index2++];
        }
    }
}
