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
            char[] rightStr = br.readLine().toCharArray();
            char[] errorStr = br.readLine().toCharArray();
            int result = 0;
            for (int i = 0; i < n; i++) {
                if (rightStr[i] == errorStr[i]) {
                    result++;
                }
            }

            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}