import java.util.*;
import java.io.*;

class Main {

    static int n = 5;
    static int[][] map = new int[5][5];
    static HashSet<Integer> set;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                BFS(i, j, map[i][j]);
            }
        }

        System.out.println(set.size());

    }

    private static void BFS(int x, int y, int number) {

        Queue<Node> que = new LinkedList<>();
        que.add(new Node(x, y, number, 1));

        while (!que.isEmpty()) {
            Node cur = que.poll();
            if (cur.count == 6) set.add(cur.number);
            else {
                for (int i = 0; i < 4; i++) {
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];
                    if (range(nx, ny)) {
                        que.add(new Node(nx, ny, cur.number * 10 + map[nx][ny], cur.count + 1));
                    }
                }
            }

        }
    }

    private static boolean range(int x, int y) {
        return 0 <= x && x < 5 && 0 <= y && y < 5;
    }

}

class Node {
    int x;
    int y;
    int number;
    int count;

    Node(int x, int y, int number, int count) {
        this.x = x;
        this.y = y;
        this.number = number;
        this.count = count;
    }
}