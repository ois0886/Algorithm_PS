import java.util.*;
import java.io.*;

class Main {

    static int N, tmpResult;
    static int[][] map;

    static boolean[][] visit;
    static int[] dx = {1, 1, -1, -1};
    static int[] dy = {-1, 1, 1, -1};



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visit = new boolean[N][N];

        // 비숍을 놓을 수 있는 곳에는 1, 비숍을 놓을 수 없는 곳에는 0
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;
        tmpResult = 0;
        //첫째칸부터 시작할 떄 DFS
        dfs(0, 0);
        result += tmpResult;
        tmpResult = 0;
        //두번째칸부터 시작할 때 DFS
        dfs(1, 0);
        result += tmpResult;
        System.out.println(result);
    }

    private static boolean isValid(int x, int y) {
        for (int d = 0; d < 4; d++) {
            int amt = 1;
            while (true) {
                int nx = x + amt * dx[d];
                int ny = y + amt * dy[d];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                    break;
                }
                if (map[nx][ny] == 2) return false;
                amt++;
            }
        }
        return true;
    }

    private static int calIncr(int ind) {
        if (N % 2 == 1) return 2;
        if (ind % N == N - 1) return 1;
        else if (ind % N == N - 2) return 3;
        else return 2;
    }

    private static void dfs(int ind, int cnt) {
        if (ind >= N * N) {
            tmpResult = Math.max(tmpResult, cnt);
            return;
        }
        int y = ind % N;
        int x = ind / N;
        int incr = calIncr(ind);
        if (map[x][y] == 0) {
            dfs(ind + incr, cnt);
            return;
        }
        if (isValid(x, y)) {
            map[x][y] = 2;
            dfs(ind + incr, cnt + 1);
            map[x][y] = 1;
        }
        dfs(ind + incr, cnt);
    }

}
