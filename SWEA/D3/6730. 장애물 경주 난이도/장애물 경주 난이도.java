import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= T; test_case++) {
            sb.append("#").append(test_case).append(" ");
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int up = 0;
            int down = 0;
            for (int i = 0; i < N - 1; i++) {
                if (arr[i] < arr[i + 1]) {
                    int temp = arr[i + 1] - arr[i];
                    if (temp > up) {
                        up = temp;
                    }
                }
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i] - arr[i + 1];
                    if (temp > down) {
                        down = temp;
                    }
                }
            }
            sb.append(up).append(" ").append(down).append("\n");
        }
        System.out.println(sb);
    }
}