class Solution {
    public long solution(int[] sequence) {
        // 펄스 [1,-1,1,...] 과 [-1,1,-1,...] 두 가지를 미리 곱한 뒤
        // 각각에 대해 Kadane 알고리즘으로 최대 연속 부분합을 구한다
        long maxA = Long.MIN_VALUE, sumA = 0;
        long maxB = Long.MIN_VALUE, sumB = 0;

        for (int i = 0; i < sequence.length; i++) {
            int pulse = (i % 2 == 0) ? 1 : -1;
            long a = (long) sequence[i] * pulse;   // [1, -1, 1, -1, ...]
            long b = (long) sequence[i] * -pulse;  // [-1, 1, -1, 1, ...]

            sumA = Math.max(a, sumA + a);
            maxA = Math.max(maxA, sumA);

            sumB = Math.max(b, sumB + b);
            maxB = Math.max(maxB, sumB);
        }

        return Math.max(maxA, maxB);
    }
}