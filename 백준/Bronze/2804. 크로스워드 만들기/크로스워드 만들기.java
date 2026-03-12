import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String A = st.nextToken();
        String B = st.nextToken();
        StringBuilder sb = new StringBuilder();

        // 1. 교차 위치 찾기 (A에서 먼저 등장하는 공통 글자)
        int ai = 0, bi = 0;
        outer:
        for (int i = 0; i < A.length(); i++) {
            for (int j = 0; j < B.length(); j++) {
                if (A.charAt(i) == B.charAt(j)) {
                    ai = i;
                    bi = j;
                    break outer;
                }
            }
        }

        // 2. M x N 격자 출력 (M = B길이, N = A길이)
        for (int row = 0; row < B.length(); row++) {
            for (int col = 0; col < A.length(); col++) {
                if (row == bi) {
                    sb.append(A.charAt(col));   // 교차 행 → A 출력
                } else if (col == ai) {
                    sb.append(B.charAt(row));   // 교차 열 → B 출력
                } else {
                    sb.append('.');
                }
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}