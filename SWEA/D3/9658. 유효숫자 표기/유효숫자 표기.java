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
            String[] num = br.readLine().split("");
            int second = Integer.parseInt(num[2]);
            int zero = Integer.parseInt(num[0]);
            int first = Integer.parseInt(num[1]);
            String result = zero + "." + first;

            int length = num.length - 1;

            if(second >= 5){
                first += 1;
                if(first >= 10){
                    first = 0;
                    zero += 1;
                    if(zero >= 10){
                        first = zero % 10;
                        zero = 1;
                        length += 1;
                    }
                }
                result = zero + "." + first;

            }
            sb.append(result).append("*").append("10^").append(length).append("\n");
        }
        System.out.println(sb);
    }
}