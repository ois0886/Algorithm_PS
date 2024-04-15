
import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= T; test_case++) {
            sb.append("#").append(test_case).append(" ");
            String str = br.readLine();
            int num = str.charAt(str.length() - 1) - '0';
            if (num % 2 == 0) {
                sb.append("Even").append("\n");
            } else {
                sb.append("Odd").append("\n");
            }
        }
        System.out.println(sb);
    }
}