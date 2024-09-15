import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long A, B, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        C = Long.parseLong(st.nextToken());
        System.out.println(fpow(A, B, C));
    }

    private static long fpow(long a, long b, long c) {
        // 지수가 0인 경우(종료 조건).
        if (b == 0) {
            return 1;
        }
        if (b == 1) {
            return a % c;
        }

        // 반으로 나눈 거듭제곱 계산.
        long res = fpow(a, b / 2, c);

        // 지수가 짝수인 경우.
        if (b % 2 == 0) {
            return (res * res % c);
        }
        // 지수가 홀수인 경우
        else {
            return (res * res % c) * a % c;
        }
    }
}
