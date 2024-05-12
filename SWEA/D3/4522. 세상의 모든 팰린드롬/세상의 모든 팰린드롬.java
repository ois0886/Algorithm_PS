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
            if (Pallindrom(str)) {
                sb.append("Exist").append("\n");
            } else {
                sb.append("Not exist").append("\n");
            }
        }
        System.out.println(sb);
    }

    private static boolean Pallindrom(String str) {
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != '?' && str.charAt(str.length() - i - 1) != '?') {
                if (str.charAt(i) != str.charAt(str.length() - i - 1)){
                    return false;
                }
            }
        }
        return true;
    }
}