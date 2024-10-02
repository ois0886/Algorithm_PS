import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int t = 0; t < commands.length; t++) {
            int i = commands[t][0];
            int j = commands[t][1];
            int k = commands[t][2];

            int[] arr = new int[j - i + 1];
            int index = 0;
            for (int num = i - 1; num < j; num++) {
                arr[index++] = array[num];
            }
            Arrays.sort(arr);
            answer[t] = arr[k - 1];
        }

        return answer;
    }
}