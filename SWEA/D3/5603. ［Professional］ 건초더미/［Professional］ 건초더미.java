import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= T; test_case++) {
            sb.append("#").append(test_case).append(" ");
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            int sum = 0;
            for (int i = 0; i < N; i++) {
                int num = Integer.parseInt(br.readLine());
                arr[i] = num;
                sum += arr[i];
            }
            int avr = sum / N;
            int result = 0;
            for (int i = 0; i < N; i++) {
                if (arr[i] >= avr) {
                    result += (arr[i] - avr);
                }
            }
            sb.append(result).append("\n");

        }
        System.out.println(sb);
    }
}