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
            StringBuilder answer = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == 'b') {
                    answer.append("d");
                } else if (str.charAt(i) == 'd') {
                    answer.append("b");
                } else if (str.charAt(i) == 'p') {
                    answer.append("q");
                } else {
                    answer.append("p");
                }
            }
            String temp = answer.reverse().toString();
            sb.append(temp).append("\n");
            
        }
        System.out.println(sb);
    }
}