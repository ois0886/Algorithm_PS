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
            int count = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == 'x') {
                    count++;
                }
            }

            if (count > 7) {
                sb.append("NO").append("\n");
            } else {
                sb.append("YES").append("\n");
            }

        }
        System.out.println(sb);
    }
}