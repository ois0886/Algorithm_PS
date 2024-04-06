import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= T; test_case++) {
            sb.append("#").append(test_case).append(" ");
            int K = Integer.parseInt(br.readLine());

            Queue<Integer> queue = new LinkedList<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < (int) Math.pow(2, K); i++) {
                queue.add(Integer.parseInt(st.nextToken()));
            }

            int ans = 0;
            while (queue.size() >= 2) {
                int a = queue.poll();
                int b = queue.poll();

                queue.add(Math.max(a, b));
                ans += Math.abs(a - b);
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}