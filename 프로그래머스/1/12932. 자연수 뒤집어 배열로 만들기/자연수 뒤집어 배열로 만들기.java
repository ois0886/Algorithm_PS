
class Solution {
    public int[] solution(long n) {
        int[] answer = new int[String.valueOf(n).length()];
        String str = String.valueOf(n);
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        String[] arr = sb.toString().split("");
        for (int i = 0; i < answer.length; i++) {
            answer[i] = Integer.parseInt(arr[i]);
        }
        return answer;
    }
}