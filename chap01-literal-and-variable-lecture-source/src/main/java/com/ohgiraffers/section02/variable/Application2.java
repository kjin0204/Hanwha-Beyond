package com.ohgiraffers.section02.variable;

public class Application2 {
    public static void main(String[] args) {

        /* 수업목표. 변수를 선언하고 값을 할당하여 사용할 수 있다.(feat. 자료형(type)) */
        /* 목차. 1. 정수를 취급하는 자료형 */
        byte bNum;          // 1byte
        short sNum;         // 2byte
        int iNum;           // 4byte
        long lNum;          // 8byte

        /* 목차. 2 실수를 취급하는 자료형 */
        float fNum;         // 4byte
        double dNum;        // 8byte

        /* 목차. 3. 문자를 취급하는 자료형 */
        char ch;            // 2byte Java는 유니코드를 사용 함.


        /* 목차. 4. 논리값을 취급하는 자료형 */
        boolean isTrue;     // 1byte

        /* ====== 필기. 여기까지가 Primitive Type 기본자료형 ======= */


        /* ====== 필기. 이 아래로는 참조 자료형 reference Type ======= */
        /* 목차. 5. 추가로, 문자열을 취급하는 자료형(기본자료형 X) */
        String str;         // 4byte

        /* 설명. 각 변수에 값 대입해 보기 */
        bNum = 1;
        sNum = 2;
        iNum = 4;
        lNum = 2150000000L; //int 범위를 넘어 갈때는 L을 붙여줘야 함.

        fNum = 3.14f;
        dNum = -3.14;

        ch = 'a';
        ch = 97;

        isTrue = true;

        /* 설명. 변수 활용한 합계(sum), 평군(avg) 출력해 보기 */
        int kor = 90;
        int eng = 80;
        int mat = 75;

        int sum = kor + eng + mat;
        System.out.println("합계: " + sum);

        double avg = sum / 3.0;
        System.out.println("평균: " + avg);

        long aa = 2100000000 + 50000000;
        System.out.println(aa);;
        long aa1 = 2100000000 + 50000000L;
        System.out.println(aa1);

    }
}
