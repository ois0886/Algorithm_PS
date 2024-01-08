class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            answer += calculating(limit, i, power);
        }
        return answer;
    }

    private int calculating(int limit, int people_number, int power) {
        int sum = 0;
        for (int i = 1; i * i <= people_number; i++) {
            if (i * i == people_number) sum++;
            else if (people_number % i == 0) sum += 2;
        }
        if (sum > limit) return power;
        return sum;
    }
}