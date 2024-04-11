import java.util.*;
import java.io.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        String str = s.toLowerCase();
        int p_num = 0;
        int y_num = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'p') {
                p_num++;
            }
            if (str.charAt(i) == 'y') {
                y_num++;
            }
        }

        if (p_num != y_num) {
            answer = false;
        }

        return answer;
    }
}