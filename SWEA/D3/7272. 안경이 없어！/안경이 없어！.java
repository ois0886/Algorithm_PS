import java.io.*;
import java.util.*;

class Solution {

    static String str1 = "CEFGHIJKLMNSTUVWXYZ";
    static String str2 = "ADOPQR";
    static String str3 = "B";

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= T; test_case++) {
            sb.append("#").append(test_case).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine());

            String case1 = st.nextToken();
            String case2 = st.nextToken();

            if (case1.length() != case2.length()) {
                sb.append("DIFF").append("\n");
            } else {
                boolean check = true;
                for (int i = 0; i < case1.length(); i++) {
                    if (str1.contains(String.valueOf(case1.charAt(i)))) {
                        if (!str1.contains(String.valueOf(case2.charAt(i)))) {
                            check = false;
                        }
                    } else if (str2.contains(String.valueOf(case1.charAt(i)))) {
                        if (!str2.contains(String.valueOf(case2.charAt(i)))) {
                            check = false;
                        }
                    } else if (str3.contains(String.valueOf(case1.charAt(i)))) {
                        if (!str3.contains(String.valueOf(case2.charAt(i)))) {
                            check = false;
                        }
                    }
                }
                if (!check) {
                    sb.append("DIFF").append("\n");
                } else {
                    sb.append("SAME").append("\n");
                }

            }
        }
        System.out.println(sb);
    }
}