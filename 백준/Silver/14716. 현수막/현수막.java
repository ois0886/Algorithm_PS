import java.util.*;
import java.io.*;

class Main {

    static int result;

    static int[][] map;
    static int[] dx = {0, 0, -1, 1, -1, 1, -1, 1};
    static int[] dy = {1, -1, 0, 0, 1, 1, -1, -1};
    static boolean[][] visit;

    static int x;
    static int y;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        map = new int[x][y];
        visit = new boolean[x][y];
        result = 0;
        for (int i = 0; i < x; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < y; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) {
                    visit[i][j] = true;
                }
            }
        }

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (!visit[i][j]) {
                    result += 1;
                    BFS(i, j);
                }
            }
        }
        System.out.print(result);

    }

    private static void BFS(int x, int y) {
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{x, y});
        visit[x][y] = true;
        while (!que.isEmpty()) {
            int[] cur = que.poll();
            for (int i = 0; i < 8; i++) {
                int nx = dx[i] + cur[0];
                int ny = dy[i] + cur[1];
                if (range(nx, ny) && !visit[nx][ny]) {
                    que.add(new int[]{nx, ny});
                    visit[nx][ny] = true;
                }
            }
        }
    }

    private static boolean range(int nx, int ny) {
        return 0 <= nx && nx < x && 0 <= ny && ny < y;
    }
}