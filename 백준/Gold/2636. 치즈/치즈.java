import java.util.*;
import java.io.*;

class Main {

    static int N, M;

    static int[][] map;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int result = 0;
        while (true) {
            visit = new boolean[N][M];
            BFS();
            if (check()) break;
            deleteCheese();
            result++;
        }

        System.out.println(result + 1);
        System.out.println(checkResult());
        
    }

    private static int checkResult() {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 2) {
                    count++;
                }
            }
        }
        return count;
    }

    private static void BFS() {
        Queue<int[]> que = new LinkedList<>();
        visit[0][0] = true;
        que.offer(new int[]{0, 0});
        while (!que.isEmpty()) {
            int[] cur = que.poll();
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + cur[0];
                int ny = dy[i] + cur[1];
                if (range(nx, ny) && !visit[nx][ny]) {
                    visit[nx][ny] = true;
                    if (map[nx][ny] == 0) {
                        que.offer(new int[]{nx, ny});
                    }
                    if (map[nx][ny] == 1) {
                        map[nx][ny] = 2;
                    }
                }
            }
        }
    }

    private static void deleteCheese() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 2) {
                    map[i][j] = 0;
                }
            }
        }
    }

    private static boolean check() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) return false;
            }
        }
        return true;
    }

    private static boolean range(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < M;
    }
}
