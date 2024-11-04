import java.util.*;
import java.io.*;

class Main {

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 0; test_case < T; test_case++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[][] arr = new int[n][m];
            boolean[][] visit = new boolean[n][m];
            for (int i = 0; i < n; i++) {
                String str = br.readLine();
                for (int j = 0; j < m; j++) {
                    if (str.charAt(j) == '#') {
                        arr[i][j] = 1;
                    } else {
                        visit[i][j] = true;
                    }
                }
            }
            int result = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (!visit[i][j] && arr[i][j] == 1) {
                        result += 1;
                        BFS(n, m, i, j, visit);
                    }
                }
            }
            sb.append(result).append("\n");


        }

        System.out.println(sb);
    }

    private static void BFS(int n, int m, int i, int j, boolean[][] visit) {

        visit[i][j] = true;
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{i, j});
        while (!que.isEmpty()) {
            int[] cur = que.poll();
            int x = cur[0];
            int y = cur[1];
            for (int z = 0; z < 4; z++) {
                int nx = dx[z] + x;
                int ny = dy[z] + y;
                if (0 <= nx && nx < n && 0 <= ny && ny < m && !visit[nx][ny]) {
                    visit[nx][ny] = true;
                    que.offer(new int[]{nx, ny});
                }
            }
        }
    }
}