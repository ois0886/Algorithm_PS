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
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            boolean check = true;
            for(int i = 0; i < n; i++){
                if(m % 2 == 0) {
                    check = false;
                    break;
                } else{
                    m /= 2;
                }
            }
            if(check) sb.append("ON").append("\n");
            else sb.append("OFF").append("\n");
        }
        System.out.println(sb);
    }
}