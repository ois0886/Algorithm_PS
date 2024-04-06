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
            String temp = str.replace("a", "");
            temp = temp.replace("e", "");
            temp = temp.replace("i", "");
            temp = temp.replace("o", "");
            String result = temp.replace("u", "");
            sb.append(result).append("\n");

        }
        System.out.println(sb);
    }
}