class Solution {
    public String[] solution(String[] strArr) {
        int num = 0;
        for (String s : strArr) {
            if (!s.contains("ad")) {
                num++;
            }
        }
        String[] answer = new String[num];
        int index = 0;
        for (String s : strArr) {
            if (!s.contains("ad")) {
                answer[index] = s;
                index++;
            }
        }
        

        return answer;
    }
}