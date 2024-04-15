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
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            int num3 = Integer.parseInt(st.nextToken());
            int result = 0;
            if (num1 == num2 && num2 == num3) {
                result = num1;
            } else {
                if (num1 == num2) {
                    result = num3;
                } else if (num2 == num3) {
                    result = num1;
                } else {
                    result = num2;
                }
            }
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}