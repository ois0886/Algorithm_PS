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
            String[] str = br.readLine().split("");
            String temp1 = str[0] + str[1];
            String temp2 = str[2] + str[3];
            int num1 = Integer.parseInt(temp1);
            int num2 = Integer.parseInt(temp2);

            if ((num1 <= 12 && num1 >= 1) && (num2 <= 12 && num2 >= 1)) {
                sb.append("AMBIGUOUS").append("\n");
            } else if (num1 <= 12 && num1 >= 1) {
                sb.append("MMYY").append("\n");
            } else if (num2 <= 12 && num2 >= 1) {
                sb.append("YYMM").append("\n");
            } else {
                sb.append("NA").append("\n");
            }

        }
        System.out.println(sb);
    }
}