import java.io.*;
import java.util.*;

class Solution {

    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= T; test_case++) {
            sb.append("#").append(test_case).append(" ");
            String numStr = br.readLine();
            char[] numList = numStr.toCharArray();
            Arrays.sort(numList);

            boolean flag = false;
            int k = 2;
            while (true) {
                long multiNum = Long.parseLong(numStr) * k;
                if (String.valueOf(multiNum).length() > numStr.length()) {
                    break;
                }

                char[] multiNumList = String.valueOf(multiNum).toCharArray();
                Arrays.sort(multiNumList);

                if (Arrays.equals(multiNumList, numList)) {
                    flag = true;
                    break;
                }

                k++;
            }

            String answer = flag ? "possible" : "impossible";
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}