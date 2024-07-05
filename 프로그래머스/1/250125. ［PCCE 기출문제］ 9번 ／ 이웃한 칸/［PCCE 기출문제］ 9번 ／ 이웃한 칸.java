class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;

        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};

        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + h;
            int ny = dy[i] + w;
            if (0 <= nx && nx < board.length && 0 <= ny && ny < board[0].length) {
                if (board[h][w].equals(board[nx][ny])) {
                    answer += 1;
                }
            }
        }
        return answer;
    }
}