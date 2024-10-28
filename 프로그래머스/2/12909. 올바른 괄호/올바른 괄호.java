
import java.util.Stack;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            String str = String.valueOf(s.charAt(i));
            if (str.equals("(")) stack.push(str);
            else if(str.equals(")")){
                if(stack.isEmpty()) stack.push(str);
                else{
                    if(stack.peek().equals("(")) stack.pop();
                }
            }

        }
        if (!stack.isEmpty()) answer = false;

        return answer;
    }
}