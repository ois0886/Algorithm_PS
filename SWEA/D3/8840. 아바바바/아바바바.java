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
            long num = Long.parseLong(br.readLine());
            long temp = ((num + 1) / 2) - 1;
            long result = temp * temp;
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}