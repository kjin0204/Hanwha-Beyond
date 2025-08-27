package com.ohgiraffers.chap03.section01.graph_search;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Application1 {

    static boolean[] visit; //방문배열
    static int[][] map;      // 그래프를 2차원 배열로 매핑(인접리스트)
    static int count;       // 오염된 컴퓨터의 수
    static int node, edge;  // node와 edge의 개념을 담을 변수

    /* 설명. 문자열에서 한줄씩 읽어올 수 있는 BufferedReader를 반환하는 수업용 별도의 메소드 */
    public static BufferedReader toBufferdReader(String str) {
        InputStream is = new ByteArrayInputStream(str.getBytes());
        return new BufferedReader(new InputStreamReader(is));
    }

    public static Integer solution(String input) throws IOException {
        BufferedReader br = toBufferdReader(input);
        node = Integer.parseInt(br.readLine());
        edge = Integer.parseInt(br.readLine());

        /* 설명. 노드와 간선에 대한 정보가 담긴 map(node의 번호와 인덱스 번호 일치를 위해 +1) */
        map = new int[node + 1][node + 1];

        /* 설명. 방문배열(simple path(단순 경로)를 위한 것이지만 실제로는 stackoverflow 방지 목적) */
        visit = new boolean[node + 1];

        /* 설명. 인접리스트에 그래프 정보 작성 */
        for (int i = 0; i < edge; i++) {
            // 구분자가 띄어쓰기이면 생략 가능
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            /* 설명. 무방향 그래프는 매핑 시 대각을 기준으로 체크한다. */
//            map[a][b] = map[b][a] = 1; // 이런식 으로도 가능
            map[a][b] = 1;
            map[b][a] = 1;
        }

        dfs(1);

        // 맵핑 확인
//        for (int i = 0; i < map.length; i++) {
//            System.out.print(Arrays.toString(map[i]));
//            System.out.println();
//        }


        return --count;
    }

    /* 설명. 재귀함수로 dfs 알고리즘을 구현 할 메소드 */
    private static void dfs(int start) {
        visit[start] = true;
        count++;

        for (int i = 1; i < node; i++) {
            if (map[start][i] == 1 && !visit[i]) {
                dfs(i);
            }

        }
    }
}
