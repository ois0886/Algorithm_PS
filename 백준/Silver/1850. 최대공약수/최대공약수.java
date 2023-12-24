import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long num1 = Long.parseLong(st.nextToken());
        long num2 = Long.parseLong(st.nextToken());

        long gcd = getGCD(Math.max(num1, num2), Math.min(num1, num2));

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= gcd; i++) sb.append("1");

        System.out.println(sb);

    }

    public static long getGCD(long a, long b) {
        while (b > 0) {
            long tmp = a;
            a = b;
            b = tmp % b;
        }
        return a;
    }
}

