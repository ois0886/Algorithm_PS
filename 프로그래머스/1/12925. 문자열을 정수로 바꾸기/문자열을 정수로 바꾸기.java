class Solution {
    public int solution(String s) {
        int answer = 0;
        String str = s;
        if (s.contains("-")) {
            str = s.replace("-", "");
            answer = Integer.parseInt(str);
            answer *= -1;
        } else {
            answer = Integer.parseInt(str);
        }


        return answer;
    }
}