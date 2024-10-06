import java.util.Collections;
import java.util.LinkedList;

class Solution {
    public long solution(long n) {
        long answer = 0;
        String[] num = String.valueOf(n).split("");
        LinkedList<Integer> arr = new LinkedList<>();
        for (int i = 0; i < num.length; i++) {
            arr.add(Integer.parseInt(num[i]));
        }
        arr.sort(Collections.reverseOrder());
        
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < num.length; i++){
            str.append(arr.get(i));
        }

        answer = Long.parseLong(str.toString());

        return answer;
    }
}