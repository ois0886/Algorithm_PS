class Solution {
    public int solution(int[] numbers) {
        int answer = -1;
        boolean[] check = new boolean[10];
        for (int number : numbers) {
            if (!check[number]) {
                check[number] = true;
                answer = 0;
            }
        }

        for (int i = 0; i < 10; i++) {
            if (!check[i]) {
                answer += i;
            }
        }

        return answer;
    }
}