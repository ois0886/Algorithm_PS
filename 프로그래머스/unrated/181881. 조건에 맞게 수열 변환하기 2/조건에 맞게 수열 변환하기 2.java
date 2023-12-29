

class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        while (true) {
            boolean check = true;
            for (int i = 0; i < arr.length; i++) {
                int num = arr[i];
                if (num >= 50) {
                    if (num % 2 == 0) {
                        num = arr[i] / 2;
                        if (num != arr[i]) check = false;
                        arr[i] = num;
                    }
                } else {
                    if (num % 2 == 1) {
                        num = arr[i] * 2 + 1;
                        if (num != arr[i]) check = false;
                        arr[i] = num;
                    }
                }
            }

            if (check) break;
            else answer++;

        }

        return answer;
    }
}