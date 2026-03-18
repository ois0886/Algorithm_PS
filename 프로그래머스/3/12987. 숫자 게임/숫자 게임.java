
import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);

        int answer = 0;
        // 더 간단하게: 투 포인터
        int aPtr = 0, bPtr = 0;
        // B가 이길 수 없으면 버리고, 이길 수 있으면 매칭
        // → A 작은것부터, B 작은것부터 비교

        aPtr = 0;
        bPtr = 0;
        while (aPtr < A.length && bPtr < B.length) {
            if (B[bPtr] > A[aPtr]) {
                answer++;
                aPtr++;
                bPtr++;
            } else {
                bPtr++; // 이 B카드로는 못 이기니 버림
            }
        }

        return answer;
    }
}