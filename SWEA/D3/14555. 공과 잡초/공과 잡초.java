import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= T; test_case++) {
            sb.append("#").append(test_case).append(" ");
            char[] ch = br.readLine().toCharArray();
            char temp = ch[0];
            int result = 0;

            int len = ch.length;
            for (int i = 1; i < len; i++) {
                String str = Character.toString(temp) + Character.toString(ch[i]);

                if (str.equals("(|") || str.equals("|)")) {
                    result++;
                } else if (str.equals("()")) result++;

                temp = ch[i];
            }

            sb.append(result).append('\n');
        }
        System.out.println(sb);
    }
}