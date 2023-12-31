import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int[] result = twoPoint();
        System.out.println(result[0] + " " + result[1]);
    }

    private static int[] twoPoint() {
        int[] result = new int[2];
        int start = 0;
        int end = N - 1;
        result[0] = arr[start];
        result[1] = arr[end];
        while (start < end) {
            int middle = arr[start] + arr[end];
            if (middle == 0) {
                result[0] = arr[start];
                result[1] = arr[end];
                break;
            }
            if (Math.abs(result[0] + result[1]) > Math.abs(middle)) {
                result[0] = arr[start];
                result[1] = arr[end];

            }
            if (middle > 0) {
                end--;
            } else {
                start++;
            }

        }
        Arrays.sort(result);
        return result;
    }
}