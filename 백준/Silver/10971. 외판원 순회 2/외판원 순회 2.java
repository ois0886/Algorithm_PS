import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import java.util.Arrays;

public class Main {

    public static int tsp(int[][] graph, boolean[] visited, int current, int count, int n, int cost, int ans) {
        if (count == n && graph[current][0] != 0) {
            ans = Math.min(ans, cost + graph[current][0]);
            return ans;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i] && graph[current][i] != 0) {
                visited[i] = true;
                ans = tsp(graph, visited, i, count + 1, n, cost + graph[current][i], ans);
                visited[i] = false;
            }
        }

        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] graph = new int[n][n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);

        visited[0] = true; // 출발 도시는 방문한 것으로 표시

        int ans = Integer.MAX_VALUE;
        ans = tsp(graph, visited, 0, 1, n, 0, ans);

        System.out.println(ans);
    }
}