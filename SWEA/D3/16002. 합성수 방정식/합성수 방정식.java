import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= T; test_case++) {
            sb.append("#").append(test_case).append(" ");
            int n = Integer.parseInt(br.readLine());

            int cnt = 3;
            while (true) {
                if (!isPrime(cnt) && !isPrime(cnt + n)) {
                    sb.append(cnt + n).append(" ").append(cnt);
                    break;
                }
                cnt += 1;
            }

            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static boolean isPrime(int num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}