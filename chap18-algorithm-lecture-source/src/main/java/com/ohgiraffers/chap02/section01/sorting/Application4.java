package com.ohgiraffers.chap02.section01.sorting;

/* 설명.
 *  퀵 정렬(Quick Sort)
 *   기준값(pivot)을 선정해 해당 값보다 작은 데이터와 큰 데이터로 분류하는 것을 반복 하며 정렬하는 것으로
 *   병합정렬 알고리즘과 함께 실제 정렬 알고리즘으로 많이 활용되고 있다.
 *   시간 복잡도는 O(nlogn)에 해당된다.
 * */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Application4 {
    /* 설명. solution 메소드의 매개변수가 바뀌어서 main 다시 한번 작성해봄 */
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int length = Integer.parseInt(br.readLine());
            IntStream intSream =
                    Arrays.stream(br.readLine().split(" "))
                            .mapToInt(Integer::parseInt);
            int[] arr = intSream.toArray();

            solution(0, length - 1, arr);
            System.out.println(Arrays.toString(arr));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void solution(int low, int high, int[] arr) {
        if(low>= high) return;

        int pivot = process(low, high, arr);

        solution(low, pivot, arr);
        solution(pivot + 1, high, arr);
    }

    private static int process(int left, int right, int[] arr) {
        /* 설명. 커서는 do-while을 통해 증가 및 감소를 하고 판단하게 하는 코드로 인해 초기값 설정 */
        int low = left - 1;                 // 왼쪽 커서 위치(인덱스)
        int high = right + 1;               // 오른쪽 커서 위치(인덱스)

        int pivot = arr[(left + right) / 2];    //pivot 지금 process 구간의 중앙값

        while (true) {
            do {
                low++;
            } while (arr[low] < pivot);

            do {
                high--;
            } while (arr[high] > pivot);

            if (low >= high) {
                return high;
            }

            swap(arr, low, high);
        }
    }

    private static void swap(int[] arr, int low, int high) {
        int temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;
    }
}
