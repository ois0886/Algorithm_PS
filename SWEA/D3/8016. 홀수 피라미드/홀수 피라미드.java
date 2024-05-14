import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int test_case = 1; test_case <= T; test_case++) {
            sb.append("#").append(test_case).append(" ");
            long floor = Long.parseLong(br.readLine());
            if (floor == 1) {
                sb.append(1).append(" ").append(1).append("\n");
            } else {
                floor -= 1;
                long N = floor * floor + 1;
                long K = (floor + 1) * (floor + 1);
                N = 2 * N - 1;
                K = 2 * K - 1;
                sb.append(N).append(" ").append(K).append("\n");
            }
        }
        System.out.println(sb);
    }
}