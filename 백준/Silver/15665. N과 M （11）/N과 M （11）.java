import java.util.*;
import java.io.*;

public class Main {

    static int[] arr;
    static int[] output;

    static int N;

    static int M;

    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        output = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        sb = new StringBuilder();
        Arrays.sort(arr);
        perm( 0);
        System.out.println(sb);

    }

    static void perm(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(output[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        int before = -1;
        for (int i = 0; i < N; i++) {
            int now = arr[i];
            if (before != now) {
                before = now;
                output[depth] = arr[i];
                perm(depth + 1);
            }
        }
    }
}

