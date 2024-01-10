class Solution {
    public int solution(int a, int b, int n) {
        int count = 0;
        int num = n;

        while (num >= a) {
            count += num / a * b;
            num = num / a * b + num % a;
        }
        return count;
    }
}