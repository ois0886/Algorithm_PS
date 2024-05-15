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
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            HashSet<String> set = new HashSet<>();
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < num1; i++){
                set.add(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < num2; i++){
                set.add(st.nextToken());
            }
            sb.append(num1 + num2 - set.size()).append("\n");
        }
        System.out.println(sb);
    }
}