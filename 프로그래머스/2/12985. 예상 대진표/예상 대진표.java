class Solution {
    public int solution(int n, int a, int b) {
        int answer = 0;

        do {
            a = a / 2 + a % 2;
            b = b / 2 + b % 2;
            answer++;
        } while (a != b);

        return answer;
    }
}