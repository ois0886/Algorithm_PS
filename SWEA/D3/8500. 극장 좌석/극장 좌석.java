import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= T; test_case++) {
            sb.append("#").append(test_case).append(" ");
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sum = 0;
            int max = 0;
            int interval = 0;
            for (int i = 0; i < n; i++) {
                interval = Integer.parseInt(st.nextToken());
                sum += interval;
                if (max < interval) max = interval;
            }
            sb.append(sum + n + max).append("\n");

        }
        System.out.println(sb);
    }
}