import java.io.*;
import java.util.*;

class Solution {


    static int n;
    static int m;

    static char[][] map;
    static boolean[][] visited;
    static boolean result;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= T; test_case++) {
            sb.append("#").append(test_case).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            map = new char[n][m];
            visited = new boolean[n][m];
            result = true;

            for (int i = 0; i < n; i++) {
                String str = br.readLine();
                for (int j = 0; j < m; j++) {
                    map[i][j] = str.charAt(j);
                }
            }

            int startx;
            int starty;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] != '?') {
                        startx = i;
                        starty = j;
                        BFS(startx, starty);
                        break;
                    }
                }
            }

            if (result) {
                sb.append("possible").append("\n");
            } else {
                sb.append("impossible").append("\n");
            }


        }
        System.out.println(sb);
    }

    private static void BFS(int x, int y) {
        Queue<Node> que = new LinkedList<>();
        visited[x][y] = true;
        que.offer(new Node(x, y));

        while (!que.isEmpty()) {
            Node cur = que.poll();
            int cx = cur.x;
            int cy = cur.y;
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + cx;
                int ny = dy[i] + cy;
                if (range(nx, ny) && !visited[nx][ny]) {
                    if (map[nx][ny] == '?') {
                        if (map[cx][cy] == '#') {
                            map[nx][ny] = '.';
                        } else {
                            map[nx][ny] = '#';
                        }
                    }

                    if (map[cx][cy] == map[nx][ny]) result = false;

                    visited[nx][ny] = true;
                    que.offer(new Node(nx, ny));
                }
            }
        }
    }

    private static boolean range(int x, int y) {
        return (x >= 0) && (x < n) && (y >= 0) && (y < m);
    }
}

class Node {
    int x;
    int y;

    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}