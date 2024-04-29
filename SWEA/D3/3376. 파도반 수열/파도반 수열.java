import java.io.*;
import java.util.*;

class Solution {
    static long[] arr = new long[101];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= T; test_case++) {
            sb.append("#").append(test_case).append(" ");
            int N = Integer.parseInt(br.readLine());
            DP();
            sb.append(arr[N]).append("\n");
        }
        System.out.println(sb);
    }

    private static void DP() {
        arr[1] = 1;
        arr[2] = 1;
        arr[3] = 1;
        for (int i = 4; i < 101; i++) {
            arr[i] = arr[i - 2] + arr[i - 3];
        }
    }
}