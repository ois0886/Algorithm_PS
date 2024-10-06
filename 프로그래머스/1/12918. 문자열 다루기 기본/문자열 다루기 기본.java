public class Solution {
    public boolean solution(String s) {
        // 문자열 길이가 4 또는 6인지 확인
        if (s.length() != 4 && s.length() != 6) {
            return false;
        }
        
        // 문자열이 숫자로만 이루어져 있는지 확인
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                return false;
            }
        }
        
        return true;
    }
}