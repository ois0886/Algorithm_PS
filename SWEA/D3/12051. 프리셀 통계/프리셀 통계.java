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
            st = new StringTokenizer(br.readLine());
            long D = Long.parseLong(st.nextToken());
            int pD = Integer.parseInt(st.nextToken());
            int pG = Integer.parseInt(st.nextToken());
            boolean check = false;
            if (pD != 0 && pG == 0) {
                sb.append("Broken").append("\n");
            } else if (pD != 100 && pG == 100) {
                sb.append("Broken").append("\n");
            } else {
                while (D > 0) {
                    if ((D * pD) % 100 == 0) {
                        check = true;
                        break;
                    }
                    D--;
                }
                if (!check) {
                    sb.append("Broken").append("\n");
                } else {
                    sb.append("Possible").append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}