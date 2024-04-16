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
            double sum = 0.0;
            for(int i = 0; i < n; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                double p = Double.parseDouble(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                sum += (p * (double) x);
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}