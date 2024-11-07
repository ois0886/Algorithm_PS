import java.util.LinkedList;
import java.util.Queue;

class Solution {

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static int n, m;

    static boolean[][] visit;

    public int solution(int[][] maps) {
        int answer = 0;
        n = maps.length;
        m = maps[0].length;

        visit = new boolean[n][m];
        answer = BFS(maps);

        return answer;
    }

    private static int BFS(int[][] maps) {
        int result = Integer.MAX_VALUE;
        Queue<int[]> que = new LinkedList<>();
        visit[0][0] = true;
        que.add(new int[]{0, 0, 1});
        boolean flag = false;

        while (!que.isEmpty()) {
            int[] cur = que.poll();

            if (cur[0] == n - 1 && cur[1] == m - 1) {
                result = Math.min(result, cur[2]);
                flag = true;
            }
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + cur[0];
                int ny = dy[i] + cur[1];
                if (range(nx, ny) && !visit[nx][ny] && maps[nx][ny] != 0) {
                    que.add(new int[]{nx, ny, cur[2] + 1});
                    visit[nx][ny] = true;
                }
            }
        }

        if (flag) return result;
        else return -1;

    }

    private static boolean range(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m;
    }
}