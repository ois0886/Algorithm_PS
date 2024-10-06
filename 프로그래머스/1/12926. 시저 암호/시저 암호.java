class Solution {
    public String solution(String s, int n) {
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // 대문자일 경우
            if (ch >= 'A' && ch <= 'Z') {
                ch = (char) ((ch - 'A' + n) % 26 + 'A');
            }
            // 소문자일 경우
            else if (ch >= 'a' && ch <= 'z') {
                ch = (char) ((ch - 'a' + n) % 26 + 'a');
            }
            // 공백일 경우 그대로 추가
            answer.append(ch);
        }

        return answer.toString();
    }
}
