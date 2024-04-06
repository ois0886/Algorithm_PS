import java.util.*;
import java.io.*;

class Main {

    static int N;
    static int M;
    static ArrayList<ArrayList<Integer>> list;

    static boolean[] visit;

    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }
        visit = new boolean[N + 1];

        result = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.get(start).add(end);
            list.get(end).add(start);
        }

        visit[1] = true;
        DFS(1, 0);

        for (int i = 2; i < visit.length; i++) {
            if (visit[i]) result++;
        }

        System.out.println(result);


    }

    private static void DFS(int num, int depth) {

        if (depth == 2) {
            return;
        }

        for (int i = 0; i < list.get(num).size(); i++) {
            int current = list.get(num).get(i);
            visit[current] = true;
            DFS(current, depth + 1);
        }

    }

}