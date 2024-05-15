import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int test_case = 1; test_case <= T; test_case++) {
            sb.append("#").append(test_case).append(" ");
            long N = Long.parseLong(br.readLine());
            sb.append((N * (N + 1)) / 2).append(" ").append(N * N).append(" ").append(N * N + N).append("\n");

            // 그냥 합 (N*(N-1))/2
            // 홀수의 합 N^2
            // 짝수의 합 N^2 + N

        }
        System.out.println(sb);
    }
}