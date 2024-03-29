import java.util.*;

class Solution {
    public int solution(String[] strArr) {
        int answer = 0;
        int [] temp = new int[31];
        for(int i = 0; i < strArr.length; i++){
            temp[strArr[i].length()]++;
        }
        Arrays.sort(temp);
        answer = temp[30];

        return answer;
    }
}