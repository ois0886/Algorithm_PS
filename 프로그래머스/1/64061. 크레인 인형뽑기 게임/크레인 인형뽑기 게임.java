import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int len = board[0].length;
        Stack<Integer> stack = new Stack<>();

        for (int move : moves) {
            move -= 1;
            for (int i = 0; i < len; i++) {
                if (board[i][move] != 0) {     //인형집을 위치에 인형이 있는경우 board[move][i]
                    if (!stack.isEmpty() && stack.peek() == board[i][move]) {  //지금 뽑은 인형과 마지막 인형이 같다면
                        stack.pop();
                        answer += 2;
                    } else {
                        stack.push(board[i][move]); //인형 넣기
                    }
                    board[i][move] = 0; //인형뽑았으니 0으로 세팅
                    break;
                }
            }
        }
        return answer;
    }
}