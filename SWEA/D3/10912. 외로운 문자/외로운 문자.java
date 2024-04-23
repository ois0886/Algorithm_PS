import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= T; test_case++) {
            sb.append("#").append(test_case).append(" ");
            char[] arr = br.readLine().toCharArray();
            Arrays.sort(arr);
            Stack<Character> stack = new Stack<>();
            for (char c : arr) {
                if (stack.isEmpty()) {
                    stack.push(c);
                } else {
                    if (stack.peek() == c) {
                        stack.pop();
                    } else {
                        stack.push(c);
                    }
                }
            }

            if (stack.isEmpty()) {
                sb.append("Good");
            } else {
                for (Character character : stack) {
                    sb.append(character);
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}