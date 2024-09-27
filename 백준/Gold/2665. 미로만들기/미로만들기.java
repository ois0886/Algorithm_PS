import java.util.*;
import java.io.*;

class Main {
    static int[][] map;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] dist;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        dist = new int[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j) - '0';
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        bfs();

        System.out.println(dist[N - 1][N - 1]);
    }

    public static void bfs() {
        Deque<Node> deque = new ArrayDeque<>();
        deque.add(new Node(0, 0));
        dist[0][0] = 0;

        while (!deque.isEmpty()) {
            Node now = deque.pollFirst();

            for (int i = 0; i < 4; i++) {
                int nextX = now.x + dx[i];
                int nextY = now.y + dy[i];

                if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < N) {
                    int nextDist = dist[now.x][now.y] + (map[nextX][nextY] == 0 ? 1 : 0);

                    if (nextDist < dist[nextX][nextY]) {
                        dist[nextX][nextY] = nextDist;
                        if (map[nextX][nextY] == 1) {
                            deque.addFirst(new Node(nextX, nextY)); // 가중치가 0이면 앞에 추가
                        } else {
                            deque.addLast(new Node(nextX, nextY));  // 가중치가 1이면 뒤에 추가
                        }
                    }
                }
            }
        }
    }

    public static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}