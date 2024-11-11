import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        boolean[] check = new boolean[n];

        int result = 0;

        for (int i = 0; i < n; i++) {
            if (!check[i]) {
                int max = arr[i] + l - 1;
                for (int j = i; j < n; j++) {
                    if (max >= arr[j] && !check[j]) check[j] = true;
                }
                result++;
            }
        }

        System.out.println(result);
    }
}