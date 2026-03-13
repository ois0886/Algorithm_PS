import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int MOD = 1_000_000_007;
        int[][] dp = new int[n + 1][m + 1];

        // 물웅덩이 표시 (-1)
        for (int[] p : puddles) {
            dp[p[1]][p[0]] = -1;  // puddles는 (열, 행) 순서
        }

        dp[1][1] = 1; // 시작점

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (dp[i][j] == -1) {  // 물웅덩이
                    dp[i][j] = 0;
                    continue;
                }
                if (i == 1 && j == 1) continue; // 시작점은 이미 1
                int from_up = 0;
                int from_left = 0;
                if (i > 1) from_up = dp[i - 1][j];
                if (j > 1) from_left = dp[i][j - 1];
                dp[i][j] = (from_up + from_left) % MOD;
            }
        }

        return dp[n][m];
    }
}