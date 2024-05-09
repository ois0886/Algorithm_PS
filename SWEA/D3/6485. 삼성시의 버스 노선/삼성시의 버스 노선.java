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
            int N = Integer.parseInt(br.readLine());
            int[] m = new int[5001];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());
                for (int j = A; j <= B; j++) {
                    m[j]++;
                }
            }
            int P = Integer.parseInt(br.readLine());
            int[] result = new int[P];
            for (int i = 0; i < P; i++) {
                int num = Integer.parseInt(br.readLine());
                result[i] = m[num];
            }

            for(int i = 0; i < P; i++){
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}