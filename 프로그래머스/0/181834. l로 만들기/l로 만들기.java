import java.util.*;
import java.io.*;

class Solution {
    public String solution(String myString) {
        HashSet<Character> set = new HashSet<>(){{
            add('a');
            add('b');
            add('c');
            add('d');
            add('e');
            add('f');
            add('g');
            add('h');
            add('i');
            add('j');
            add('k');
        }};
        
        String answer;
        char[] strs = myString.toCharArray();
        for(int i = 0; i < strs.length; i++){
            if(set.contains(strs[i])){
                strs[i] = 'l';
            }
        }
        answer = String.valueOf(strs);


        return answer;
    }
}