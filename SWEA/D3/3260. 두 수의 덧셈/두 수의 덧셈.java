import java.io.*;
import java.math.BigDecimal;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= T; test_case++) {
            sb.append("#").append(test_case).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            BigDecimal a = new BigDecimal(st.nextToken());
            BigDecimal b = new BigDecimal(st.nextToken());
            sb.append(a.add(b)).append("\n");

        }
        System.out.println(sb);
    }
}