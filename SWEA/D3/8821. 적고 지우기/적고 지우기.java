import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= T; test_case++) {
            sb.append("#").append(test_case).append(" ");
            String str = br.readLine();
            HashSet<Integer> set = new HashSet<>();
            for (int i = 0; i < str.length(); i++) {
                int num = str.charAt(i) - '0';
                if(set.contains(num)){
                    set.remove(num);
                } else{
                    set.add(num);
                }
            }
            sb.append(set.size()).append("\n");
        }
        System.out.println(sb);
    }
}