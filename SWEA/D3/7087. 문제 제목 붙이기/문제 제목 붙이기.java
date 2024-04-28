import java.io.*;
import java.util.*;

class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= T; test_case++) {
            sb.append("#").append(test_case).append(" ");
            int n = Integer.parseInt(br.readLine());
            boolean[] check = new boolean[26];
            for(int i = 0; i < n; i++){
                String str = br.readLine();
                check[str.charAt(0)-'A'] = true;
            }
            int result = 0;
            for(int i = 0; i < 26; i++){
                if(!check[i]) {
                    break;
                }
                result++;
            }
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}