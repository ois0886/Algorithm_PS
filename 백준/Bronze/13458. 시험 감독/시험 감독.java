import java.util.*;
import java.io.*;

class Main {

    static int n;
    static int b, c;

    static int[] arr;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        long result = 0;

        for (int i = 0; i < n; i++) {
            int num = arr[i];
            num -= b;
            result += 1;
            if (num <= 0) continue;
            result += (num / c);
            if (num % c != 0) result += 1;
        }
        System.out.println(result);

    }
}