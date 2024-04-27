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
            long D = Long.parseLong(st.nextToken());
            long L = Long.parseLong(st.nextToken());
            long N = Long.parseLong(st.nextToken());
            sb.append((D * N) + ((D * L * N * (N - 1)) / 200)).append("\n");

        }
        System.out.println(sb);
    }
}