import java.io.*;
import java.util.*;

class Solution {

    static boolean[] prime = new boolean[1000001];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        prime[0] = prime[1] = true;

        for (int i = 2; i * i <= 1000000; i++) {
            if (!prime[i]) {
                for (int j = i * i; j <= 1000000; j += i) prime[j] = true;
            }
        }

        for (int test_case = 1; test_case <= T; test_case++) {
            sb.append("#").append(test_case).append(" ");
            st = new StringTokenizer(br.readLine());
            int D = Integer.parseInt(st.nextToken());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            int result = 0;

            for (int i = A; i <= B; i++) {
                if(!prime[i]){
                    String str = String.valueOf(i);
                    if(str.contains(String.valueOf(D))){
                        result++;
                    }
                }
            }
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}