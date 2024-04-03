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
            String answer = "YES";
            int half = str.length() / 2;

            for (int i = 0; i < half / 2; i++) {
                if (str.charAt(i) != str.charAt(half- 1 - i)) {
                    answer = "NO";
                    break;
                }
            }
            for (int i = half; i < str.length(); i++) {
                if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                    answer = "NO";
                    break;
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}