package com.ohgiraffers.section02.variable;

public class Application1 {
    public static void main(String[] args) {

        /* 수업목표. 변수의 사용 목적에 대해 이해할 수 있다. */
        /* 필기. variable(변수) 정의 리터럴을 담을 수 있는 공간. */

        /* 목차. 1. 값에 의미를 부여하기 위한 목적(가독성) */
        System.out.println("===== 값에 의미 부여 테스트 =====");
        System.out.println("보너스를 포함한 금액 : " + (1000000 + 200000) + "원");

        // 왼쪽 : 변수 , 오른쪽 : 리터럴
        int salary = 1_000_000;
        int bonus = 200_000;

        System.out.println("보너스를 포함한 금액 : " + (salary + bonus) + "원");

        /* 목차. 2. 한 번 저장해둔 값을 재사용하기 위해(유지보수)하기 위해서 */
        System.out.println("===== 고객에게 포인트 부여 =====");

        System.out.println("1번 고객에게 포인트를 100포인트 지급하였습니다.");
        System.out.println("2번 고객에게 포인트를 100포인트 지급하였습니다.");
        System.out.println("3번 고객에게 포인트를 100포인트 지급하였습니다.");
        System.out.println("4번 고객에게 포인트를 100포인트 지급하였습니다.");
        System.out.println("5번 고객에게 포인트를 100포인트 지급하였습니다.");
        System.out.println("6번 고객에게 포인트를 100포인트 지급하였습니다.");
        System.out.println("7번 고객에게 포인트를 100포인트 지급하였습니다.");
        System.out.println("8번 고객에게 포인트를 100포인트 지급하였습니다.");
        System.out.println("9번 고객에게 포인트를 100포인트 지급하였습니다.");

        System.out.println();
        
        int points = 100;
        System.out.println("===== 변수를 활용하여 고객에게 포인트 부여 =====");
        
        System.out.println("1번 고객에게 포인트를  " + points + "포인트 지급하였습니다.");
        System.out.println("2번 고객에게 포인트를  " + points + "포인트 지급하였습니다.");
        System.out.println("3번 고객에게 포인트를  " + points + "포인트 지급하였습니다.");
        System.out.println("4번 고객에게 포인트를  " + points + "포인트 지급하였습니다.");
        System.out.println("5번 고객에게 포인트를  " + points + "포인트 지급하였습니다.");
        System.out.println("6번 고객에게 포인트를  " + points + "포인트 지급하였습니다.");
        System.out.println("7번 고객에게 포인트를  " + points + "포인트 지급하였습니다.");
        System.out.println("8번 고객에게 포인트를  " + points + "포인트 지급하였습니다.");
        System.out.println("9번 고객에게 포인트를  " + points + "포인트 지급하였습니다.");
        System.out.println("10번 고객에게 포인트를 " + points + "포인트 지급하였습니다.");

        System.out.println();
        System.out.println("===== 포인트를 100 -> 200 변경  =====");
        System.out.println();
        points = 200;
        
        System.out.println("1번 고객에게 포인트를  " + points + "포인트 지급하였습니다.");
        System.out.println("2번 고객에게 포인트를  " + points + "포인트 지급하였습니다.");
        System.out.println("3번 고객에게 포인트를  " + points + "포인트 지급하였습니다.");
        System.out.println("4번 고객에게 포인트를  " + points + "포인트 지급하였습니다.");
        System.out.println("5번 고객에게 포인트를  " + points + "포인트 지급하였습니다.");
        System.out.println("6번 고객에게 포인트를  " + points + "포인트 지급하였습니다.");
        System.out.println("7번 고객에게 포인트를  " + points + "포인트 지급하였습니다.");
        System.out.println("8번 고객에게 포인트를  " + points + "포인트 지급하였습니다.");
        System.out.println("9번 고객에게 포인트를  " + points + "포인트 지급하였습니다.");
        System.out.println("10번 고객에게 포인트를 " + points + "포인트 지급하였습니다.");
        
        /* 목차. 3. 변수를 통해 시간에 따라 변화하는 값을 같은 이름으로 저장할 목적 */
        System.out.println("===== 변수에 저장된 값 변경 테스트 =====");
        int sum = 0;

        sum += 10;
        System.out.println("sum에 10을 더하면 sum의 값은: " + sum);

        sum += 10;
        sum += 10;
        sum += 10;
        sum += 10;
        System.out.println("sum에 10을 4번 더 누적하면 sum의 값은: " + sum);


    }
}
