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
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int sum = 0;
            if (a < b) {
                int temp = c / a;
                sum += temp;
                c %= a;
            } else {
                int temp = c / b;
                sum += temp;
                c %= b;
            }
            sb.append(sum).append("\n");

        }
        System.out.println(sb);
    }
}