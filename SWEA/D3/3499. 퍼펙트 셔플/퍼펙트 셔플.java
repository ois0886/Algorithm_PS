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
            String[] arr = new String[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = st.nextToken();
            }
            if (n % 2 == 0) {
                for (int i = 0; i < (n / 2); i++) {
                    sb.append(arr[i]).append(" ");
                    sb.append(arr[i + (n / 2)]).append(" ");
                }
            } else {
                for (int i = 0; i < (n / 2); i++) {
                    sb.append(arr[i]).append(" ");
                    sb.append(arr[i + 1 + (n / 2)]).append(" ");
                }
                sb.append(arr[(n / 2)]);
            }
            sb.append("\n");

        }
        System.out.println(sb);
    }
}