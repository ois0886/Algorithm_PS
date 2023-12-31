class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        int patLength = pat.length();
        for (int i = 0; i < myString.length(); i++) {
            if (myString.charAt(i) == pat.charAt(0) && myString.length() >= i + patLength) {
                String temp = myString.substring(i, i + patLength);
                if (temp.equals(pat)) answer++;
            }
        }

        return answer;
    }
}