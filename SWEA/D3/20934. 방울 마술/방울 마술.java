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
            String str = st.nextToken();
            int K = Integer.parseInt(st.nextToken());
            int bub;

            if (str.charAt(0) == 'o') {
                bub = 0;
            } else if (str.charAt(1) == 'o') {
                bub = 1;
            } else {
                bub = 2;
            }

            while (K > 0) {
                switch (bub) {
                    case 0:
                        bub = 1;
                        break;
                    case 1:
                        bub = 0;
                        break;
                    case 2:
                        bub = 1;
                        break;
                }
                K--;
            }
            
            sb.append(bub).append("\n");

        }
        System.out.println(sb);
    }
}