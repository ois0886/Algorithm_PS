import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] dp;
    static int result = 0;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];
        calculate();

        System.out.println(dp[n]);
    }

    private static void calculate() {
        // dp[i]를 i를 제곱수의 합으로 표현할 때 필요한 최소 항의 개수라고 정의
        // 초기값은 모두 무한대(INF)로 설정
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        // 1부터 n까지의 모든 수에 대해 최소 항의 개수 계산
        for (int i = 1; i <= n; i++) {
            // 제곱수의 최대 크기는 i의 제곱근까지이므로 j*j가 i보다 작은 범위까지 반복
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
    }
}