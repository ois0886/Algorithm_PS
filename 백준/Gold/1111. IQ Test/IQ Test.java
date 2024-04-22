import java.util.*;
import java.io.*;

class Main {

    static int N;

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        if (N == 1 || (N == 2 && arr[0] != arr[1])) {
            System.out.println("A");
            return;
        } else if (N == 2) {
            System.out.println(arr[0]);
            return;
        }

        int a;
        int b;

        if (arr[1] == arr[0]) {
            a = 1;
            b = 0;
        } else {
            a = (arr[2] - arr[1]) / (arr[1] - arr[0]);
            b = arr[1] - (arr[0] * a);
        }
        if (check(a, b)) {
            System.out.println(arr[N - 1] * a + b);
        } else {
            System.out.println("B");
        }
    }

    static boolean check(int a, int b) {
        for (int i = 0; i < N - 1; i++) {
            if (arr[i + 1] != arr[i] * a + b) {
                return false;
            }
        }
        return true;
    }

}
