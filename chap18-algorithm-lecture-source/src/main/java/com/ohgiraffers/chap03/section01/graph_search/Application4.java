package com.ohgiraffers.chap03.section01.graph_search;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Application4 {


    public static BufferedReader toBufferedReader(String str) {
        InputStream is = new ByteArrayInputStream(str.getBytes());
        return new BufferedReader(new InputStreamReader(is));
    }

    /* 설명. 양방향 그래프이면 1차원 배열로 방문배열을 작성할 수 있다. */
    static boolean[] visit;

    static int[][] arr;

    static int node, line, start; //N , M , V

    static Queue<Integer> q = new LinkedList<>();

    /* 설명. bfs 또는 dfs의 결과로 나온 문자열 조립을 위한 문자열 처리 담당 객체 */
    static StringBuilder sb = new StringBuilder();

    public static String solution(String input) throws IOException {

        sb.delete(0, sb.length());

        BufferedReader br = toBufferedReader(input);

        StringTokenizer st = new StringTokenizer(br.readLine());
        node = Integer.parseInt(st.nextToken());
        line = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        arr = new int[node + 1][node + 1];
        visit = new boolean[node + 1];

        for (int i = 0; i < line; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());

            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        dfs(start);
        sb.append("\n");
        visit = new  boolean[node + 1];
        bfs(start);

        return sb.toString();
    }

    private static void dfs(int start) {
        visit[start] = true;
        sb.append(start + " ");

        for (int i = start; i <= node ; i++) {
            if(arr[start][i] == 1 && !visit[i]){
                dfs(i);
                visit[i] = true;
            }
        }
    }

    private static void bfs(int start) {
        q.offer(start);
        visit[start] = true;

        while(!q.isEmpty()){
            start = q.poll();
            sb.append(start + " ");

            for (int i = 1; i <= node; i++) {
                if(arr[start][i] == 1 && !visit[i]){
                    q.offer(i);
                    visit[i] = true;
                }

            }

        }
    }

}
