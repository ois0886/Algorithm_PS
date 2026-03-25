class Solution {
    public int solution(int[] stones, int k) {
        int left = 1, right = 200_000_000;
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (canCross(stones, k, mid)) left = mid;
            else right = mid - 1;
        }
        return left;
    }

    private boolean canCross(int[] stones, int k, int n) {
        int consecutive = 0;
        for (int stone : stones) {
            if (stone < n) {
                if (++consecutive >= k) return false;
            } else {
                consecutive = 0;
            }
        }
        return true;
    }
}