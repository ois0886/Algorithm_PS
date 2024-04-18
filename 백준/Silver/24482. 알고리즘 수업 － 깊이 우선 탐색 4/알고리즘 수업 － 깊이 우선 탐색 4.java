import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] answer;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        answer = new int[n + 1];
        visit = new boolean[n + 1];

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());

        }
        while (m-- > 0) { // 간선 수 만큼 입력 받기
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for (int i = 1; i < n + 1; i++) {
            answer[i] = -1;
        }

        
        for (int i = 1; i < graph.size(); i++) {
            graph.get(i).sort(Collections.reverseOrder());
        }

        int cnt = 0;
        dfs(r, cnt);

        for (int i = 1; i < answer.length; i++) {
            sb.append(answer[i]).append("\n");
        }

        System.out.println(sb);

    }

    private static void dfs(int node, int count) {

        answer[node] = count;
        visit[node] = true;

        for (int i = 0; i < graph.get(node).size(); i++) {
            int newNode = graph.get(node).get(i);
            if (!visit[newNode]) {
                dfs(newNode, count + 1);
            }
        }
    }

}