import java.util.*;
import java.io.*;

class Main {

    static String[][] map;
    static boolean[][] visited;

    static int R, C, K;

    static int result;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new String[R][C];
        visited = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = String.valueOf(str.charAt(j));
            }
        }

        result = 0;

        visited[R - 1][0] = true;
        DFS(R - 1, 0, 1);
        System.out.println(result);
    }

    private static void DFS(int x, int y, int num) {
        if (num == K && x == 0 && y == C - 1) {
            result++;
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (range(nx, ny) && !visited[nx][ny] && !Objects.equals(map[nx][ny], "T")) {
                visited[nx][ny] = true;
                DFS(nx, ny, num + 1);
                visited[nx][ny] = false;
            }
        }

    }

    private static boolean range(int x, int y) {
        return 0 <= x && x < R && 0 <= y && y < C;
    }

}

