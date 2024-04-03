class Solution {
    public int solution(int[] num_list, int n) {
        int answer = 0;
        for (int j : num_list) {
            if (j == n) {
                answer = 1;
                break;
            }
        }
        return answer;
    }
}