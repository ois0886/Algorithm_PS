import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;

        // 7                    7
        // 3 8                 3  8
        // 8 1 0              8  1  0
        // 2 7 4 4           2  7  4  4
        // 4 5 2 6 5        4  5  2  6  5

        // 맨 아래층을 dp 초기값으로 복사
        int[] dp = triangle[triangle.length - 1].clone();

        // 아래서 두 번째 층부터 위로 올라가며 갱신
        for (int i = triangle.length - 2; i >= 0; i--) {
            for (int j = 0; j < triangle[i].length; j++) {
                dp[j] = triangle[i][j] + Math.max(dp[j], dp[j + 1]);
            }
        }

        return dp[0];
    }
}