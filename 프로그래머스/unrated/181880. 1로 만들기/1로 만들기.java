class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        for (int j : num_list) {
            int num = j;
            while (num != 1) {
                if (num % 2 == 0) {
                    num /= 2;
                } else {
                    int temp = num - 1;
                    num = temp / 2;
                }
                answer += 1;
            }
        }
        return answer;
    }
}