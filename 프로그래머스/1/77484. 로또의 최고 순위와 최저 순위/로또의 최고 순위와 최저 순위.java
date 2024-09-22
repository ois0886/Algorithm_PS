class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int zero_num = 0;
        int win_num = 0;
        for (int lotto : lottos) {
            if (lotto == 0) zero_num++;
            else {
                for (int j = 0; j < lottos.length; j++) {
                    if (lotto == win_nums[j]) {
                        win_num++;
                    }
                }
            }
        }

        if ((win_num + zero_num) == 0) {
            answer[0] = 6;
        } else {
            answer[0] = 7 - (win_num + zero_num);
        }

        if (win_num == 0) {
            answer[1] = 6;
        } else {
            answer[1] = 7 - win_num;
        }

        return answer;
    }
}