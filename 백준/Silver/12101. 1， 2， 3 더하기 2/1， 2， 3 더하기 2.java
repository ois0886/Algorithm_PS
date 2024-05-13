import java.util.*;
import java.io.*;

public class Main {
    static int len, N, K;
    static int[] cur = new int[11];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        search(0, 0);

        if (K != 0) {
            bw.write("-1");
        } else {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < len; i++) {
                result.append(cur[i]);
                result.append("+");
            }
            result.deleteCharAt(result.length() - 1);
            bw.write(result.toString());
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void search(int sum, int depth) {
        if (sum == N) {
            K--;
            len = depth;
            return;
        }
        for (int i = 1; i <= 3; i++) {
            if (sum + i > N || K == 0) {
                break;
            }
            cur[depth] = i;
            search(sum + i, depth + 1);
        }
    }
}