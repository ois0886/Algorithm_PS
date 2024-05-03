import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= T; test_case++) {
            sb.append("#").append(test_case).append(" ");
            String handclap = br.readLine();
            int hire = calculation(handclap);
            sb.append(hire).append("\n");
        }
        System.out.println(sb);
    }

    private static int calculation(String handclap) {
        int sum = 0;
        int hire = 0;

        for (int i = 0; i < handclap.length(); i++) {
            int num = handclap.charAt(i) - '0';
            if (num > 0) {
                if (i <= sum)
                    sum += num;
                else {
                    hire += (i - sum);
                    sum += (i - sum);
                    sum += num;
                }
            }
        }
        return hire;
    }

}