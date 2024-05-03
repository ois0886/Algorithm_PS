import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        for (int tc = 1; tc <= N; tc++) {
            String input = br.readLine().trim();
            String filtered = input.replaceAll("[^nw]", "");
            StringBuilder sb = new StringBuilder(filtered);
            char[] S = sb.reverse().toString().toCharArray();

            int cur = S[0] == 'n' ? 0 : 90;
            int lo = 0;
            int hi = 90;

            // Pop the last element of S before iterating over the rest

            for (int i = 1; i < S.length; i++) {
                lo <<= 1;
                hi <<= 1;
                cur <<= 1;
                int mid = (lo + hi) >> 1;

                if (S[i] == 'n') {
                    hi = mid;
                    cur -= Math.abs(lo - mid);
                } else {
                    lo = mid;
                    cur += Math.abs(hi - mid);
                }
            }

            int down = 1 << (S.length - 1);
            int gcd = gcd(cur, down);

            if (cur % down != 0) {
                System.out.println("#" + tc + " " + (cur / gcd) + "/" + (down / gcd));
            } else {
                System.out.println("#" + tc + " " + (cur / down));
            }
        }
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
}