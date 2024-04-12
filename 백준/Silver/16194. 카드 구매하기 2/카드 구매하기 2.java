import java.util.*;
import java.io.*;

class Main {
    static int N;
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        arr = new int[N + 1];
        dp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j] + arr[j]);
            }
        }

        System.out.println(dp[N]);

    }
}
