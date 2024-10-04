class Solution {
    public String solution(String phone_number) {
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < phone_number.length(); i++) {
            if (phone_number.length() - 5 < i && phone_number.length() - 1 >= i) {
                answer.append(phone_number.charAt(i));
            } else {
                answer.append("*");
            }
        }
        return answer.toString();
    }
}