import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static int N;
    static int M;
    static int K;
    static int[][] map;
    static boolean[][] visit;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int count = 0;

    static LinkedList<Integer> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N + 1][M + 1];
        visit = new boolean[N + 1][M + 1];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int nx = Integer.parseInt(st.nextToken());
            int ny = Integer.parseInt(st.nextToken());
            fill_one(x, y, nx, ny);
        }

        result = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (map[i][j] == 0 && !visit[i][j]) {
                    count = 0;
                    DFS(i, j);
                    result.add(count);
                }
            }
        }

        System.out.println(result.size());
        Collections.sort(result);
        for (Integer integer : result) {
            System.out.print(integer + " ");
        }
    }

    private static void fill_one(int x, int y, int nx, int ny) {
        for (int i = x + 1; i <= nx; i++) {
            for (int j = y + 1; j <= ny; j++) {
                map[i][j] = 1;
            }
        }
    }

    private static void DFS(int x, int y) {
        Stack<ColRow> stack = new Stack<>();
        visit[x][y] = true;
        stack.push(new ColRow(x, y));
        count++;
        while (!stack.isEmpty()) {
            ColRow current = stack.pop();
            int cx = current.x;
            int cy = current.y;
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (range(nx, ny) && map[nx][ny] == 0 && !visit[nx][ny]) {
                    stack.push(new ColRow(nx, ny));
                    visit[nx][ny] = true;
                    count++;
                }
            }
        }
    }

    private static boolean range(int x, int y) {
        return ((1 <= x) && (x <= N)) && ((1 <= y) && (y <= M));
    }

}

class ColRow {
    int x;
    int y;

    ColRow(int x, int y) {
        this.x = x;
        this.y = y;
    }
}