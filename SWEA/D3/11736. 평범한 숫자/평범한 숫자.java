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
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                if (max < arr[i]) max = arr[i];
                if (min > arr[i]) min = arr[i];
            }
            int count = 0;

            for (int i = 1; i < n - 1; i++) {
                if (arr[i] != Math.min(arr[i + 1], Math.min(arr[i], arr[i - 1])) && arr[i] != Math.max(arr[i + 1], Math.max(arr[i], arr[i - 1]))) {
                    count++;
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}