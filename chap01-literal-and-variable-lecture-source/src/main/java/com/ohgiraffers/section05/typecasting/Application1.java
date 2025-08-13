package com.ohgiraffers.section05.typecasting;

public class Application1 {
    public static void main(String[] args) {

        /* 수업목표. 자동형변환 규칙에 대해 이해할 수 있다. */
        byte bNum = 1;

        short sNum = bNum;

        int iNum = sNum;

        int num1 = 10;
        long num2 = 20;

        long result = num1 + num2;

        /* 설명. char형을 int형에 담으면 유니코드 번호를 확인할 수 있다. */
        int uniNume = 'f'; //유니코드 값을 확인 가능.
        System.out.println("uniNum: " + uniNume);

        /* 필기. soutv 아래와 같이 자료형 출력이 자동으로 만들어짐. */
        System.out.println("uniNume = " + uniNume);
    

        short Num = 130;
        byte cNum = (byte)Num;
        System.out.println("cNum = " + cNum);

        int aa1 = solution(13, 3, 6);
        int aa = solution(22, 6, 8);


        System.out.println("aa = " + aa);




    }

    public static int solution(int n, int w, int num) {
        int answer = 0;
        int mod = n % w > 0 ? 1 : 0;
        int rowCount= n / w + mod;
        int colCount = w;
        int[][] boxGroup = new int[rowCount ][ colCount];

        int boxCount = 1;
        for(int i = 1; i <= rowCount; i++){
           for( int j = 0; j < colCount; j++){
               if(i % 2 == 1)
               {
                    boxGroup[i - 1][j] = boxCount++;
               }
               else
               {
                   boxGroup[i - 1][colCount - 1 - j] = boxCount++;
               }

               if(boxCount >= n)
               {
                   break;
               }
           }
        }
        int findFloow = num / w  == 0 ? 0 : num / w - 1;
        int findCloumn =  findFloow % 2 == 0 ? num % w == 0 ? w : num % w -1 : num % w  == 0 ? 0 :  w - num % w ;

        int topBoxCount = 0;
        for(int i = findFloow; i < rowCount; i++){
            answer += boxGroup[i][findCloumn] != 0 ? 1 : 0;
        }
        return answer;
    }
}
