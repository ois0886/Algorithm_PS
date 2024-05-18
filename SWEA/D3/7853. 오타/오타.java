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

            String s = br.readLine();

            long cnt = 1;
            int n = s.length();

            for (int i = 0; i < n; i++) {
                int r = 1;
                if (i == 0) {
                    if (s.charAt(i) != s.charAt(i + 1)) r++;
                } else if (i == n - 1) {
                    if (s.charAt(i - 1) != s.charAt(i)) r++;
                } else {
                    if (s.charAt(i - 1) != s.charAt(i)) r++;
                    if (s.charAt(i) != s.charAt(i + 1)) r++;
                    if (r > 1 && s.charAt(i - 1) == s.charAt(i + 1)) r--;
                }
                cnt *= r;
                cnt %= 1000000007;
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}