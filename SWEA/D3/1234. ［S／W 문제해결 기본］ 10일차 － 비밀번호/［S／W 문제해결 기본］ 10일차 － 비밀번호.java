import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= 10; test_case++) {
            sb.append("#").append(test_case).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            String str = st.nextToken();

            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < str.length(); i++) {
                if (stack.isEmpty()) {
                    stack.push(str.charAt(i) - '0');
                } else {
                    int num = stack.peek();
                    if (str.charAt(i) - '0' == num) {
                        stack.pop();
                    } else {
                        stack.push(str.charAt(i) - '0');
                    }
                }
            }

            for (int i = 0; i < stack.size(); i++) {
                sb.append(stack.get(i));
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}