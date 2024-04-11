class Solution {
    public int solution(int[] array) {
        int answer = 0;
        for (int k : array) {
            String str = String.valueOf(k);
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == '7') {
                    answer++;
                }
            }
        }
        return answer;
    }
}