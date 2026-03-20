import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int coverage = 2 * w + 1;
        int left = 1; // 현재 커버되지 않은 구간의 시작

        for (int s : stations) {
            int gapEnd = s - w - 1; // 이 기지국 커버 직전까지
            if (gapEnd >= left) {
                int gapLength = gapEnd - left + 1;
                answer += (gapLength + coverage - 1) / coverage; // ceil(gapLength / coverage)
            }
            left = s + w + 1; // 다음 미커버 구간 시작
        }

        // 마지막 기지국 이후 처리
        if (left <= n) {
            int gapLength = n - left + 1;
            answer += (gapLength + coverage - 1) / coverage;
        }

        return answer;
    }
}