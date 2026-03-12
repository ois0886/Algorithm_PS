import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        String[] parts = br.readLine().split(",");
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(parts[i]);
        }

        while (K > 0) {
            int[] temp = new int[arr.length - 1];
            for (int i = 0; i < arr.length - 1; i++) {
                temp[i] = arr[i + 1] - arr[i];
            }
            arr = temp;
            K--;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (i > 0) sb.append(",");
            sb.append(arr[i]);
        }
        System.out.println(sb);

    }

}