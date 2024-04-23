import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= T; test_case++) {
            sb.append("#").append(test_case).append(" ");
            int level = Integer.parseInt(br.readLine());
            int N = (int) Math.pow(2, level) - 1;
            int[] node = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                node[i] = Integer.parseInt(st.nextToken());
            }
            int[] tree = new int[N + 1];

            DFS(0, N - 1, 1, 0, tree, node);
            int i = 1;
            int n = 0;
            for (int le = 0; le < level; le++) {
                n += (int) Math.pow(2, le);
                for (; i <= n; i++) {
                    sb.append(tree[i]).append(" ");
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }

    private static void DFS(int left, int right, int treeIndex, int nodeIndex, int tree[], int node[]) {
        int root = (left + right) / 2;
        tree[treeIndex] = node[root];

        if (left == right)
            return;
        DFS(left, root - 1, treeIndex * 2, root, tree, node);
        DFS(root + 1, right, treeIndex * 2 + 1, root, tree, node);
    }
}