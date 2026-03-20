class Solution {
    public int solution(int sticker[]) {
        int n = sticker.length;
        if (n == 1) return sticker[0];

        return Math.max(
                maxSum(sticker, 0, n - 2),  // 첫 번째 포함, 마지막 제외
                maxSum(sticker, 1, n - 1)   // 첫 번째 제외
        );
    }

    private int maxSum(int[] arr, int from, int to) {
        if (from == to) return arr[from];
        int[] dp = new int[arr.length];
        dp[from] = arr[from];
        dp[from + 1] = Math.max(arr[from], arr[from + 1]);
        for (int i = from + 2; i <= to; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + arr[i]);
        }
        return dp[to];
    }
}