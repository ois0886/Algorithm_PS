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
            int cnt = 0;
            for (int i = 1; i <= n; i++) {
                int sum = 0;
                for (int j = i; j <= n; j++) {
                    sum += j;
                    if (sum == n) {
                        cnt++;
                        break;
                    } else if (sum > n) {
                        break;
                    }
                }
            }
            sb.append(cnt).append("\n");

        }
        System.out.println(sb);
    }
}