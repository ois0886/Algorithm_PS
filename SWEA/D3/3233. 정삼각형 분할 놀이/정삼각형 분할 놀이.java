import java.io.*;
import java.math.BigInteger;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= T; test_case++) {
            sb.append("#").append(test_case).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            BigInteger a = BigInteger.valueOf(Integer.parseInt(st.nextToken()));
            BigInteger b = BigInteger.valueOf(Integer.parseInt(st.nextToken()));
            BigInteger result = (a.multiply(a)).divide(b.multiply(b));
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}