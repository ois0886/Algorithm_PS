import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        try {

            while (true) {
                long X = Long.parseLong(br.readLine()) * 10000000;
                int N = Integer.parseInt(br.readLine());
                long[] arr = new long[N];

                for (int i = 0; i < N; i++) {
                    long num = Long.parseLong(br.readLine());
                    arr[i] = num;
                }

                Arrays.sort(arr);

                int left = 0;
                int right = N - 1;
                boolean flag = false;
                while (left < right) {
                    if (X == arr[left] + arr[right]) {
                        System.out.println("yes " + arr[left] + " " + arr[right]);
                        flag = true;
                        break;
                    } else {
                        if (arr[left] + arr[right] > X) {
                            right--;
                        }
                        if (arr[left] + arr[right] < X) {
                            left++;
                        }
                    }

                }
                if (!flag) {
                    System.out.println("danger");
                }
            }

        } catch (Exception e) {
            System.out.println();
        }
    }
}
