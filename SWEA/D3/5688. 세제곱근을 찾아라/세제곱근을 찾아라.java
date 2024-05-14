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
            long n = Long.parseLong(br.readLine());
            long i = 1;
            long ans = -1;
            while(i * i * i <= n) {
                if(i * i * i == n) {
                    ans = i;
                    break;
                }
                i++;
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}