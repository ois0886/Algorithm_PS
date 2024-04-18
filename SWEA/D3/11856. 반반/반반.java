import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= T; test_case++) {
            sb.append("#").append(test_case).append(" ");
            HashSet<Character> set = new HashSet<>();
            String str = br.readLine();
            String result = "Yes";
            char ch = str.charAt(0);
            int check = 0;
            for (int i = 0; i < 4; i++) {
                set.add(str.charAt(i));
                if (ch == str.charAt(i)) {
                    check++;
                }
            }

            if (set.size() != 2) result = "No";
            if (check != 2) result = "No";

            sb.append(result).append("\n");

        }
        System.out.println(sb);
    }
}