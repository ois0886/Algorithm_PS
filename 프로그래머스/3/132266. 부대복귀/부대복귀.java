import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class Solution {

    private static List<List<Integer>> map;

    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        map = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            map.add(new ArrayList<>());
        }
        for (int[] road : roads) {
            map.get(road[0]).add(road[1]);
            map.get(road[1]).add(road[0]);
        }

        // destination에서 BFS 1번으로 모든 노드까지의 최단거리 계산
        int[] dist = new int[n + 1];
        java.util.Arrays.fill(dist, -1);
        Queue<Integer> que = new ArrayDeque<>();
        dist[destination] = 0;
        que.offer(destination);
        while (!que.isEmpty()) {
            int cur = que.poll();
            for (int next : map.get(cur)) {
                if (dist[next] == -1) {
                    dist[next] = dist[cur] + 1;
                    que.offer(next);
                }
            }
        }

        int[] answer = new int[sources.length];
        for (int i = 0; i < sources.length; i++) {
            answer[i] = dist[sources[i]];
        }
        return answer;
    }
}