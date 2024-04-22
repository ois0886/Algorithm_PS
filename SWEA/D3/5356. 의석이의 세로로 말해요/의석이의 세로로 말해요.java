import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= T; test_case++) {
            sb.append("#").append(test_case).append(" ");
            String[] arr = new String[5];
            
            for (int i = 0; i < 5; i++) {
                arr[i] = br.readLine();
            }

            int max = 0;
            for(int i = 0; i < 5; i++){
                max = Math.max(max, arr[i].length());
            }

            for (int i = 0; i < max; i++) {
                for (int j = 0; j < 5; j++) {
                    if(arr[j].length() <= i){
                        continue;
                    }
                    sb.append(arr[j].charAt(i));
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}