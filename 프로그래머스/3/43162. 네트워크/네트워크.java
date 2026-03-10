import java.util.*;

class Solution {
    static boolean[] visited;

    public int solution(int n, int[][] computers) {
        int answer = 0;

        // 1 1 0
        // 1 1 0
        // 0 0 1
        // 자가지신은 무조건 1, 연결이 되어있으면1, 안되어있으면 0
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(i, computers);
                answer++;
            }
        }
        //

        return answer;
    }

    private static void bfs(int start, int[][] computers) {

        Queue<Integer> que = new LinkedList<>();
        que.offer(start);
        visited[start] = true;
        while (!que.isEmpty()) {
            int number = que.poll();
            for (int i = 0; i < computers[number].length; i++) {
                if (i != number && !visited[i] && computers[number][i] == 1) {
                    que.offer(i);
                    visited[i] = true;
                }
            }
        }

    }

}