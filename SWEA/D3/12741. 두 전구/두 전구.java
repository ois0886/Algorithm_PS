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
            st = new StringTokenizer(br.readLine());
            int startA = Integer.parseInt(st.nextToken());
            int endA = Integer.parseInt(st.nextToken());
            int startB = Integer.parseInt(st.nextToken());
            int endB = Integer.parseInt(st.nextToken());

            int start = Math.max(startA, startB);
            int end = Math.min(endA, endB);
            if (start > end) {
                sb.append(0);
            } else {
                sb.append(end - start);
            }
            sb.append("\n");

        }
        System.out.println(sb);
    }
}