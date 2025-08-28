package com.ohgiraffers.chap05.section01.tree;

import java.io.*;
import java.util.*;

public class Application1 {

    public static BufferedReader toBufferedReader(String str) {
        InputStream is = new ByteArrayInputStream(str.getBytes());
        return new BufferedReader(new InputStreamReader(is));
    }

    static int N;
    static int[] parent;
    static int[] bfsParent;
    static boolean[] isVisit;
    static boolean[] bfsIsVisit;
    static StringTokenizer st;
    static List<Integer>[] list;
    static StringBuilder sb = new StringBuilder();


    public static String solution(String input) throws IOException {
        BufferedReader br = toBufferedReader(input);
        N = Integer.parseInt(br.readLine());

        sb = new StringBuilder();
        parent = new int[N + 1];
        bfsParent = new int[N + 1];
        isVisit = new boolean[N + 1];
        bfsIsVisit = new boolean[N + 1];
        list = new ArrayList[N + 1];        //각 노드가 연결된 노드를 담은 ArrayList를 노드 갯수만큼 관리만큼 관리하는 배열

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList();
        }

        for (int i = 1; i <= N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        dfs(1);
        bfs(1);

        for (int i = 2; i <= N; i++) {
            sb.append(parent[i]).append(" ");
        }

        System.out.println(Arrays.toString(bfsParent));

        return sb.toString();
    }


    private static void dfs(int parentNode) {
        isVisit[parentNode] = true;

        for(int node : list[parentNode]){
            if(isVisit[node]) continue;
            parent[node] = parentNode;
            dfs(node);
        }
    }


    private static void bfs(int startNode) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(startNode);
        bfsIsVisit[startNode] = true;

        while(!q.isEmpty()){
            int parentNode = q.poll();
                bfsIsVisit[parentNode] = true;

            for(int node : list[parentNode]){
                if(bfsIsVisit[node]) continue;
                q.offer(node);
                bfsParent[node] = parentNode;
            }
        }

    }

}
