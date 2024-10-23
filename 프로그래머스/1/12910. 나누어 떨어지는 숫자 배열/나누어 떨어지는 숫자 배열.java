import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] answer;
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % divisor == 0) {
                index++;
            }
        }
        answer = new int[index];
        index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % divisor == 0) {
                answer[index] = arr[i];
                index++;
            }
        }

        if (index == 0) {
            answer = new int[1];
            answer[0] = -1;
            return answer;
        }

        Arrays.sort(answer);

        return answer;
    }
}