import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= T; test_case++) {
            sb.append("#").append(test_case).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int result = 0;
            for (int i = start; i <= end; i++) {
                double sqrtN = Math.sqrt(i);
                //소수점 검사
                if (sqrtN == Math.floor(sqrtN)) {
                    if (palindrom(i) && palindrom((int) sqrtN)) {
                        result++;
                    }
                }
            }

            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }

    private static boolean palindrom(int number) {
        String str = String.valueOf(number);
        boolean check = true;
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1)) {
                check = false;
                break;
            }
        }

        return check;
    }

}