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
            long N = Long.parseLong(st.nextToken());
            long A = Long.parseLong(st.nextToken());
            long B = Long.parseLong(st.nextToken());
            long min = Long.MAX_VALUE;
            if ((long) (Math.sqrt(N)) == Math.sqrt(N)) {
                min = 0;
            } else {
                for (long i = 1; i <= (long) (Math.sqrt(N)); i++) {
                    for (long j = i; (long) j * i <= N; j++) {
                        long tmp = A * Math.abs(i - j) + B * (N - i * j);
                        if (tmp < min) min = tmp;
                    }
                }
            }
            sb.append(min).append("\n");
        }
        System.out.println(sb);
    }
}