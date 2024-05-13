import java.io.*;
import java.util.*;

class Solution {

    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int test_case = 1; test_case <= T; test_case++) {
            sb.append("#").append(test_case).append(" ");
            st = new StringTokenizer(br.readLine());
            String[] str1 = st.nextToken().split("");
            String[] str2 = st.nextToken().split("");
            dp = new int[1001][1001];
            for (int i = 1; i < str1.length + 1; i++) {
                for (int j = 1; j < str2.length + 1; j++) {
                    if (str1[i - 1].equals(str2[j - 1])) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }
            sb.append(dp[str1.length][str2.length]).append("\n");

        }
        System.out.println(sb);
    }
}