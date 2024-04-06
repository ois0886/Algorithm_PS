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
            char[] arr = str.toCharArray();
            int a = 1, b = 1;
            for (char c : arr) {
                if (c == 'L') {
                    b = a + b;
                } else {
                    a = a + b;
                }
            }
            sb.append(a).append(" ").append(b).append("\n");
        }
        System.out.println(sb);
    }
}