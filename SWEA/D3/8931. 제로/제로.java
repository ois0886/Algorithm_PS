
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
            int sum = 0;
            Stack<Integer> stack = new Stack<>();
            for(int i = 0; i < n ; i++){
                int num = Integer.parseInt(br.readLine());
                if(num != 0){
                    stack.push(num);
                } else{
                    if(!stack.isEmpty()){
                        stack.pop();
                    }
                }
            }
            while(!stack.isEmpty()){
                sum += stack.pop();
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}