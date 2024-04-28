import java.io.*;
import java.util.*;

class Solution {

    static Integer[] dp;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= T; test_case++) {
            sb.append("#").append(test_case).append(" ");
            int n = Integer.parseInt(br.readLine());
            arr = new int[n];
            dp = new Integer[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for(int i = 0; i < n; i++){
                DP(i);
            }

            int max = dp[0];
            for (int i = 1; i < n; i++) {
                max = Math.max(max, dp[i]);
            }
            sb.append(max).append("\n");

        }
        System.out.println(sb);
    }

    static int DP(int n) {
        if (dp[n] == null) {
            dp[n] = 1;

            for (int i = n - 1; i >= 0; i--) {
                if (arr[i] < arr[n]) {
                    dp[n] = Math.max(dp[n], dp[i] + 1);
                }
            }
        }
        return dp[n];
    }
}