class Solution {
    // 소수 판별 함수
    public static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public static int solution(int[] nums) {
        int count = 0;

        // 3개의 숫자를 고르는 모든 조합을 확인
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];

                    // 합이 소수인 경우 카운트 증가
                    if (isPrime(sum)) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}