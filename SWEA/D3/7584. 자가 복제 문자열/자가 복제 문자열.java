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
            long k = 0;
            int result = 0;
            k = Long.parseLong(br.readLine()) - 1;
            while (k > 0) {
                if (k % 2 == 1) k = (k - 1) / 2;
                if (k % 4 == 0) {
                    result = 0;
                    break;
                } else if (k % 2 == 0) {
                    result = 1;
                    break;
                }
            }
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}