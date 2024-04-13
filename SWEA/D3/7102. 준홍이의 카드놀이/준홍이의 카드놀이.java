import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= T; test_case++) {
            sb.append("#").append(test_case).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[] arr = new int[n + m + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    arr[i + j]++;
                }
            }
            int max = Integer.MIN_VALUE;
            for (int i = 1; i <= n + m; i++) {
                if (max < arr[i]) max = arr[i];
            }
            for (int i = 1; i <= n + m; i++) {
                if(arr[i] == max) sb.append(i).append(" ");
            }
            sb.append("\n");

        }
        System.out.println(sb);
    }
}