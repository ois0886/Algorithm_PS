import java.io.*;
import java.util.*;

class Solution {

    static int[] first_day = {0, 4, 0, 1, 4, 6, 2, 4, 0, 3, 5, 1, 3};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= T; test_case++) {
            sb.append("#").append(test_case).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int day = 1;
            int result = first_day[m];
            while (day != d) {
                result += 1;
                day += 1;
                if (result > 6) result = 0;
            }
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}