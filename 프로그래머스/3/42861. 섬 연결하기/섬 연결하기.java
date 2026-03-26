import java.util.Arrays;
import java.util.Comparator;

class Solution {
    static int[] parent;

    public int solution(int n, int[][] costs) {
        // 비용 오름차순 정렬
        Arrays.sort(costs, Comparator.comparingInt(a -> a[2]));

        // Union-Find 초기화 (각 섬이 자기 자신의 부모)
        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        int answer = 0;
        for (int[] cost : costs) {
            int a = cost[0], b = cost[1], w = cost[2];
            // 사이클 없으면 연결
            if (find(a) != find(b)) {
                union(a, b);
                answer += w;
            }
        }
        return answer;
    }

    // 루트 노드 찾기
    static int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]); // 경로 압축
        return parent[x];
    }

    // 두 집합 합치기
    static void union(int a, int b) {
        parent[find(a)] = find(b);
    }
}
