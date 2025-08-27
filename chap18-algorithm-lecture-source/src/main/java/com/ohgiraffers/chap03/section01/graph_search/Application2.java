package com.ohgiraffers.chap03.section01.graph_search;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Application2 {

    /* 설명. 문자열에서 한줄씩 읽어올 수 있는 BufferedReader를 반환하는 수업용 별도의 메소드 */
    public static BufferedReader toBufferdReader(String str) {
        InputStream is = new ByteArrayInputStream(str.getBytes());
        return new BufferedReader(new InputStreamReader(is));
    }

    /* 설명. 상하좌우로 붙어있는 배추들이 쌓일 큐 */
    static Queue<Node> q = new LinkedList<Node>();

    /* 설명. 방향 벡터 */
    static int[] dirX = {0, 0, -1, 1};  // 상하좌우를 위한 X좌표
    static int[] dirY = {1, -1, 0, 0};  // 상하좌우를 위한 Y자표

    /* 설명. 배추밭 */
    static int[][] map;

    /* 설명. 방문배열 */
    static boolean[][] visit;           // 양방향 관계이거나 대각선에 대칭되는 표가 아니다.

    /* 설명. 현재 위치에 대한 좌표(지렁이 투척 이후 묶인 배추 둘러볼때 사용 되는 좌표) */
    static int cur_x, cur_y;

    /* 설명. 배추밭의 크기(너비/높이), 심어진 배추의 수 */
    static int M, N, K;

    /* 설명. 필요한 배추흰지렁이의 마리수 */
    static int count;

    /* 설명. 이 문제를 풀기 위해서 배추 하나하나를 Node 객체로 다룸 */
    static class Node {
        /* 설명. 자신의 좌료를 두 개의 필드로 가짐 */
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static Integer solution(String input) throws IOException {

        BufferedReader br = toBufferdReader(input);
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); //배추밭 너비
        N = Integer.parseInt(st.nextToken()); //배추밭 높이
        K = Integer.parseInt(st.nextToken()); //심어진 배추 수

        map = new int[N][M];
        visit = new boolean[N][M];

        /* 설명. 배치 심기 */
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map[y][x] = 1;
        }
        /* 설명. 테스트 케이스들을 여러개 다룰 때 초기화 해야 될 static 변수는 초기화 해 주어야 함 */
        count = 0;  //지렁이 수 초기화

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visit[i][j] == false && map[i][j] == 1) {
                    count++;

                    bfs(j, i);

                    // 묶음별 방문 테이블 변화 확인
                    System.out.println(i + "번째 지렁이 투척");
                    for (int k = 0; k < visit.length; k++) {
                        System.out.println(Arrays.toString(visit[k]));
                    };
                    System.out.println();
                }
            }

        }

        return count;
    }

    /* 설명. 현재 좌표애서 상하좌우를 둘러보고 방문하지 않았고 또 다른 배추가 심어져 있는지 확인(방문배열 체크) */
    /* 설명. 여기서의 방문배열은 배추가 심어진 위치상에서 방문한 것들만 해당 */
    private static void bfs(int x, int y) {

        /* 설명. 지렁이를 뿌린 후 지렁이가 커버할 수 있는 배추들을 que에 담긴 시작 */
        q.offer(new Node(x, y));
        visit[y][x] = true;

        /* 설명. que에서 하나의 배추(Node)를 꺼내서 상ㅎ좌우로 붙어있는 배추를 que에 추가 */
        while (!q.isEmpty()) {
            Node node = q.poll();

            /* 설명. que에서 나온 배추의 상하좌우를 둘러 봄  */
            for (int i = 0; i < 4; i++) {
                cur_x = node.x + dirX[i];
                cur_y = node.y + dirX[i];

                if(range_check() && !visit[cur_x][cur_y] && map[cur_y][cur_x] == 1){
                    q.offer(new Node(cur_x, cur_y));
                    visit[cur_y][cur_x] = true;
                }
            }
        }
    }

    /* 설명. 지금 보는 위치(cur_x, cur_y)가 배추밭의 범위를 벗어나는지 유효성 검사용 메소드 */
    private static boolean range_check() {
        return cur_x >= 0 && cur_x < M && cur_y >= 0 && cur_y < N;

    }
}
