class Solution {
    public int solution(int n) {
        // 소수 여부를 저장하는 배열, 기본적으로 true로 초기화
        boolean[] isPrime = new boolean[n + 1];
        
        // 2부터 n까지의 수를 소수로 가정하고 true로 초기화
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }
        
        // 에라토스테네스의 체 알고리즘
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                // i의 배수들은 소수가 아님
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        
        // 소수의 개수 세기
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                count++;
            }
        }
        
        return count;
    }
}