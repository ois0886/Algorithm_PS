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
            String str = br.readLine();
            while(str.length() > 1){
                int temp = 0;
                for(int i = 0; i < str.length(); i++){
                    temp += Integer.parseInt(String.valueOf(str.charAt(i)));
                }
                str = String.valueOf(temp);
            }
            sb.append(str).append("\n");
        }
        System.out.println(sb);
    }
}