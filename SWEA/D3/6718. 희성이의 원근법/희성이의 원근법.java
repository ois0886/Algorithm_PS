import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= T; test_case++) {
            sb.append("#").append(test_case).append(" ");
            int t = Integer.parseInt(br.readLine());
            // 1km = 1000m 모든 범위가 적으므로 분류해주자.
            if (t < 100) sb.append(0);
            else if (t >= 100 && t < 1000) sb.append(1);
            else if (t >= 1000 && t < 10000) sb.append(2);
            else if (t >= 10000 && t < 100000) sb.append(3);
            else if (t >= 100000 && t < 1000000) sb.append(4);
            else sb.append(5);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}