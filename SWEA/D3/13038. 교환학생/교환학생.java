import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int test_case = 1; test_case <= T; test_case++) {
            sb.append("#").append(test_case).append(" ");
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] days = new int[7];
            for (int i = 0; i < 7; i++) {
                days[i] = Integer.parseInt(st.nextToken());
            }

            int min = Integer.MAX_VALUE;
            for (int i = 0; i < 7; i++) {
                if (days[i] == 1) {
                    int start = i;
                    int cnt = 0;

                    while (true) {
                        if (days[start % 7] == 1)
                            cnt++;
                        start++;
                        if (cnt == n) {
                            min = Math.min(min, start - i);
                            break;
                        }
                    }
                }
            }
            sb.append(min).append("\n");

        }
        System.out.println(sb);
    }
}