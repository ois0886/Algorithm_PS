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
            String[] days = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
            int result = 0;
            for (int i = 0; i < days.length; i++) {
                if (Objects.equals(str, days[i])) {
                    result = 7 - i - 1;
                    if(result == 0){
                        result = 7;
                    }
                }
            }
            sb.append(result).append("\n");

        }
        System.out.println(sb);
    }
}