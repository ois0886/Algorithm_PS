import java.io.*;
import java.util.*;

class Solution {

    static int N, K;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int test_case = 1; test_case <= T; test_case++) {
            sb.append("#").append(test_case).append(" ");
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            int[] W = new int[N + 1]; // 무게
            int[] V = new int[N + 1]; // 가치
            int[][] dp = new int[N + 1][K + 1];


            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                W[i] = Integer.parseInt(st.nextToken());
                V[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= K; j++) {

                    // i번째 무게를 더 담을 수 없는 경우
                    if (W[i] > j) {
                        dp[i][j] = dp[i - 1][j];
                    }
                    // i번째 무게를 더 담을 수 있는 경우
                    else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - W[i]] + V[i]);
                    }

                }
            }
            sb.append(dp[N][K]).append("\n");
        }
        System.out.println(sb);
    }
}