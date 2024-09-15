class Solution {
    public long solution(int price, int money, int count) {
        long answer = 0;
        long sum = 0;
        for (int i = 1; i <= count; i++) {
            sum += ((long) price * i);
        }
        if (sum - money > 0) {
            return sum - money;
        }
        return answer;
    }
}