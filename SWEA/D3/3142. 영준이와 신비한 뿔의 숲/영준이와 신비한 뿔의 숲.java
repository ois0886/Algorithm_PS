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

            int N = Integer.parseInt(st.nextToken()); // 뿔 ex 5
            int M = Integer.parseInt(st.nextToken()); // 짐승 ex 3
            // 2x + y = N
            // x + y = M
            // N - M = x
            //

            int twinhon = N - M; // 뿔 2개
            int unicon = N - (2 * twinhon); // 뿔 1개

            sb.append(unicon).append(" ").append(twinhon).append("\n");
        }
        System.out.println(sb);
    }
}