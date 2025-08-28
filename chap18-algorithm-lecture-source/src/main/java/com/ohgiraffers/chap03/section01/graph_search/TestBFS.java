package com.ohgiraffers.chap03.section01.graph_search;

import java.io.*;
import java.util.*;

public class TestBFS {
    public static BufferedReader toBufferedReader(String input) {
        InputStream is = new ByteArrayInputStream(input.getBytes());
        return new BufferedReader(new InputStreamReader(is));
    }

    // 가로, 세로, 배추수
    static int x, y, iCount;

    static int count;

    static int[][] find;

    static List<List<Integer>> arr = new ArrayList<>();

    static int[] drix = new int[]{0, 0, -1, 1};
    static int[] driy = new int[]{-1, 1, 0, 0};

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static Integer solution(String input) throws IOException {

        BufferedReader br = toBufferedReader(input);
        StringTokenizer st = new StringTokenizer(br.readLine());

        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        iCount = Integer.parseInt(st.nextToken());

        arr = new ArrayList<>();
        find = new int[y][x];
        count = 0;

        for (int i = 0; i < y; i++) {
            arr.add(new ArrayList<Integer>());
        }

        int first = 0;

        for (int i = 0; i < iCount; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int n_x = Integer.parseInt(st2.nextToken());
            int n_y = Integer.parseInt(st2.nextToken());

            if (i == 0) first = n_x;
            arr.get(n_y).add(n_x);
        }

        for (int i = 0; i < y; i++) {
            System.out.println(i + "번 " + arr.get(i));
        }


        System.out.println("시작전 find 값 : ");
        for (int i = 0; i < y; i++) {
            System.out.println(Arrays.toString(find[i]));
        }


        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).size() == 0) continue;

            for (int j : arr.get(i)) {
                if (find[i][j] == 0 && arr.get(i).contains(j)) {
                    Node node = new Node(j, i);
                    bfs(node);
                    count++;
                }
            }
        }

        System.out.println("BFS 후 find 값 : ");
        for (int i = 0; i < y; i++) {
            System.out.println(Arrays.toString(find[i]));
        }

        System.out.println("벌래 갯수 : " + count);
        return count;
    }

    private static void bfs(Node startNode) {
        Queue<Node> q = new LinkedList<>();
        q.offer(startNode);
        find[startNode.y][startNode.x] = 1;

        while (!q.isEmpty()) {
            Node node = q.poll();


            for (int j = 0; j < 4; j++) {
                int cur_x = node.x + drix[j];
                int cur_y = node.y + driy[j];

                if (cur_y < y && cur_y >= 0
                        && cur_x < x && cur_x >= 0
                        && arr.get(cur_y).contains(cur_x)
                        && find[cur_y][cur_x] == 0) {
                    find[cur_y][cur_x] = 1;
                    q.offer(new Node(cur_x, cur_y));
                }
            }
        }
    }
}
