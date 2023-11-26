import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {
    private static final Map<String, Integer> memoizationMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String str = br.readLine();
            if (Objects.equals(str, "-1 -1 -1")) break;
            StringTokenizer st = new StringTokenizer(str);
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            int num3 = Integer.parseInt(st.nextToken());
            sb.append("w(").append(num1).append(", ").append(num2).append(", ").append(num3).append(") = ").append(w(num1, num2, num3)).append("\n");
        }
        System.out.println(sb);
    }

    public static int w(int a, int b, int c) {
        String key = a + "," + b + "," + c;

        if (memoizationMap.containsKey(key)) {
            return memoizationMap.get(key);
        }

        int result;

        if (a <= 0 || b <= 0 || c <= 0) {
            result = 1;
        } else if (a > 20 || b > 20 || c > 20) {
            result = w(20, 20, 20);
        } else if (a < b && b < c) {
            result = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
        } else {
            result = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
        }

        memoizationMap.put(key, result);
        return result;
    }
}