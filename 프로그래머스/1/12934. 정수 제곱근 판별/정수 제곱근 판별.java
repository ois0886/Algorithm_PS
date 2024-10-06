class Solution {
    public long solution(long n) {
        long answer = -1;
        long num = 1;

        while (true) {
            if (n > num * num) num += 1;
            else if (n == num * num) {
                answer = (num + 1) * (num + 1);
                break;
            } else{
                break;
            }
        }

        return answer;
    }
}