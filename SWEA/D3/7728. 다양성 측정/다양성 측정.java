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
            char[] str = br.readLine().toCharArray();
            for (char c : str) {
                set.add(c);
            }
            sb.append(set.size()).append("\n");

        }
        System.out.println(sb);
    }
}