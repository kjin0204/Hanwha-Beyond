package com.ohgiraffers.section04.testapp.run;

import com.ohgiraffers.section04.testapp.Service.MemberService;

import java.util.Scanner;

public class Application {

    private static final MemberService ms = new MemberService();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("===== 회원 관리 프로그램 =====");
            System.out.println("1. 모든 회원 정보 보기");
            System.out.println("2. 회원 찾기");
            System.out.println("3. 회원 가입");
            System.out.println("4. 회원 정보 수정");
            System.out.println("5. 회원 탈퇴");
            System.out.println("9. 프로그램 종료");
            System.out.println("메뉴를 선택해 주세요 : ");
            int input = sc.nextInt();

            /* 설명.
             *  조회: find
             *  추가: regist
             *  수정: modify
             *  삭제: remove
            * */
            switch (input) {
                case 1:
                    ms.findAllMemevers();
                    break;
                case 2:

                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 9:
                    System.out.println("프로그램을 종료하겠습니다.");
                    return;
                default:
                    System.out.println("메뉴를 잘못 선택하셨습니다.");
            }

        }

    }
}
