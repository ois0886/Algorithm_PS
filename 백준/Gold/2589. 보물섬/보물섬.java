import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int M;
    static int N;
    static int[][] map;
    static boolean[][] visit;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visit = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                if (str.charAt(j) == 'L') {
                    map[i][j] = 1;
                } else {
                    map[i][j] = 0;
                }
            }
        }

        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    visit = new boolean[N][M];
                    int len = BFS(i, j);
                    result = Math.max(result, len);
                }
            }
        }

        System.out.println(result);

    }

    private static int BFS(int x, int y) {
        Queue<Pair> pairs = new LinkedList<Pair>();
        visit[x][y] = true;
        int num = 0;
        pairs.offer(new Pair(x, y, 0));
        while (!pairs.isEmpty()) {
            Pair current = pairs.poll();
            int tx = current.x;
            int ty = current.y;
            for (int i = 0; i < 4; i++) {
                int nx = tx + dx[i];
                int ny = ty + dy[i];
                if (range(nx, ny) && !visit[nx][ny] && map[nx][ny] == 1) {
                    pairs.offer(new Pair(nx, ny, current.cost + 1));
                    num = Math.max(num, current.cost + 1);
                    visit[nx][ny] = true;
                }
            }
        }
        return num;
    }

    private static boolean range(int x, int y) {
        return (x >= 0 && x < N) && (y >= 0 && y < M);
    }
}

class Pair {
    int x;
    int y;
    int cost;

    Pair(int x, int y, int cost) {
        this.x = x;
        this.y = y;
        this.cost = cost;
    }
}

