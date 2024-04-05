import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= T; test_case++) {
            sb.append("#").append(test_case).append(" ");
            String number = br.readLine();
            long min = Long.parseLong(number);
            long max = Long.parseLong(number);
            for (int i = 0; i < number.length(); i++) {
                for (int j = i + 1; j < number.length(); j++) {
                    char[] chars = number.toCharArray();
                    char temp = chars[i];
                    chars[i] = chars[j];
                    chars[j] = temp;
                    String tempNumber = String.valueOf(chars);
                    if (tempNumber.charAt(0) != '0') {
                        if (min > Long.parseLong(tempNumber)) {
                            min = Long.parseLong(tempNumber);
                        }
                        if (max < Long.parseLong(tempNumber)) {
                            max = Long.parseLong(tempNumber);
                        }
                    }
                }
            }
            sb.append(min).append(" ").append(max).append("\n");
        }
        System.out.println(sb);
    }
}