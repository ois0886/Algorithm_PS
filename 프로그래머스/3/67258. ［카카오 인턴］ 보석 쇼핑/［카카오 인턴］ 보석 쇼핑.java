import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int totalTypes = new HashSet<>(Arrays.asList(gems)).size();

        Map<String, Integer> window = new HashMap<>();
        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int ansLeft = 0, ansRight = 0;

        for (int right = 0; right < gems.length; right++) {
            // 오른쪽 확장
            window.merge(gems[right], 1, Integer::sum);

            // 모든 종류 포함됐으면 왼쪽 줄이기
            while (window.size() == totalTypes) {
                if (right - left < minLen) {
                    minLen = right - left;
                    ansLeft = left;
                    ansRight = right;
                }
                window.merge(gems[left], -1, Integer::sum);
                if (window.get(gems[left]) == 0) window.remove(gems[left]);
                left++;
            }
        }

        return new int[]{ansLeft + 1, ansRight + 1}; // 1-indexed
    }
}
