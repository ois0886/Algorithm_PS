import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= T; test_case++) {
            sb.append("#").append(test_case).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int ans = 0;
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int hourglass = Integer.parseInt(st.nextToken());
                for (int j = B - E; j <= B + E; j++) {
                    if (j % hourglass == 0) {
                        ans++;
                        break;
                    }
                }
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}