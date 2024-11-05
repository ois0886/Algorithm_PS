import java.util.Arrays;


class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 1;
        Arrays.sort(tangerine);
        int min = tangerine[0]; // 제일 작은 사이즈의 귤
        int max = tangerine[tangerine.length - 1]; // 제일 큰 사이즈의 귤
        int[] arr = new int[max + 1];
        for (int i = 0; i < tangerine.length; i++) {
            arr[tangerine[i]]++;
        }

        Arrays.sort(arr);

        for (int i = max; i >= min; i--) {
            k -= arr[i];
            if (k <= 0) break;
            else answer++;
        }

        return answer;
    }
}