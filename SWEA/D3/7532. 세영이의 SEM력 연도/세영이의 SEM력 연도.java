import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= T; test_case++) {
            sb.append("#").append(test_case).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            int i_S = Integer.parseInt(st.nextToken());
            int i_E = Integer.parseInt(st.nextToken());
            int i_M = Integer.parseInt(st.nextToken());
            int cnt = 1;
            int S = 1;
            int E = 1;
            int M = 1;
            while (true) {
                if (i_E == E && i_S == S && i_M == M) break;
                E += 1;
                S += 1;
                M += 1;
                cnt += 1;
                if (S >= 366) S -= 365;
                if (E >= 25) E -= 24;
                if (M >= 30) M -= 29;
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}