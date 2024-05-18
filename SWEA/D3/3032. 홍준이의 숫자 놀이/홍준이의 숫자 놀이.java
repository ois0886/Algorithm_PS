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
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            long x;
            long y;
            x = Extended_Euclid(A, B);
            y = (1 - B * x) / A;
            if (x != 0) {
                sb.append(y).append(" ").append(x).append("\n");
            } else {
                sb.append(-1).append("\n");
            }

        }
        System.out.println(sb);
    }

    private static long Extended_Euclid(long r1, long r2) {
        long r, q = 0, s, s1 = 1, s2 = 0, t, t1 = 0, t2 = 1, tmp = r1;

        while (r2 != 0) {
            q = r1 / r2;
            r = r1 % r2;
            s = s1 - q * s2;
            t = t1 - q * t2;

            r1 = r2;
            r2 = r;
            s1 = s2;
            s2 = s;
            t1 = t2;
            t2 = t;
        }
        if (r1 != 1) // 역원이 있음
            return 0;

        return t1;
    }
}