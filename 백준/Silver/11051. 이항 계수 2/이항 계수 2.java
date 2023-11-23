import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 이항 계수를 저장하기 위한 배열
    private static int[][] binomialCoefficients;

    public static int binomialCoefficient(int n, int k) {
        // 기저 사례: k가 0이거나 n과 k가 같으면 1을 반환
        if (k == 0 || n == k) {
            return 1;
        }

        // 이미 계산한 값이 있다면 그 값을 반환
        if (binomialCoefficients[n][k] != 0) {
            return binomialCoefficients[n][k];
        }

        // 이항 계수를 계산하고 배열에 저장
        binomialCoefficients[n][k] = (binomialCoefficient(n - 1, k - 1) + binomialCoefficient(n - 1, k)) % 10007;
        return binomialCoefficients[n][k];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        // 배열 초기화
        binomialCoefficients = new int[n + 1][r + 1];

        int result = binomialCoefficient(n, r);
        System.out.println(result);
    }
}