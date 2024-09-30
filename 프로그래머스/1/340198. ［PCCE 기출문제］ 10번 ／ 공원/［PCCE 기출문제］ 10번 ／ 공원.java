class Solution {
    public int solution(int[] mats, String[][] park) {
        int answer = -1;
        int n = park.length;
        int m = park[0].length;

        // 누적 합 배열 생성
        int[][] prefixSum = new int[n + 1][m + 1];

        // 누적 합 배열 채우기
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                prefixSum[i][j] = prefixSum[i - 1][j] + prefixSum[i][j - 1]
                                  - prefixSum[i - 1][j - 1]
                                  + (park[i - 1][j - 1].equals("-1") ? 1 : 0);
            }
        }

        // 매트 크기마다 검사
        for (int z = 0; z < mats.length; z++) {
            int matSize = mats[z];

            for (int i = 0; i <= n - matSize; i++) {
                for (int j = 0; j <= m - matSize; j++) {
                    int x2 = i + matSize;
                    int y2 = j + matSize;
                    int filledCount = prefixSum[x2][y2] - prefixSum[i][y2]
                                      - prefixSum[x2][j] + prefixSum[i][j];

                    if (filledCount == matSize * matSize) {
                        answer = Math.max(answer, matSize);
                    }
                }
            }
        }
        return answer;
    }
}