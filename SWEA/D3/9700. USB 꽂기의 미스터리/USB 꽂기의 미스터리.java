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
            double p = Double.parseDouble(st.nextToken());
            double q = Double.parseDouble(st.nextToken());
            String result = "YES";

            double s1 = (1-p)*q;
            double s2 = p*(1-q)*q;
            if(s1 >= s2) {
                result = "NO";
            }
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}